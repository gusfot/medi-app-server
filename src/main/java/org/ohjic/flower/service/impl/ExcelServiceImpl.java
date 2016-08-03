package org.ohjic.flower.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.ohjic.flower.model.Board;
import org.ohjic.flower.service.ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExcelServiceImpl implements ExcelService  {

	private static final Logger logger = LoggerFactory.getLogger(ExcelServiceImpl.class);

	@Resource(name = "flowerProperties")
	private Properties flowerProperties;

	public boolean excelUpload(MultipartFile file, HttpServletRequest request) {
		
		boolean flag = false;

		//DB와 연계될 객체 Board 클래스 생성
		ArrayList<Board> boardList = new ArrayList<>();
		//파일이 있으면 작업
		if (file != null && file.getSize() > 0) {
			try {
				//파일의 데이터를  workbook에 씀
				Workbook wb = new HSSFWorkbook(file.getInputStream());
				//데이터 sheet 생성
				Sheet sheet = wb.getSheetAt(0);
				//데이터 sheet 행 개수 구함
				int last = sheet.getLastRowNum();
				logger.info("Last : " + last);
				//행 개수만큼 돌아가며 작업
				for(int i=1; i<=last; i++){
					Row row = sheet.getRow(i);
					Board board = new Board();
					
					String title = row.getCell(1, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					
					//엑셀에 데이터가 있는 확인 후 객체에 데이터 담는 작업
					if(!title.equals("") && title != null){
						board.setBoardSeq(row.getCell(0, Row.CREATE_NULL_AS_BLANK).getRowIndex()-1);
						board.setTitle(title);
						board.setContent(row.getCell(2, Row.CREATE_NULL_AS_BLANK).getStringCellValue());
						board.setWriter(row.getCell(3, Row.CREATE_NULL_AS_BLANK).getStringCellValue());
						board.setRegTime(row.getCell(4, Row.CREATE_NULL_AS_BLANK).getDateCellValue());
						boardList.add(board);	
					}
					logger.info("Seq : " + board.getBoardSeq());
					logger.info("Title : " + board.getTitle());
					logger.info("Content : " + board.getContent());
					logger.info("Writer : " + board.getWriter());
					logger.info("Date : " + board.getRegTime());
				}
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		logger.info("엑셀 객체 삽입 성공!!");
		flag = true;
		
		//DB에 넣는 부분
//		flag = service.insertExcel(boardList);
//		mav.addObject("boardList", service.getBoard());
		
		return flag;
	}
}




//	@Override
//	public boolean excelDownload() throws IOException {
//
//		boolean flag = false;
//
//		//DB조회후 목록을 담을 LIST 객체
//		ArrayList<Board> boardList = new ArrayList<>();
//
//		//DB조회후 객체에 담는 데이터
//		for(int i=0; i<10; i++){
//			Board board = new Board();
//			board.setBoardSeq(i);
//			board.setTitle("제목입니다"+i);
//			board.setContent("내용입니다"+i);
//			board.setWriter("작성자"+i);
//			board.setRegTime(new Date());
//			boardList.add(board);
//		}
//		
//		//1차로 workbook을 생성
//		HSSFWorkbook wb = new HSSFWorkbook();
//		//2차는 sheet생성
//		HSSFSheet sheet = wb.createSheet("시트명");
//		//엑셀의 행
//		HSSFRow row = null;
//		//엑셀의 셀
//		HSSFCell cell = null;
//		//첫번재 row에 column명 작성
//		row = sheet.createRow(0);
//		row.createCell(0).setCellValue("boardSeq");
//		row.createCell(1).setCellValue("title");
//		row.createCell(2).setCellValue("content");
//		row.createCell(3).setCellValue("writer");
//		row.createCell(4).setCellValue("regTime");
//		//엑셀 sheet와 cell 생성하며 데이터 입력
//		for (int i = 0; i < boardList.size(); i++) {
//			row = sheet.createRow(i+1);
//			//row 생성하고 객체에 담긴 데이터를 가져와 cell에 add
//			row.createCell(0).setCellValue(String.valueOf(boardList.get(i).getBoardSeq()));;
//			row.createCell(1).setCellValue(String.valueOf(boardList.get(i).getTitle()));
//			row.createCell(2).setCellValue(String.valueOf(boardList.get(i).getContent()));
//			row.createCell(3).setCellValue(String.valueOf(boardList.get(i).getWriter()));
//			row.createCell(4).setCellValue(String.valueOf(boardList.get(i).getRegTime()));
//		}
//		
//		long x = System.currentTimeMillis();
//		//서버에 경로 생성
//		FileOutputStream fileoutputstream = new FileOutputStream("D:\\excelFile\\keon_"+x+".xls");
//		//서버 경로에 파일을 씀
//		wb.write(fileoutputstream);
//		//파일 다 쓰고 필수로 닫아주어야 함
//		fileoutputstream.close();
//		logger.info(">>>>>>>>>>>>>> 엑셀파일 서버 생성 성공");
//		flag = true;
//		
//		return flag;
//	}
	
	

//	 // Excel 2007(.xlsx) 이상 파일처리
//    public void readExcel2007( String excel ) throws IOException {
//        // check file
//        File file = new File( excel );
//        if( !file.exists() || !file.isFile() || !file.canRead() ) {
//            throw new IOException( excel );
//        }
//
//        // http://poi.apache.org/apidocs/index.html?overview-summary.html
//        // http://poi.apache.org/apidocs/org/apache/poi/xssf/usermodel/XSSFWorkbook.html
//        XSSFWorkbook wb = new XSSFWorkbook( new FileInputStream(file) );
//        try {
//            for( int i=0; i<wb.getNumberOfSheets(); i++ ) {
//                for( Row row : wb.getSheetAt(i) ) {
//                    for( Cell cell : row ) {
//                        switch( cell.getCellType() ) {
//                            case XSSFCell.CELL_TYPE_STRING:
//                                cell.getRichStringCellValue().getString();
//                                break;
//                            case XSSFCell.CELL_TYPE_NUMERIC:
//                                if( HSSFDateUtil.isCellDateFormatted(cell) ) {
//                                    java.util.Date dateValue = cell.getDateCellValue();
//                                    Integer year = dateValue.getYear(); // or getYear
//                                    if (year != -1) dateFormat.format(dateValue);
//                                    else timeFormat.format(dateValue);
//                                }
//                                else {
//                                    Double.valueOf( cell.getNumericCellValue() ).intValue();
//                                }
//                                break;
//                            case XSSFCell.CELL_TYPE_FORMULA:
//                                cell.getCellFormula();  break;
//                            case XSSFCell.CELL_TYPE_BOOLEAN:
//                                cell.getBooleanCellValue();  break;
//                            case XSSFCell.CELL_TYPE_ERROR:
//                                cell.getErrorCellString();
//                                cell.getErrorCellValue();  break;
//                            case XSSFCell.CELL_TYPE_BLANK: break;
//                            default: break;
//                        }
//                    }
//                }
//            }
//        } catch( Exception ex ) {
//            ex.printStackTrace();
//        }
//    }
//
//
//    // Excel 97~2003(.xls) 파일처리
//    public void readExcel( String excel ) throws IOException {
//        // check file
//        File file = new File( excel );
//        if( !file.exists() || !file.isFile() || !file.canRead() ) {
//            throw new IOException( excel );
//        }
//
//        // http://poi.apache.org/apidocs/index.html?overview-summary.html
//        // http://poi.apache.org/apidocs/org/apache/poi/hssf/usermodel/HSSFWorkbook.html
//        HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
//        try {
//            for( int i=0; i<wb.getNumberOfSheets(); i++ ) {
//                for( Row row : wb.getSheetAt(i) ) {
//                    for( Cell cell : row ) {
//                        switch( cell.getCellType() ) {
//                            case HSSFCell.CELL_TYPE_STRING:
//                                cell.getRichStringCellValue().getString();
//                                break;
//                            case HSSFCell.CELL_TYPE_NUMERIC:
//                                if( HSSFDateUtil.isCellDateFormatted(cell) ) {
//                                    java.util.Date dateValue = cell.getDateCellValue();
//                                    Integer year = dateValue.getYear(); // or getYear
//                                    if (year != -1) dateFormat.format(dateValue);
//                                    else timeFormat.format(dateValue);
//                                }
//                                else {
//                                    Double.valueOf( cell.getNumericCellValue() ).intValue();
//                                }
//                                break;
//                            case HSSFCell.CELL_TYPE_FORMULA:
//                                cell.getCellFormula();  break;
//                            case HSSFCell.CELL_TYPE_BOOLEAN:
//                                cell.getBooleanCellValue();  break;
//                            case HSSFCell.CELL_TYPE_ERROR:
//                                cell.getErrorCellValue();  break;
//                            case HSSFCell.CELL_TYPE_BLANK: break;
//                            default: break;
//                        }
//                    }
//                }
//            }
//        } catch( Exception ex ) {
//            ex.printStackTrace();
//        }
        

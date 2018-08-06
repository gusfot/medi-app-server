<%
/*###################################################
#   @ 소스 관리시 주의 사항
#       [RealCode]  : 실서비스용 코드 검색 키워드
#       [TestCode]  : 테스트서비스용 코드 검색 키워드
#       [Modify]    : 페이지마다 수정해야할 공통 변수
#
###################################################*/

/**************************************************************************************************************************
* Service Name  : ICERT
* Program Name  : 본인인증서비스(웹통신CI방식) 샘플 페이지
* File Name     : kmcis_webc_sample_step04.jsp
* Comment       :
* History       :
**************************************************************************************************************************/
%>
<%
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma", "no-store");
	response.setHeader("Cache-Control", "no-cache");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "java.net.*" %>
<%@ page import = "java.io.*" %>
<%
		//입력값 변수--------------------------------------------------------------------------------------------
		String tr_cert   = "";

        String certNum   = request.getParameter("certNum");		//요청번호
        String smsNum    = request.getParameter("smsNum");		//본인인증번호
        String check_1   = request.getParameter("check_1");		//확인용 파라미터1
        String check_2   = request.getParameter("check_2");	    //확인용 파라미터2
        String check_3   = request.getParameter("check_3");		//확인용 파라미터3
		String extendVar = "0000000000000000";                  //확장변수
		//-------------------------------------------------------------------------------------------------------

		/** 요청번호(certNum) 주의사항 ****************************************************************************
		* 1. 본인인증 결과값 복호화를 위한 키로 활용되므로 중요함.
		* 2. 본인인증 요청시 중복되지 않게 생성해야함. (예-시퀀스번호)
		***********************************************************************************************************/

		//01. 한국모바일인증(주) 암호화 모듈 선언
	    com.icert.comm.secu.IcertSecuManager seed  = new com.icert.comm.secu.IcertSecuManager();

		//02. 1차 암호화 (tr_cert 데이터변수 조합 후 암호화)
		String enc_tr_cert = "";
		tr_cert     = certNum +"/"+ smsNum +"/"+ check_1 +"/"+ check_2 +"/"+ check_3 +"/"+ extendVar;
		enc_tr_cert = seed.getEnc(tr_cert, "");

		//03. 1차 암호화 데이터에 대한 위변조 검증값 생성 (HMAC)
		String hmacMsg = "";
        hmacMsg = seed.getMsg(enc_tr_cert);

		//04. 2차 암호화 (1차 암호화 데이터, HMAC 데이터, extendVar 조합 후 암호화)
		tr_cert  = seed.getEnc(enc_tr_cert +"/"+ hmacMsg +"/"+ extendVar, "");

		//05. 본인인증요청 URL로 암호화 데이터 넘기기
        String send_url = "https://www.kmcert.com/kmcis/webc_CI/kmcisRetProc.jsp?tr_cert="+tr_cert;

		//06. URL로 암호화 값 보내고 암호화된 결과 받기
        URL url = null;
        BufferedReader in = null;
        URLConnection con = null;

        String rec_cert = "";
        String urlstr   = send_url;
        try {
            url = new URL(urlstr);
            con = url.openConnection();
            con.connect();
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String tmp_msg = "";
            while ((tmp_msg = in.readLine()) != null) {
                if (!"".equals(tmp_msg)) {
                    rec_cert = tmp_msg;
                }
            }
        } catch (MalformedURLException malformedurlexception) {
            rec_cert = "URL Error("+malformedurlexception+")";
%>
            본인인증서비스(웹통신CI방식) 에러 (<%=rec_cert%>)
<%
	       return;
        } catch (IOException ioexception) {
            rec_cert = "IO Error("+ioexception+")";
%>
            본인인증서비스(웹통신CI방식) 에러 (<%=rec_cert%>)
<%
	       return;
		} finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception ex3) {
                System.out.println(ex3.toString());
            }
        }

        try {
			//결과값 변수--------------------------------------------------------------------------------------------
            String encPara      = ""; //암호화된 통합 파라미터
            String encMsg1      = ""; //암호화된 통합 파라미터의 Hash값
			String encMsg2      = ""; //암호화된 통합 파라미터의 Hash값 비교를 위한 Hash값

			String msgChk       = "";
			String r_certNum    = ""; //요청번호
			String r_CI			= ""; //연계정보(CI)
			String r_DI			= ""; //중복가입확인정보(DI)
			String r_result     = ""; //인증결과값
			String r_resultCode = ""; //인증결과코드
			String r_check_1    = ""; //인증번호 확인결과 전송 및 SMS재전송 요청을 위한 파라미터 1(수정불가)
			String r_check_2    = ""; //인증번호 확인결과 전송 및 SMS재전송 요청을 위한 파라미터 2(수정불가)
			String r_check_3    = ""; //인증번호 확인결과 전송 및 SMS재전송 요청을 위한 파라미터 3(수정불가)
			//-------------------------------------------------------------------------------------------------------

			//07. rec_cert 정상/비정상 체크
			if(rec_cert.length() == 8){
			// 비정상 결과값 처리 부분 -----------------------------------------------------------------------
%>
				[수신값] <br><br>
				결과코드 : <%=rec_cert%>
				<br><br>
				오류가 발생하였습니다!<br>
				결과코드 정의표 참고하세요!
				<br><br>
				<a href="./kmcis_webc_sample_step03.jsp">[다시 테스트]</a>
<%
			// End - 비정상 결과값 처리 부분 -----------------------------------------------------------------
			}else{
			// 정상 결과값 처리 부분 -------------------------------------------------------------------------

				//08. 1차 복호화 (요청번호를 이용해 복호화)
				rec_cert = seed.getDec(rec_cert, certNum);

				int inf1 = rec_cert.indexOf("/",0);
				int inf2 = rec_cert.indexOf("/",inf1+1);

				encPara = rec_cert.substring(0, inf1);
				encMsg1 = rec_cert.substring(inf1+1, inf2);

				//09. 1차 복호화 데이터에 대한 위변조 검증값 검증
				encMsg2 = seed.getMsg(encPara);

				if(encMsg2.equals(encMsg1)){
					msgChk="Y";
				}

				if(msgChk.equals("N")){
	%>
					<script language=javascript>
								alert("비정상적인 접근입니다.!!(<%=msgChk%>)");
					</script>
	<%
					return;
				}

				//10. 2차 복호화 (요청번호를 이용해 복호화)
				rec_cert  = seed.getDec(encPara, certNum);

				int info1  = rec_cert.indexOf("/",0);
				int info2  = rec_cert.indexOf("/",info1+1);
				int info3  = rec_cert.indexOf("/",info2+1);
				int info4  = rec_cert.indexOf("/",info3+1);
				int info5  = rec_cert.indexOf("/",info4+1);
				int info6  = rec_cert.indexOf("/",info5+1);
				int info7  = rec_cert.indexOf("/",info6+1);
				int info8  = rec_cert.indexOf("/",info7+1);

				r_certNum	= rec_cert.substring(0,info1);
				r_CI		= rec_cert.substring(info1+1,info2);
				r_DI		= rec_cert.substring(info2+1,info3);
				r_result	= rec_cert.substring(info3+1,info4);
				r_resultCode= rec_cert.substring(info4+1,info5);
				r_check_1	= rec_cert.substring(info5+1,info6);
				r_check_2	= rec_cert.substring(info6+1,info7);
				r_check_3	= rec_cert.substring(info7+1,info8);

				//11. CI, DI 복호화 (요청번호를 이용해 복호화)
				r_CI  = seed.getDec(r_CI, certNum);
				r_DI  = seed.getDec(r_DI, certNum);

%>
            [복호화 후 수신값] <br>
            <br>
            <table cellpadding=1 cellspacing=1>
                <tr>
                    <td align=left>위,변조여부값1</td>
                    <td align=left><%=encMsg1%></td>
                </tr>
                <tr>
                    <td align=left>위,변조여부값2</td>
                    <td align=left><%=encMsg2%></td>
                </tr>
                <tr>
                    <td align=left>요청번호</td>
                    <td align=left><%=r_certNum%></td>
                </tr>
				<tr>
					<td align=left>연계정보(CI)</td>
					<td align=left><%=r_CI%></td>
				</tr>
				<tr>
					<td align=left>중복가입확인정보(DI)</td>
					<td align=left><%=r_DI%></td>
				</tr>
                <tr>
                    <td align=left>인증결과값</td>
                    <td align=left><%=r_result%></td>
                </tr>
                <tr>
                    <td align=left>인증결과코드</td>
                    <td align=left><%=r_resultCode%></td>
                </tr>
                <tr>
                    <td align=left>인증번호 확인결과 전송 및 SMS재전송 요청을 위한 파라미터1</td>
                    <td align=left><%=r_check_1%></td>
                </tr>
                <tr>
                    <td align=left>인증번호 확인결과 전송 및 SMS재전송 요청을 위한 파라미터2</td>
                    <td align=left><%=r_check_2%></td>
                </tr>
                <tr>
                    <td align=left>인증번호 확인결과 전송 및 SMS재전송 요청을 위한 파라미터3</td>
                    <td align=left><%=r_check_3%></td>
                </tr>
            </table>

            <br>
            rec_cert : <%=rec_cert%> <br>
            <br>
            <br>
            <a href="./auth3">[다시 테스트]</a>
<%
			// End - 정상 결과값 처리 부분 --------------------------------------------------------------------
			}

        } catch (Exception ex) {
            System.out.println("[KMCIS] Receive Error -" + ex.getMessage());
        }
%>

<%
	response.setHeader("Pragma","no-cache");			// HTTP1.0 캐쉬 방지
	response.setDateHeader("Expires",0);				// proxy 서버의 캐쉬 방지
	response.setHeader("Pragma", "no-store");			// HTTP1.1 캐쉬 방지
	if(request.getProtocol().equals("HTTP/1.1"))
			response.setHeader("Cache-Control", "no-cache"); // HTTP1.1 캐쉬 방지
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.*,java.text.SimpleDateFormat"%>
<%
        //날짜 생성
        Calendar today = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String day = sdf.format(today.getTime());

        java.util.Random ran = new Random();
        //랜덤 문자 길이
        int numLength = 6;
        String randomStr = "";

        for (int i = 0; i < numLength; i++) {
            //0 ~ 9 랜덤 숫자 생성
            randomStr += ran.nextInt(10);
        }

		//reqNum은 최대 40byte 까지 사용 가능
        String reqNum = day + randomStr;
%>
<html>
    <head>
        <title>본인인증서비스(웹통신CI방식)  테스트</title>
        <meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
        <style>
            <!--
            body,p,ol,ul,td
            {
                font-family: 굴림;
                font-size: 12px;
            }

            a:link { size:9px;color:#000000;text-decoration: none; line-height: 12px}
            a:visited { size:9px;color:#555555;text-decoration: none; line-height: 12px}
            a:hover { color:#ff9900;text-decoration: none; line-height: 12px}

            .style1 {
                color: #6b902a;
                font-weight: bold;
            }
            .style2 {
                color: #666666
            }
            .style3 {
                color: #3b5d00;
                font-weight: bold;
            }
            -->
        </style>
    </head>
    <body bgcolor="#FFFFFF" topmargin=0 leftmargin=0 marginheight=0 marginwidth=0>
        <center>
            <br><br><br>
            <span class="style1">본인인증서비스(웹통신CI방식) 테스트 - SMS본인인증번호 확인 요청</span><br>

            <form name="reqForm" method="post" action="./auth4">
                <table cellpadding=1 cellspacing=1>
                    <tr>
                        <td align=center>요청번호</td>
                        <td align=left><input type="text" name="certNum" size="41" maxlength ="40" value="<%=reqNum%>"></td>
                    </tr>
                    <tr>
                        <td align=center>본인인증번호</td>
                        <td align=left><input type="text" name="smsNum" size="41" maxlength ="6" value=""></td>
                    </tr>
                    <tr>
                        <td align=center>확인용 파라미터1</td>
                        <td align=left><input type="text" name="check_1" size="41" maxlength ="10" value=""></td>
					</tr>
                    <tr>
                        <td align=center>확인용 파라미터2</td>
                        <td align=left><input type="text" name="check_2" size="41" maxlength ="10" value=""></td>
					</tr>
                    <tr>
                        <td align=center>확인용 파라미터3</td>
                        <td align=left><input type="text" name="check_3" size="41" maxlength ="10" value=""></td>
					</tr>
				</table>
                <br><br>
                <input type="submit" value="본인인증번호 확인">
            </form>

            <br>
            <br>
            이 Sample화면은 본인인증서비스 테스트를 위해 제공하고 있는 화면입니다.<br>
            <br>
        </center>
    </body>
</html>
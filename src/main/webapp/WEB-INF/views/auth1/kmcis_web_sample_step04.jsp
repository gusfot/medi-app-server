<%
	//************************************************************************
	//																		//
	//		∫ª ª˘«√º“Ω∫¥¬ ∞≥πﬂ π◊ ≈◊Ω∫∆Æ∏¶ ¿ß«— ∏Ò¿˚¿∏∑Œ ∏∏µÈæÓ¡≥¿∏∏Á,		//
	//																		//
	//		Ω«¡¶ º≠∫ÒΩ∫ø° ±◊¥Î∑Œ ªÁøÎ«œ¥¬ ∞Õ¿ª ±›«’¥œ¥Ÿ.					//
	//																		//
	//************************************************************************
%>
<%
	response.setHeader("Pragma","no-cache");			// HTTP1.0 ƒ≥Ω¨ πÊ¡ˆ
	response.setDateHeader("Expires",0);				// proxy º≠πˆ¿« ƒ≥Ω¨ πÊ¡ˆ
	response.setHeader("Pragma", "no-store");			// HTTP1.1 ƒ≥Ω¨ πÊ¡ˆ
	if(request.getProtocol().equals("HTTP/1.1"))
			response.setHeader("Cache-Control", "no-cache"); // HTTP1.1 ƒ≥Ω¨ πÊ¡ˆ
%>
<%@ page  contentType = "text/html;charset=ksc5601"%>
<%@ page import = "java.util.*" %>
<%@ page import = "java.util.regex.*" %>
<%@ page import = "java.text.*" %>
    [∫ª¿Œ¿Œ¡ıº≠∫ÒΩ∫ ≈◊Ω∫∆Æ ∞·∞˙ ºˆΩ≈ Sample] <br> <br>
<%
    // ∫Øºˆº±æ --------------------------------------------------------------------------------------------------------
    String rec_cert		= "";           // ∞·∞˙ºˆΩ≈DATA

	String k_certNum = "";			    // ∆ƒ∂ÛπÃ≈Õ∑Œ ºˆΩ≈«— ø‰√ªπ¯»£
	String certNum		= "";			// ø‰√ªπ¯»£
    String date			= "";			// ø‰√ª¿œΩ√
	String CI	    	= "";			// ø¨∞Ë¡§∫∏(CI)
	String DI	    	= "";			// ¡ﬂ∫π∞°¿‘»Æ¿Œ¡§∫∏(DI)
    String phoneNo		= "";			// »ﬁ¥Î∆˘π¯»£
	String phoneCorp	= "";			// ¿Ãµø≈ÎΩ≈ªÁ
	String birthDay		= "";			// ª˝≥‚ø˘¿œ
	String gender		= "";			// º∫∫∞
	String nation		= "";			// ≥ª±π¿Œ
	String name			= "";			// º∫∏Ì
	String M_name		= "";			// πÃº∫≥‚¿⁄ º∫∏Ì
	String M_birthDay	= "";			// πÃº∫≥‚¿⁄ ª˝≥‚ø˘¿œ
	String M_Gender		= "";			// πÃº∫≥‚¿⁄ º∫∫∞
	String M_nation		= "";			// πÃº∫≥‚¿⁄ ≥ªø‹±π¿Œ
    String result		= "";			// ∞·∞˙∞™

    String certMet		= "";			// ¿Œ¡ıπÊπ˝
    String ip			= "";			// ip¡÷º“
	String plusInfo		= "";

	String encPara		= "";
	String encMsg1		= ""; 
	String encMsg2		= "";
	String msgChk       = "";
    //-----------------------------------------------------------------------------------------------------------------

    try{

        // Parameter ºˆΩ≈ --------------------------------------------------------------------
        rec_cert       = request.getParameter("rec_cert").trim();
        k_certNum      = request.getParameter("certNum").trim(); 

%>
            [∫π»£»≠ «œ±‚¿¸ ºˆΩ≈∞™] <br>
            <br>
            rec_cert : <%=rec_cert%> <br>
            <br>
<%
        //01. æœ»£»≠ ∏µ‚ (jar) Loading
        com.icert.comm.secu.IcertSecuManager seed = new com.icert.comm.secu.IcertSecuManager();

        //02. 1¬˜ ∫π»£»≠
        //ºˆΩ≈µ» certNum∏¶ ¿ÃøÎ«œø© ∫π»£»≠
        rec_cert  = seed.getDec(rec_cert, k_certNum);

        //03. 1¬˜ ∆ƒΩÃ
        int inf1 = rec_cert.indexOf("/",0);
        int inf2 = rec_cert.indexOf("/",inf1+1);

		encPara  = rec_cert.substring(0,inf1);         //æœ»£»≠µ» ≈Î«’ ∆ƒ∂ÛπÃ≈Õ
        encMsg1  = rec_cert.substring(inf1+1,inf2);    //æœ»£»≠µ» ≈Î«’ ∆ƒ∂ÛπÃ≈Õ¿« Hash∞™

		//04. ¿ß∫Ø¡∂ ∞À¡ı
		encMsg2  = seed.getMsg(encPara);

        if(encMsg2.equals(encMsg1)){
            msgChk="Y";
        }

		if(msgChk.equals("N")){
%>
		    <script language=javascript>
            alert("∫Ò¡§ªÛ¿˚¿Œ ¡¢±Ÿ¿‘¥œ¥Ÿ.!!<%=msgChk%>");
		    </script>
<%
			return;
		}

        //05. 2¬˜ ∫π»£»≠
		rec_cert  = seed.getDec(encPara, k_certNum);

        //06. 2¬˜ ∆ƒΩÃ
        int info1  = rec_cert.indexOf("/",0);
        int info2  = rec_cert.indexOf("/",info1+1);
        int info3  = rec_cert.indexOf("/",info2+1);
        int info4  = rec_cert.indexOf("/",info3+1);
        int info5  = rec_cert.indexOf("/",info4+1);
        int info6  = rec_cert.indexOf("/",info5+1);
        int info7  = rec_cert.indexOf("/",info6+1);
        int info8  = rec_cert.indexOf("/",info7+1);
		int info9  = rec_cert.indexOf("/",info8+1);
		int info10 = rec_cert.indexOf("/",info9+1);
		int info11 = rec_cert.indexOf("/",info10+1);
		int info12 = rec_cert.indexOf("/",info11+1);
		int info13 = rec_cert.indexOf("/",info12+1);
		int info14 = rec_cert.indexOf("/",info13+1);
		int info15 = rec_cert.indexOf("/",info14+1);
		int info16 = rec_cert.indexOf("/",info15+1);
		int info17 = rec_cert.indexOf("/",info16+1);
		int info18 = rec_cert.indexOf("/",info17+1);

        certNum		= rec_cert.substring(0,info1);
        date		= rec_cert.substring(info1+1,info2);
        CI			= rec_cert.substring(info2+1,info3);
        phoneNo		= rec_cert.substring(info3+1,info4);
        phoneCorp	= rec_cert.substring(info4+1,info5);
        birthDay	= rec_cert.substring(info5+1,info6);
        gender		= rec_cert.substring(info6+1,info7);
        nation		= rec_cert.substring(info7+1,info8);
		name		= rec_cert.substring(info8+1,info9);
		result		= rec_cert.substring(info9+1,info10);
		certMet		= rec_cert.substring(info10+1,info11);
		ip			= rec_cert.substring(info11+1,info12);
		M_name		= rec_cert.substring(info12+1,info13);
		M_birthDay	= rec_cert.substring(info13+1,info14);
		M_Gender	= rec_cert.substring(info14+1,info15);
		M_nation	= rec_cert.substring(info15+1,info16);
		plusInfo	= rec_cert.substring(info16+1,info17);
		DI      	= rec_cert.substring(info17+1,info18);

        //07. CI, DI ∫π»£»≠
        CI  = seed.getDec(CI, k_certNum);
        DI  = seed.getDec(DI, k_certNum);
%>	
<%!
		// ∆ƒ∂ÛπÃ≈Õ ¿Ø»øº∫ ∞À¡ı --------------------------------------------
		boolean b = true;
		String regex = "";

		public Boolean paramChk(String patn, String param){
			Pattern pattern = Pattern.compile(patn);
			Matcher matcher = pattern.matcher(param);
			b = matcher.matches();
			return b;
		}
%>
<%
		if( certNum.length() == 0 || certNum.length() > 40){
			out.println("ø‰√ªπ¯»£ ∫Ò¡§ªÛ");
			return;
		}

		regex = "[0-9]*";
		if( date.length() != 14 || !paramChk(regex, date) ){
			out.println("ø‰√ª¿œΩ√ ∫Ò¡§ªÛ");
			return;
		}

		regex = "[A-Z]*";
		if( certMet.length() != 1 || !paramChk(regex, certMet) ){
			out.println("∫ª¿Œ¿Œ¡ıπÊπ˝ ∫Ò¡§ªÛ" + certMet);
			return;
		}


		regex = "[0-9]*";
		if( (phoneNo.length() != 10 && phoneNo.length() != 11) || !paramChk(regex, phoneNo) ){
			out.println("»ﬁ¥Î∆˘π¯»£ ∫Ò¡§ªÛ");
			return;
		}
		
		regex = "[A-Z]*";
		if( phoneCorp.length() != 3 || !paramChk(regex, phoneCorp) ){
			out.println("¿Ãµø≈ÎΩ≈ªÁ ∫Ò¡§ªÛ");
			return;
		}

		regex = "[0-9]*";
		if( birthDay.length() != 8 || !paramChk(regex, birthDay) ){
			out.println("ª˝≥‚ø˘¿œ ∫Ò¡§ªÛ");
			return;
		}

		regex = "[0-9]*";
		if( gender.length() != 1 || !paramChk(regex, gender) ){
			out.println("º∫∫∞ ∫Ò¡§ªÛ");
			return;
		}

		regex = "[0-9]*";
		if( nation.length() != 1 || !paramChk(regex, nation) ){
			out.println("≥ª/ø‹±π¿Œ ∫Ò¡§ªÛ");
			return;
		}
		
		regex = "[\\sA-Za-z∞°-∆R.,-]*";
		if( name.length() > 60 || !paramChk(regex, name) ){
			out.println("º∫∏Ì ∫Ò¡§ªÛ");
			return;
		}
		
		regex = "[A-Z]*";
		if( result.length() != 1 || !paramChk(regex, result) ){
			out.println("∞·∞˙∞™ ∫Ò¡§ªÛ");
			return;
		}
		
		regex = "[\\sA-Za-z∞°-?.,-]*";
		if( M_name.length() != 0 ){
			if( M_name.length() > 60 || !paramChk(regex, M_name) ){
				out.println("πÃº∫≥‚¿⁄ º∫∏Ì ∫Ò¡§ªÛ");
				return;
			}
		}
		
		regex = "[0-9]*";
		if( M_birthDay.length() != 0 ){
			if( M_birthDay.length() != 8 || !paramChk(regex, M_birthDay) ){
				out.println("πÃº∫≥‚¿⁄ ª˝≥‚ø˘¿œ ∫Ò¡§ªÛ");
				return;
			}
		}

		regex = "[0-9]*";
		if( M_Gender.length() != 0 ){
			if( M_Gender.length() != 1 || !paramChk(regex, M_Gender) ){
				out.println("πÃº∫≥‚¿⁄ º∫∫∞ ∫Ò¡§ªÛ");
				return;
			}
		}

		regex = "[0-9]*";
		if( M_nation.length() != 0 ){
			if( M_nation.length() != 1 || !paramChk(regex, M_nation) ){
				out.println("πÃº∫≥‚¿⁄ ≥ª/ø‹±π¿Œ ∫Ò¡§ªÛ");
				return;
			}
		}
		// End ∆ƒ∂ÛπÃ≈Õ ¿Ø»øº∫ ∞À¡ı --------------------------------------------

		// Start - ºˆΩ≈≥ªø™ ¿Ø»øº∫ ∞À¡ı(ªÁº≥∏¡¿« ªÁº≥ IP∑Œ ¿Œ«ÿ πÃªÁøÎ, ∞¯øÎ∏¡¿« ∞ÊøÏ »Æ¿Œ »ƒ ªÁøÎ) *********************/
		// 1. date ∞™ ∞À¡ı
		SimpleDateFormat formatter	= new SimpleDateFormat("yyyyMMddHHmmss",Locale.KOREAN); // «ˆ¿Á º≠πˆ Ω√∞¢ ±∏«œ±‚
		String strCurrentTime	= formatter.format(new Date());
		
		Date toDate				= formatter.parse(strCurrentTime);
		Date fromDate			= formatter.parse(date);
		long timediff			= toDate.getTime()-fromDate.getTime();
		
		if ( timediff < -30*60*1000 || 30*60*100 < timediff  ){		%>
			∫Ò¡§ªÛ¿˚¿Œ ¡¢±Ÿ¿‘¥œ¥Ÿ. (ø‰√ªΩ√∞£∞Ê∞˙)
<%			return;
		}
		
		// 2. ip ∞™ ∞À¡ı
		String client_ip = request.getHeader("HTTP_X_FORWARDED_FOR"); // ªÁøÎ¿⁄IP ±∏«œ±‚
		if ( client_ip != null ){
			if( client_ip.indexOf(",") != -1 )
				client_ip = client_ip.substring(0,client_ip.indexOf(","));
		}
		if ( client_ip==null || client_ip.length()==0 ){
			client_ip = request.getRemoteAddr();
		}

		if( !client_ip.equals(ip) ){		%>

			∫Ò¡§ªÛ¿˚¿Œ ¡¢±Ÿ¿‘¥œ¥Ÿ. (IP∫“¿œƒ°)
<%			return;
		}
		// End - ºˆΩ≈≥ªø™ ¿Ø»øº∫ ∞À¡ı(ªÁº≥∏¡¿« ªÁº≥ IP∑Œ ¿Œ«ÿ πÃªÁøÎ, ∞¯øÎ∏¡¿« ∞ÊøÏ »Æ¿Œ »ƒ ªÁøÎ) ***********************/
%>
<html>
	<head>
		<meta name="robots" content="noindex">
	</head>
	<body>
		<br><br>
            [∫π»£»≠ »ƒ ºˆΩ≈∞™] <br>
            <br>
            <table cellpadding=1 cellspacing=1>
                <tr>
                    <td align=left>¿ß,∫Ø¡∂ø©∫Œ1</td>
                    <td align=left><%=encMsg1%></td>
                </tr>
                <tr>
                    <td align=left>¿ß,∫Ø¡∂ø©∫Œ2</td>
                    <td align=left><%=encMsg2%></td>
                </tr>

                <tr>
                    <td align=left>ø‰√ªπ¯»£</td>
                    <td align=left><%=certNum%></td>
                </tr>
                <tr>
                    <td align=left>ø‰√ª¿œΩ√</td>
                    <td align=left><%=date%></td>
                </tr>
                <tr>
                    <td align=left>ø¨∞Ë¡§∫∏(CI)</td>
                    <td align=left><%=CI%></td>
                </tr>
                <tr>
                    <td align=left>¡ﬂ∫π∞°¿‘»Æ¿Œ¡§∫∏(DI)</td>
                    <td align=left><%=DI%></td>
                </tr>
                <tr>
                    <td align=left>»ﬁ¥Î∆˘π¯»£</td>
                    <td align=left><%=phoneNo%></td>
                </tr>
                <tr>
                    <td align=left>¿Ãµø≈ÎΩ≈ªÁ</td>
                    <td align=left><%=phoneCorp%></td>
                </tr>
                <tr>
                    <td align=left>ª˝≥‚ø˘¿œ</td>
                    <td align=left><%=birthDay%></td>
                </tr>
                <tr>
                    <td align=left>≥ª±π¿Œ</td>
                    <td align=left><%=nation%></td>
                </tr>
                <tr>
                    <td align=left>º∫∫∞</td>
                    <td align=left><%=gender%></td>
                </tr>
                <tr>
                    <td align=left>º∫∏Ì</td>
                    <td align=left><%=name%></td>
                </tr>
                <tr>
                    <td align=left>∞·∞˙∞™</td>
                    <td align=left><%=result%></td>
                </tr>
                <tr>
                    <td align=left>¿Œ¡ıπÊπ˝</td>
                    <td align=left><%=certMet%></td>
                    </td>
                </tr>
                <tr>
                    <td align=left>ip¡÷º“</td>
                    <td align=left><%=ip%></td>
                </tr>
                <tr>
                    <td align=left>πÃº∫≥‚¿⁄ º∫∏Ì</td>
                    <td align=left><%=M_name%></td>
                </tr>
                <tr>
                    <td align=left>πÃº∫≥‚¿⁄ ª˝≥‚ø˘¿œ</td>
                    <td align=left><%=M_birthDay%></td>
                </tr>
                <tr>
                    <td align=left>πÃº∫≥‚¿⁄ º∫∫∞</td>
                    <td align=left><%=M_Gender%></td>
                    </td>
                </tr>
                <tr>
                    <td align=left>πÃº∫≥‚¿⁄ ≥ªø‹±π¿Œ</td>
                    <td align=left><%=M_nation%></td>
                </tr>
                <tr>
                    <td align=left>√ﬂ∞°DATA¡§∫∏</td>
                    <td align=left><%=plusInfo%></td>
                </tr>
            </table>

            <br>
            rec_cert : <%=rec_cert%> <br>
            <br>
            <br>
            <a href="http://»∏ø¯ªÁ∫∞ ∞Ê∑Œ/kmcis_web_sample_step01.jsp">[¥ŸΩ√ ≈◊Ω∫∆Æ]</a>
	</body>
</html>
        <%
    }catch(Exception ex){
          System.out.println("[KMCIS] Receive Error -"+ex.getMessage());
    }
%>
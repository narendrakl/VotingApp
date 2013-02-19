<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href="Votingform.do"> Click Here to Vote</a></br>
	<a href="Login.jsp">Click Here to Login For rest of work</a>(Only for Election Commissioner use)
	
	<%
		
		RequestDispatcher rd = null;
			if(session.getAttribute("vote")!=null)
			{
				session.removeAttribute("vote");
				System.out.println("session had expired");	
				String redirect_url = "http://localhost:8080/VotingApp/VotingSession.jsp";
				response.sendRedirect(redirect_url);	
			}
			
		
		
		
	%>
	
	
</body>
</html>
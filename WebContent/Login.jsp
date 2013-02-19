<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1> Log In Page</h1>
	<form action="LoginInt.jsp" method = "post">
		Enter Election Commissioner's Username:</br><input type="text" name="username"></br>
		Enter Election Commissioner's Password:</br><input type="password" name="pwd"></br>
		<input type="submit">
	</form>
	<%
		if(request.getAttribute("errmsg")!=null)
		{
			out.println("<h1>"+request.getAttribute("errmsg")+"</h1>");
		}
	
	
	%>

</body>
</html>
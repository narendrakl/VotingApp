<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ResultsInt.jsp" method="post">
		Select the Name of the post to which the result to be known:<select name="pname">
		
		<option>President</option>
		<option>VicePresident</option>
		<option>Secretary</option>
		<option>Cashier</option>
		<option>Assistant Secretary</option>
		<option>Director1</option>
		<option>Director2</option>
		<option>Director3</option>
		<option>Director4</option>
		
		</select>
		<input type="submit">
	</form>
	<%
		String msg = (String)request.getAttribute("msg");
		//out.println(request.getAttribute("msg"));	
	 	if(msg!="")
		{
			if(msg.contains("@"))
			{
				int i=1;
				String a[]=msg.split("@");
				out.println("<h4><p>"+"Total count of voting is: "+a[0]+"</p></h4>");
				out.println("<h2>"+"    Post|"+"    Name|"+"    Uid|"+"    No.Of Votes|");
				while(!a[i].contains("$"))
				{
					
					out.println("<h4><p>"+a[i]+"</p></h4>");
					i++;
				}
				
			}
		}
	
	%>


</body>
</html>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
</head>
<body style="text-align: center;">
	<h3>Register Please</h3>
	<form action="register" method="post">
		<pre>
		<input type="text" name="name" placeholder="Full Name" required />
		
		<input type="text" name="email" placeholder="Enter Email" required />
		
		<input type="password" name="pass" placeholder="Enter Password" required />
		
		<input type="submit" name="sub" value="Register" />
		</pre>
		<%
		String str = (String) request.getAttribute("msg");
		if (str != null) {
			out.print(str);
		}
		%>
	</form>
	<a href="index.jsp">Login Now</a>
</body>
</html>
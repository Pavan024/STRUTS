<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body style="text-align: center;">
	<h3>Login Please</h3>
	<form action="login" method="post">
		<pre>
<input type="text" name="email" placeholder="Enter Email" required />

<input type="password" name="pass" placeholder="Enter Password" required />

<input type="submit" name="sub" value="Login" />
		</pre>
		<%
		String str = (String) request.getAttribute("msg");
		if (str != null) {
			out.print(str);
		}
		%>
	</form>
	<a href="register.jsp">Register Now</a>
</body>
</html>
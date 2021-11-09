<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Report</title>
</head>
<body>
	<h2>Struts 2 Create, Read, Update and Delete (CRUD) Example using JDBC</h2>
	<div>
		<s:if test="noData==true">
			<table>
				<thead>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Password</th>
						<th>Designation</th>
						<th>Action</th>
					</tr>
				</thead>
				<s:iterator value="beanList">
					<tr>
						<td><s:property value="uname" /></td>
						<td><s:property value="uemail" /></td>
						<td><s:property value="upass" /></td>
						<td><s:property value="udeg" /></td>
						<td>
							<a href="updatedetails.action?submitType=updatedata&uemail=<s:property value="uemail"/>">
								<button class="button-update">Update</button>
							</a>
							<a href="deleterecord.action?uemail=<s:property value="uemail"/>">
								<button class="button-delete">Delete</button>
							</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			<div>No Data Found.</div>
		</s:else>
	</div>
</body>
</html>
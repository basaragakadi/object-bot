<html xmlns
	="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org">
<head>
<title>Home Page</title>
</head>
<body>
	<h1>Hello !</h1>
	<p>
		Welcome to <span th:text="${appName}">Our App</span>
	</p>

	<div>
		<form method="POST" enctype="multipart/form-data" action="/">
			<table>
				<tr>
					<td>File to upload:</td>
					<td><input type="file" name="file" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Upload" /></td>
				</tr>
			</table>
		</form>
	</div>

	<div>
		<ul>
			<li th:each="file : ${files}"><a th:href="${file}"
				th:text="${file}" /></li>
		</ul>
	</div>
</body>
</html>
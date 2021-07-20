<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<c:set
	var="rootPath"
	value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>

</head>
<body>
	<h1>JSON</h1>
	<button id="json_1">JSON 문자열</button>

</body>
<script>
var rootPath = '${rootPath}'
</script>
<script src="${rootPath}/static/json.js?ver=2021-07-20-005"></script>
</html>






<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>HOME</h1>
	<c:forEach var="item" items="${CATE }">
	<h3>${item.id }</h3>
	<h3>${item.name }</h3>
	<h3>${item.description }</h3>
	
	</c:forEach>
</body>
</html>
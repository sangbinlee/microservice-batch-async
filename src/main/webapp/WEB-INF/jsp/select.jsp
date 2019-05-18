<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/resources/text.txt" var="url" />
	<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
	Spring URL: ${springUrl} at ${time}
	<br> JSTL URL: ${url}



	<br>
	<br>
	<br>
	<br>
	<pre>
	Message: ${message}
	Message: ${message}
	Message: ${message}
	Message: ${message}
	Message: ${message}
	Message: ${message}


this is welcome.jsp

<a href="index.html">http://localhost:8080/index.html</a>
<!-- <a href="http://localhost:9000/actuator/health">http://localhost:9000/actuator/health</a> -->
	
	</pre>




</body>
</html>

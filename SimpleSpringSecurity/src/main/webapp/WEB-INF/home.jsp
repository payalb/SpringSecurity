<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Spring Security</title>
</head>
<body>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
	<!-- if user principal is null,  spring-security intercepts the request and 
	passes it to implicit login page to get authenticated -->
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="${pageContext.request.contextPath}/logout"> Logout</a>					
 		</h2>
		<p>Your Session id is: "${pageContext.request.session.id}"</p>
	</c:if>

</body>
</html>

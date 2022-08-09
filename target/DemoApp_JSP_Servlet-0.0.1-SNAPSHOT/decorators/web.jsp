<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title><decorator:title default="Trang chủ"/></title>
		<!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="<c:url value="/templates/assets/favicon.ico"/>" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="<c:url value="/templates/web/css/index.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/templates/web/css/styles.css"/>" rel="stylesheet"/>
</head>


<body>
	
	<!--  nav -->
	<%@ include file="/common/web/nav.jsp" %>
	<!--  header -->
	<%@ include file="/common/web/header.jsp" %>
	
	<decorator:body></decorator:body>
	<!--  footer -->
	<%@ include file="/common/web/footer.jsp" %>
	
	
	<!-- Bootstrap core JS-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="<c:url value="/templates/web/js/scripts.js"/>"></script>
</body>
</html>
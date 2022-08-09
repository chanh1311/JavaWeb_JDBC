<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp" %>

<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title><decorator:title default="Trang chủ"/></title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="<c:url value="/templates/admin/css/styles.css"/>" rel="stylesheet" />
        <link href="<c:url value="/templates/admin/css/index.css"/>" rel="stylesheet" />
		<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>

<body class="sb-nav-fixed">
	
	<!--  nav -->
	<%@ include file="/common/admin/nav.jsp" %>

	<!--  layout-nav -->
	<div id="layoutSidenav">
		<%@ include file="/common/admin/layout-nav.jsp" %>
		<div id="layoutSidenav_content">
			<main>
				<decorator:body></decorator:body>
			</main>
			<%@ include file="/common/admin/footer.jsp" %>
		</div>
	</div>
	
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
     <script src="<c:url value="/templates/admin/js/scripts.js"/>"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
     <script src="<c:url value="/templates/admin/assets/demo/chart-area-demo.js"/>"></script>
     <script src="<c:url value="/templates/admin/assets/demo/chart-bar-demo.js"/>"></script>
     <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="<c:url value="/templates/admin/js/datatables-simple-demo.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/templates/paging/jquery.twbsPagination.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/ckeditor/ckeditor.js"/>"></script>
      
</body>
</html>

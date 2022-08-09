<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><decorator:title default="Login" /> Login </title>
<link href="<c:url value="/templates/login/css/style.css"/>" rel="stylesheet"/>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">


</head>


<body>


	<div class="main">
		<decorator:body></decorator:body>
	</div>

	<script src="<c:url value="/templates/login/js/script.js"/>"></script>
	
	
	
	
	<script>
	// form validator
      // Mong muốn của chúng ta
      // Truyền lần lượt các tham số bên này sang bên kia xử lý
      // Truyền vào 3 tham số (form-selector,tag-error,rules[])
	      Validator({
	        form: '#form-1',
	        formGroup: '.form-group',
	        errorSelector: '.form-message',
	        rules: [
	          Validator.isRequired('#username'),
	          Validator.isRequired('#password'),
	          Validator.isPassWord('#password',6),
	        ],
	      
	          
	      })
    </script>
    <!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
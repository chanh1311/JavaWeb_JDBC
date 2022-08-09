<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="POST" class="form" id="form-1">
	
          <h3 class="heading">Đăng nhập</h3>
          <p class="desc">Đăng nhập để mua sản phẩm ngay</p>
      
          <div class="spacer"></div>
          
          
           <div class="form-group">
            <label for="username" class="form-label">Username</label>
            <input id="username" name="userName" type="text" placeholder="VD: chanh098" class="form-control">
            <span class="form-message"></span>
          </div>
      
          <div class="form-group">
            <label for="password" class="form-label">Mật khẩu</label>
            <input id="password" name="matKhau" type="password" placeholder="Nhập mật khẩu" class="form-control">
            <span class="form-message"></span>
          </div>
         	<input type="hidden" name="action" id="action">
         	<button class="form-submit">Đăng nhập</button>
       		
       		<c:if test="${not empty alert}">
				<div class="alert alert-${alert} mt-4" role="alert">
				  ${message}
				</div>
			</c:if>
      </form>
       
       
 
          
</body>
</html>
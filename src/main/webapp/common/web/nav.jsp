<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand" href="#!">Shop ban hang</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#!">Home</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="#!">All Products</a></li>
						<li>
							<hr class="dropdown-divider" />
						</li>
						<li><a class="dropdown-item" href="#!">Selling Product</a></li>
						<li><a class="dropdown-item" href="#!">New Product</a></li>
					</ul></li>
				<li class="nav-item"><a class="nav-link" href="#!">Purchase
						History</a></li>
			</ul>
			<form class="d-flex">
				<button class="btn btn-outline-light" type="submit">
					<i class="bi-cart-fill me-1"></i> Cart <span
						class="badge bg-light text-black ms-1 rounded-pill">0</span>
				</button>

			</form>

			<c:if test="${empty KHACHHANG_MODEL}">
				<div class="nav-item dropdown d-flex">

					<a class="nav-link dropdown-toggle dropdown-custom"
						id="navbarDropdown" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false">Tài khoản</a>

					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item"
							href="<c:url value="/dang-nhap?action=login"/>">Sing In</a></li>
						<li>
							<hr class="dropdown-divider" />
						</li>
						<li><a class="dropdown-item" href="#!">Sing Up</a></li>
					</ul>

				</div>
			</c:if>

			<c:if test="${not empty KHACHHANG_MODEL}">
				<div class="nav-item dropdown d-flex">

					<a class="nav-link dropdown-toggle dropdown-custom"
						id="navbarDropdown" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false">Xin Chào
						${KHACHHANG_MODEL.hoTenKH}</a>

					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item"
							href="<c:url value="/dang-nhap?action=login"/>">Đăng nhập tài
								khoản khác</a></li>
						<li>
							<hr class="dropdown-divider" />
						</li>
						<li><a class="dropdown-item" href="<c:url value="/thoat?action=logout"/>">Đăng
								xuất</a></li>
								
					</ul>

				</div>
			</c:if>


		</div>
	</div>
</nav>
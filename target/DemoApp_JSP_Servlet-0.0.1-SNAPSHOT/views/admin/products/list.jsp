<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value="/admin-products"/>" method="GET" id="form-sp">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Tên sản phẩm</th>
					<th scope="col">Mô tả</th>
					<th scope="col">Giá</th>
					<th scope="col">Số lượng</th>
					<th scope="col">Ghi chú</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${model.resultList}">
					<tr>
						<th scope="row">${item.getMshh()}</th>
						<td>${item.getTenHH()}</td>
						<td>${item.getMoTaHH()}</td>
						<td>${item.getGia()}</td>
						<td>${item.getSoLuongHang()}</td>
						<td>${item.getGhiChu()}</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
		
		<ul class="pagination" id="pagination"></ul>
		
		<input type="hidden" id="page" value="" name="page">
		<input type="hidden" id="maxPageItems" value="" name="maxPageItems">
		<input type="hidden" id="sortBy" value="" name="sortBy">
		<input type="hidden" id="sortName" value="" name="sortName">
		
	</form>



 
	<script type="text/javascript">
		var totalPages = ${model.totalPages};
		// Cai nay la thong so hien thi chu khong phai data goi len server
		var currentPages = ${model.page};
		var limit = ${model.maxPageItems};
		
		// Sort Default
		var sortBy = `${model.sortBy}` != null ? `${model.sortBy}` : "MSHH";
		var sortName = `${model.sortName}` != null ? `${model.sortName}` : "ASC";
		
		 
		
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 5,
				startPage: currentPages,
				onPageClick : function(event, page) {
					if(page != currentPages){
						
						// 2 bien nay thay doi khi click chuyen trang
						$("#sortBy").val(sortBy);
						$("#sortName").val(sortName);
						$("#maxPageItems").val(limit);
						$("#page").val(page);
						$("#form-sp").submit();
					}
					
					console.info(page + ' (from options)');
				}
			}).on('page', function(event, page) {
				console.info(page + ' (from event listening)');
			});
		});
	</script>



	
   


</body>
</html>
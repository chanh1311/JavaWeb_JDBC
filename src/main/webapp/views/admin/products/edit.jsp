<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
 <c:url var="apiURL" value="/api-admin-test">
</c:url>

<c:url var="productURL" value="/admin-products">
</c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-3">
	  <h1>Cập nhật sản phẩm</h1>
	  <form id="formEdit">
	    <div class="mb-3 mt-3 form-group">
	      <label for="">Tên sản phẩm:</label>
	      <input type="text" class="form-control" value="${model.tenHH }" id="tenHH" name="tenHH">
	    </div>
	    
	    <div class="mb-3 mt-3 form-group">
	      <label for="">Mô tả sản phẩm:</label>
	      <textarea class="form-control" id="moTaHH" name="moTaHH" style="height: 170px;">${model.getMoTaHH()}</textarea>
	    </div>
	    
	    <div class="mb-3 mt-3 form-group">
	      <label for="">Loại sản phẩm:</label>
	      <select name="maLoaiHang" id="" class="form-control" required>
	      	<option value="">--Chọn loại hàng hóa--</option>
	      	<c:forEach var="item" items="${LoaiHangHoa}">
	      		<option value="${item.getMaLoaiHang()}" 
	      			<c:if test="${item.getMaLoaiHang() == model.getMaLoaiHang()}">selected="selected"</c:if>>
	      			${item.getTenLoaiHang()}
	      		</option>	
	      	</c:forEach>
	      	
	      </select>
	    </div>
	    
	    <div class="mb-3 mt-3 form-group">
	      <label for="">Giá:</label>
	      <input type="text" class="form-control" id="gia" name="gia" value="${model.gia }">
	    </div>
	    
	    <div class="mb-3 mt-3 form-group">
	      <label for="">Số lượng:</label>
	      <input type="text" class="form-control" id="soLuongHang" name="soLuongHang" value="${model.soLuongHang }">
	    </div>
	    
	     <div class="mb-3 mt-3 form-group">
	      <label for="">Ghi chú:</label>
	      <input type="text" class="form-control" id="ghiChu" name="ghiChu" value="${model.ghiChu}">
	    </div>
	  	<c:if test="${empty model}">
	  		<button type="submit" class="btn btn-primary btnEditOrUpdate" >Thêm mới sản phẩm</button>
	  	</c:if>
	  	<c:if test="${ not empty model}">
	  		<button type="submit" class="btn btn-primary btnEditOrUpdate" >Cập nhật sản phẩm</button>
	  	</c:if>
	    
	    <input type="hidden" value="${model.mshh}" id="mshh" name="mshh">
	   	<br/><br/>
	  </form>
	</div>
	
	
		
	<script type="text/javascript">
		var editor = ''
		$(document).ready(function(){
			editor = CKEDITOR.replace('moTaHH');
		});
		
	</script>




	<script>
		$(".btnEditOrUpdate").click(function (e) {
			e.preventDefault();
			
			// get data from form
			var data = {}
			var formData = $("#formEdit").serializeArray();
			
			$.each(formData,function (index,value) {
				
				data[value.name] = value.value;
				
			})
			data["moTaHH"] = editor.getData();
			//check edit or newadd and call function
			var id = $("#mshh").val();
			if(id != ""){
				updateProducts(data);
			}else{
				addProducts(data);
			}
			
			// Truyen du lieu su dung ajax
			function updateProducts(data) {
				$.ajax({
					url: '${apiURL}',
					type: 'PUT',
					contentType: 'application/json',
					data: JSON.stringify(data),
					dataType: 'json',
					success: function(result){
						
						window.location.href = "${productURL}?type=list&page=1&maxPageItems=4&message=message_success_update&alert=success";
					},
					error: function(error){
						window.location.href = "${productURL}?type=list&page=1&maxPageItems=4&message=message_error_update&alert=error";
					}
				})
			}
			
			function addProducts(data) {
				$.ajax({
					url: '${apiURL}',
					type: 'POST',
					contentType: 'application/json',
					data: JSON.stringify(data),
					dataType: 'json',
					success: function(result){
						
						window.location.href = "${productURL}?type=list&page=1&maxPageItems=4&message=message_success_add&alert=success";
					},
					error: function(error){
						window.location.href = "${productURL}?type=list&page=1&maxPageItems=4&message=message_error_add&alert=error";
					}
				})
			}
			
		})
	</script>
	
	
	
	
	
</body>
</html>
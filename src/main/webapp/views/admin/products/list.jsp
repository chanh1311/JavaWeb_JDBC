<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<div>
		<h2 class="text-center mt-4">Danh sách sản phẩm</h2>
	
	</div>
	
	<form action="<c:url value="/admin-products"/>" name="form-select-all" method="GET" id="form-select-all">
		<div class="mt-4 d-flex align-items-center ml">
		      <div class="form-check">
		        <input class="form-check-input" type="checkbox" id="select-all">
		        <label class="form-check-label" for="select-all">
		          Chọn tất cả
		        </label>
		      </div>
		      <select class="form-select form-select-sm select-options" name="action" required>
		        <option value="">--Chọn--</option>
		        <option value="delete" >Xóa</option>
		      </select>
	
	      	<button class="btn btn-sm btn-primary btn-checkbox-all" id="btn-selectAll-delete" type="submit" disabled>Thực hiện</button>
	 	</div>
	</form>

	<form action="<c:url value="/admin-products"/>" method="GET" id="form-sp">
		
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Chọn</th>
					<th scope="col">#</th>
					<th scope="col">Tên sản phẩm</th>
					<th scope="col">Mô tả</th>
					<th scope="col">Giá</th>
					<th scope="col">Số lượng</th>
					<th scope="col">Ghi chú</th>
					<th scope="col" colspan="2">Thao tác</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${model.resultList}">
					<tr>
						<td><input class="form-check-input" type="checkbox" value="${item.getMshh()}" name="idProduct[]"></td>
						<th scope="row">${item.getMshh()}</th>
						<td>${item.getTenHH()}</td>
						<td>${item.getMoTaHH()}</td>
						<td>${item.getGia()}</td>
						<td>${item.getSoLuongHang()}</td>
						<td>${item.getGhiChu()}</td>
						<c:url var="editURL" value="/admin-products">
                        		<c:param name="type" value="edit"></c:param>
                        		<c:param name="mshh" value="${item.getMshh()}"></c:param>
                        </c:url>
						<td><a href="${editURL}" id="btnEdit" class="btn btn-primary">Sửa</a></td>
						<td><button type="button" id="btnDelete" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-bs-toggle="modal" data-bs-target="#delete-product-modal" data-id=${item.getMshh() }>Xóa</button></td>
						
					</tr>
				</c:forEach>


			</tbody>
		</table>
		
		<ul class="pagination" id="pagination"></ul>
		
		<input type="hidden" id="type" value="" name="type">
		<input type="hidden" id="page" value="" name="page">
		<input type="hidden" id="maxPageItems" value="" name="maxPageItems">
		<input type="hidden" id="sortBy" value="" name="sortBy">
		<input type="hidden" id="sortName" value="" name="sortName">
		
	</form>
	<c:if test="${not empty alert}">
		<div class="alert alert-${alert}" role="alert">
	  		${message}
		</div>
	</c:if>

	
	
	
	<div class="modal" tabindex="-1" id="delete-product-modal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Xóa sản phẩm?</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <p>Bạn có chắc là sẽ xóa sản phẩm?</p>
	      </div>
	      <div class="modal-footer">
	        <button id="btn-delete-product" type="button" class="btn btn-danger">Delete</button>
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- Delete -->
	<script>
		
		// Delete By Id
		var idDelete;
		var data = {};
		var arrId = []
		$('#delete-product-modal').on('show.bs.modal', function (event) {
			  var button = $(event.relatedTarget) // Button that triggered the modal
			  idDelete = button.data('id') // Extract info from data-* attributes
			 
		})
		
		var btnDelete = document.getElementById("btn-delete-product");
		btnDelete.onclick = function(){
			idDelete = parseInt(idDelete);
			arrId.push(idDelete);
			data["ids"] = arrId;
			deleteProducts(data);
			
		}
		
		   // Delete Select All
	    $(document).ready(function(){
	    	var data = {}
	    	$("#form-select-all").submit(function(e){
	    		e.preventDefault();
	    		var arrIds = $('input[name="idProduct[]"]:checked').map(function(){
	    		      			return $(this).val();
	    		    		}).get();
	    		data["ids"] = arrIds;
	    		
	    		deleteProducts(data);
	    		
	    	});
	    });
	    
		
		
		// function Delete
		function deleteProducts(data){
			$.ajax({
					url: '${apiURL}',
					type: 'DELETE',
					contentType: 'application/json',
					data: JSON.stringify(data),
					dataType: 'json',
					success: function(result){
						window.location.href = "${productURL}?type=list&page=1&maxPageItems=4";
					},
					error: function(error){
						console.log(error);
					}
				});
		}

	</script>



	 <!-- SelectAll -->
	<script type="text/javascript">
			// get checkbox-all
		    var checkboxAll = $('#select-all');
		    // get checkbox in for
		    var checkboxItems =  $('input[name="idProduct[]"]');
		    // get btn-checkboxAll
		    var btnCheckBoxAll = $('.btn-checkbox-all');
		    // get form-select-all
		    var formSelectAll = $('form[name="form-select-all"]');
		    
		    
		   
		    
		
		    //check checked? Change checkAll as check
		    checkboxAll.change(function(){
		      var isChecked = checkboxAll.prop('checked');
		      checkboxItems.prop('checked',isChecked);
		      removeDisabled();
		    })
		    
		    checkboxItems.change(function() {
		      isCheckAllItems = checkboxItems.length === $('input[name="idProduct[]"]:checked').length;
		      checkboxAll.prop('checked',isCheckAllItems);
		       removeDisabled();
		    })
		
		    function removeDisabled(){
		      var checkboxCount = $('input[name="idProduct[]"]:checked').length;
		      if(checkboxCount > 0){
		        btnCheckBoxAll.attr('disabled',false);
		      }else{
		         btnCheckBoxAll.attr('disabled',true);
		      }
		    }
		    
		    
		 
		    
		    
		    
		    // Submit form disable tag checkbox(idProduct[])
		    $(function() {
		        // provide an event for when the form is submitted
		        $('#form-sp').submit(function() {

		            
		            $(checkboxItems, this).prop('disabled', true);

		            // return true to allow the form to submit
		            return true;
		        });
		    });
		    
	</script>
	
	
	
	
	
	
	
	
	
 	<!-- Phân trang -->
	<script type="text/javascript">
		var totalPages = ${model.totalPages};
		// Cai nay la thong so hien thi chu khong phai data goi len server
		var type = `${model.getType()}`;
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
						$("#type").val(type);
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
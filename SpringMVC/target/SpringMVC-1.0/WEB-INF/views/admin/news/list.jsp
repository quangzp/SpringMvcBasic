<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="newsAPI" value="/api/admin/news" />
<c:url var="newsListURL" value="/admin/news/list" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Danh sách bài viết</title>
</head>
<body>
	<div class="main-content">
		<form action="<c:url value ='/admin/news/list' />" id="formSubmit" method="get">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty message }">
								<div class="alert alert-${alert}" role="alert">
							  		${message}
								</div>
							</c:if>
							<ul class="list-inline m-0">
                                       <li class="list-inline-item">
                                           <a class="btn btn-primary btn-sm rounded-0" data-toggle="tooltip"
                                            data-placement="top" title="Add" href='<c:url value="/admin/news/add"/>'>
                                            <i class="fa fa-plus-circle" aria-hidden="true"></i>
                                            </a>
                                       </li>
                                       <li class="list-inline-item">
                                       	    <button class="btn btn-warning btn-sm rounded-0 btn-checkbox" type="button" data-toggle="tooltip"
                                                data-placement="top" title="Hide" disabled>
                                                <i class="fa fa-eye-slash" ></i>
											</button>
                                       </li>
                                       <li class="list-inline-item">
                                           <button class="btn btn-danger btn-sm rounded-0 btn-checkbox" type="button" data-toggle="tooltip"
                                            data-placement="top" title="Delete" id="btn-delete" disabled>
                                            	<i class="fa fa-trash" ></i>
                                            </button>
                                       </li>
                                  </ul>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table id="data-table" class="table">
											<thead>
												<tr>
													<th class="col-xs-1">
														<label>
															<input type="checkbox" class="check" id="checkAll" autocomplete="off">
														</label>
													</th>
													<th>Tên bài viết</th>
													<th>Mô tả ngắn</th>
													<th>Thể loại</th>
													<th>Cập nhật</th>
													<th>Thao tác</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${news.list}">
													<tr class="item">
														<td><label><input type="checkbox" class="check" name="newsIds[]" id="check_${item.id}" autocomplete="off" value="${item.id}"></label></td>
														<td>${item.title}</td>
														<td>${item.shortDescription}</td>
														<td>${item.category.name}</td>
														<td id = "date">${item.modifiedDate}</td>
 														<td>
															<c:url var="editURL" value="/admin/news/edit">
																<c:param name="id" value ="${item.id}"/>
															</c:url>
			                                                <div class="list-inline-item">
			                                                    <a class="btn btn-success btn-sm rounded-0 top" data-toggle="tooltip"
			                                                     data-placement="top" title="Sửa" href='${editURL}'>
			                                                     <i class="fa fa-edit"></i>
			                                                     </a>
			                                                </div>				                                            
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<ul class="pagination" id="pagination"></ul>
										<input type="hidden" value="" id="page" name="page" />
										<input type="hidden" value="" id="size" name="size" />
										<!-- <input type="hidden" value="" id="sortField" name="sortField" />
										<input type="hidden" value="" id="sortBy" name="sortBy" />
										<input type="hidden" value="" id="type" name="type" /> -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!--end main-->
	<script type="text/javascript">
	//paging
		var totalPages = ${news.totalPages};
		var currentPage = ${news.page};
		var size = ${news.limitItems};
		$(function () {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages: totalPages,
				visiblePages: (totalPages>5)?5:totalPages,
				startPage: currentPage,
				onPageClick: function (event, page) {
					if(currentPage != page){
						$('#page').val(page);
						$('#size').val(size);
						/* $('#sortField').val('modifieddate');
						$('#sortBy').val('desc'); */
						$('#formSubmit').submit();
					}
				}
			});
		});
		// tooltip
		$(function () {
		    $('[data-toggle="tooltip"]').tooltip();
		});
		
		// btn-delete confirm
		$('#btn-delete').click(function (event){
			event.preventDefault();
			swal({
				  title: "Are you sure?",
				  text: "You will not be able to recover this post!",
				  type: "warning",
				  showCancelButton: true,
				  confirmButtonClass: "btn-danger",
				  confirmButtonText: "Yes, delete it!",
				  cancelButtonText: "No, cancel plx!",
				  closeOnConfirm: false,
				  closeOnCancel: false
				},
				function(isConfirm) {
				  if (isConfirm) {
				  	var ids = $('tbody input[type=checkbox]:checked').map(function(){
						return $(this).val();
					}).get();
				  	deleteNews(ids)
				  }else{
					  swal("Cancelled", "Your post is safe :)", "error");
				  }
				});
		})
		
		// delete function
		function deleteNews(data){
			$.ajax({
				url: '${newsAPI}',
				type: 'DELETE',
				contentType: 'application/json',
				data: JSON.stringify(data),
				success: function(result){
					swal("Deleted!", "Your post has been deleted.", "success");
					setTimeout(function () {
						window.location.href = "${newsListURL}";
					  }, 2000);
				},
				
				error: function(error){
					swal("Error", "The system has issues. Your post is safe", "error");
					setTimeout(function () {
						window.location.href = "${newsListURL}";
					  }, 2000);
				}
			});
		}
		
		var itemCheckbox = $('input[name="newsIds[]"]');
		
		// checkbox All changed
		$("#checkAll").click(function () {
			itemCheckbox.prop('checked', $(this).prop('checked'));
		});
		
		// item checkbox change
		itemCheckbox.click(function () {
			var isCheckedAll = itemCheckbox.length == $('input[name="newsIds[]"]:checked').length;
			$("#checkAll").prop('checked',isCheckedAll);
		});
		
		// delete-button and hide-button change
		$(function() {
		    $('.check').click(function() {
		    	var checkedItems = $('input[name="newsIds[]"]:checked').length;
		        if (checkedItems>0) {
		           $('.btn-checkbox').removeAttr('disabled');
		        } else {
		           $('.btn-checkbox').attr('disabled', 'disabled');
		        }
		    });
		});
		
				
	</script>
</body>

</html>
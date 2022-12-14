<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newsURL" value="/admin/news" />
<c:url var="newsAPI" value="/api/admin/news" />
<c:url var="action" value="/admin/news/add" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
	<c:if test="${not empty message }">
		<div class="alert alert-${alert}" role="alert">
		  ${message}
		</div>
	</c:if>
	<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="news" enctype="multipart/form-data">
		<div class="form-group">
			<div class="col-sm-9">
				<label class="col-sm-3 control-label">Category</label>
				<form:select class="col-sm-9" path="categoryCode" id="categoryCode">
					<form:option value="" label="--Select category---"/>
					<form:options items="${categories.list}" itemValue="code" itemLabel="name"/>
				</form:select>				
				<form:errors path="categoryCode" cssClass="alert alert-danger" element="div"></form:errors>				
				</div>
		</div>
		<div class="space-4"></div>
		<div class="form-group">
			<div class="col-sm-9">
				<label class="col-sm-3 control-label">Title</label>
				<form:input path="title" cssClass="col-sm-9"/>
				<form:errors path="title" cssClass="alert alert-danger" element="div"></form:errors>	
			</div>
		</div>
		<div class="space-4"></div>
		<div class="form-group">
			<div class="col-sm-9">
				<label class="col-sm-3 control-label">Thumbnail</label>
				<c:if test="${not empty news.thumbnail}">
					<img alt="" src="${news.thumbnail}" style="width:200px">
					<form:hidden path="thumbnail"/>
				</c:if>
				<input type="file" accept="image/png, image/jpeg" name="photoFile" id="photoFile" multiple/>
				<form:errors path="photoFile" cssClass="alert alert-danger" element="div"></form:errors>	
			</div>
		</div>
		<div class="space-4"></div>
		<div class="form-group">
			<div class="col-sm-9">
				 <label class="col-sm-3 control-label">Short description</label>
				<form:textarea path="shortDescription" rows="5" cols="10" cssClass="col-sm-9" id="shortDescription"/>
				<form:errors path="shortDescription" cssClass="alert alert-danger" element="div"></form:errors>	
			</div>
		</div>
		<div class="space-4"></div>
		<div class="form-group">
			<div class="col-sm-9">
				<label class="col-sm-3 control-label">Content</label>	
				<form:textarea path="content" cssClass="col-sm-9" id="content"/>
				<form:errors path="content" cssClass="alert alert-danger" element="div"></form:errors>	
			</div>
		</div>
		<div class="space-4"></div>
		<form:hidden path="id" id="newsId"/>
		<div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
				<button class="btn btn-info" type="button" id="btnForm">
					<i class="ace-icon fa fa-check bigger-110"></i>
					Submit
				</button>

				&nbsp; &nbsp; &nbsp;
				<button class="btn" type="reset">
					<i class="ace-icon fa fa-undo bigger-110"></i>
					Reset
				</button>
			</div>
		</div>
	</form:form>
	<div class="space-4"></div>
<script type="text/javascript">
	var ckEditor;
	$(document).ready(function(e) {
		editor = CKEDITOR.replace('content');
	});
	
 	$('#btnForm').click(function(event){
		event.preventDefault();
		
			var data = {};
			var textData = $('#formSubmit').serializeArray();
			$.each(textData,function(i, value){
				data[value.name] = value.value;
			});
			data["slug"] = to_slug(data["title"]);
			data["content"] = editor.getData();
			
			const formData = new FormData();
			
			formData.append('news', new Blob([JSON.stringify(data)], {
	            type: "application/json"
	        }));
			formData.append('photoFile', $('#photoFile')[0].files[0]);
					
			saveOrUpdate(formData);
		
	}); 
	
	function saveOrUpdate(data){
		$.ajax({
			url: '${newsAPI}',
			type: 'POST',
			method: 'POST',
			data: data,
			cache: false,
	        contentType: false,
	        processData: false,
			//enctype : 'multipart/form-data',
			//contentType: 'application/json',
			//data: JSON.stringify(data),
			//dataType: 'json',
			success: function(response, data, data){
				swal({
					title: "Save!", 
					text: "Your post has been save.", 
					type: "success",
					timer: 2000
				},function () {
					window.location.href = "${newsURL}/list"
		            //location.reload(true);
		            tr.hide();
		          });
				
				/*   setTimeout(function () {
					window.location.href = "${newsURL}/list";
				  }, 2000); */
			},
			
			error: function(jqxhr, status, errorMessage){
				window.location.href = "${newsURL}/add?message=error_system";
			}
		});
	}
	
	/* function updateNews(data){
		$.ajax({
			url: '${newsAPI}',
			type: 'POST',
			method: 'POST',
			data: data,
			cache: false,
	        contentType: false,
	        processData: false,
			contentType: 'application/json',
			dataType: 'json',
			success: function(result){
				window.location.href = "${newsURL}/edit?id="+result.id+"&message=update_success";
			},
			
			error: function(error){
				window.location.href = "${newsURL}/list";
			}
		});
	} */
	
	function to_slug(str){
	    // Chuy???n h???t sang ch??? th?????ng
	    str = str.toLowerCase();     

	    // x??a d???u
	    str = str.replace(/(??|??|???|???|??|??|???|???|???|???|???|??|???|???|???|???|???)/g, 'a');
	    str = str.replace(/(??|??|???|???|???|??|???|???|???|???|???)/g, 'e');
	    str = str.replace(/(??|??|???|???|??)/g, 'i');
	    str = str.replace(/(??|??|???|???|??|??|???|???|???|???|???|??|???|???|???|???|???)/g, 'o');
	    str = str.replace(/(??|??|???|???|??|??|???|???|???|???|???)/g, 'u');
	    str = str.replace(/(???|??|???|???|???)/g, 'y');
	    str = str.replace(/(??)/g, 'd');

	    // X??a k?? t??? ?????c bi???t
	    str = str.replace(/([^0-9a-z-\s])/g, '');

	    // X??a kho???ng tr???ng thay b???ng k?? t??? -
	    str = str.replace(/(\s+)/g, '-');

	    // x??a ph???n d??? - ??? ?????u
	    str = str.replace(/^-+/g, '');

	    // x??a ph???n d?? - ??? cu???i
	    str = str.replace(/-+$/g, '');

	    // return
	    return str;
	}
</script>
</body>
</html>
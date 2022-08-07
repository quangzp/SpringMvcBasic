<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<title><dec:title default="Trang chủ" /></title>
	<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"></script>
    <link href="${context}/template/admin/css/styles.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
    <script src="${context}/template/sweetalert/sweetalert.js"></script>
    <link rel="stylesheet" href="${context}/template/sweetalert/sweetalert.css">
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
    <script src="${context}/ckeditor/ckeditor.js"></script>
</head>
<body class="sb-nav-fixed">
	<!-- header -->
	<%@ include file="/common/admin/header.jsp"%>
	<!-- header -->
	<div id="layoutSidenav">
		<%@ include file="/common/admin/menu.jsp"%>
		
		<div id="layoutSidenav_content">
			<!-- main -->
				<dec:body />
			<!-- main -->
		
			<!-- footer -->
				<%@ include file="/common/admin/footer.jsp"%>
			<!-- footer -->
		</div>
	
	</div>
	
	<!-- script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="${context}/template/paging/jquery.twbsPagination.min.js"></script>
    <script src="${context}/template/admin/js/scripts.js"></script>
</body>
</html>
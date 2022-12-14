<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><dec:title default="Trang chủ" /></title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="shortcut icon" type="image/x-icon" href="${context}/template/web/assets/img/logo/logo.png">
	
    <!-- CSS  -->
    <link rel="stylesheet"href="${context}/template/web/assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="${context}/template/web/assets/css/owl.carousel.min.css">
	<link rel="stylesheet" href="${context}/template/web/assets/css/ticker-style.css">
	<link rel="stylesheet" href="${context}/template/web/assets/css/flaticon.css">
	<link rel="stylesheet" href="${context}/template/web/assets/css/slicknav.css">
	<link rel="stylesheet" href="${context}/template/web/assets/css/animate.min.css">
	<link rel="stylesheet" href="${context}/template/web/assets/css/magnific-popup.css">
	<link rel="stylesheet" href="${context}/template/web/assets/css/fontawesome-all.min.css">
	<link rel="stylesheet" href="${context}/template/web/assets/css/themify-icons.css">
	<link rel="stylesheet" href="${context}/template/web/assets/css/slick.css">
	<link rel="stylesheet" href="${context}/template/web/assets/css/nice-select.css">
	<link rel="stylesheet" href="${context}/template/web/assets/css/style.css">
	<link rel="stylesheet" href="${context}/template/web/assets/css/responsive.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
	
    
</head>
<body style="overflow: visible;">
	<!-- header -->
    <%@ include file="/common/web/header.jsp" %>
    <!-- header -->
    
    <div>
    	<dec:body/>
    </div>

	<!-- footer -->
	<%@ include file="/common/web/footer.jsp" %>
	<!-- footer -->	
	
	 <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


     <!--
  JavaScripts
  ========================== -->
   
	<!-- All JS Custom Plugins Link Here here -->
	<script src="${context}/template/paging/jquery.twbsPagination.min.js"></script>
	<script src="${context}/template/web//assets/js/vendor/modernizr-3.5.0.min.js"></script>
	<!-- Jquery, Popper, Bootstrap -->
	<script src="${context}/template/web/assets/js/popper.min.js"></script>
	<script src="${context}/template/web/assets/js/bootstrap.min.js"></script>
	<!-- Jquery Mobile Menu -->
	<script src="${context}/template/web/assets/js/jquery.slicknav.min.js"></script>
	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="${context}/template/web/assets/js/owl.carousel.min.js"></script>
	<script src="${context}/template/web/assets/js/slick.min.js"></script>
	<!-- Date Picker -->
	<script src="${context}/template/web/assets/js/gijgo.min.js"></script>
	<!-- One Page, Animated-HeadLin -->
	<script src="${context}/template/web/assets/js/wow.min.js"></script>
	<script src="${context}/template/web/assets/js/animated.headline.js"></script>
	<script src="${context}/template/web/assets/js/jquery.magnific-popup.js"></script>
	 
	<!-- Breaking New Pluging -->
	<script src="${context}/template/web/assets/js/jquery.ticker.js"></script>
	<script src="${context}/template/web/assets/js/site.js"></script>
	 
	<!-- Scrollup, nice-select, sticky -->
	<script src="${context}/template/web/assets/js/jquery.scrollUp.min.js"></script>
	<script src="${context}/template/web/assets/js/jquery.nice-select.min.js"></script>
	<script src="${context}/template/web/assets/js/jquery.sticky.js"></script>
	
		<!-- Jquery Plugins, main Jquery -->   
	<script src="${context}/template/web/assets/js/plugins.js"></script>
	<script src="${context}/template/web/assets/js/main.js"></script>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.springmvc.utils.SecurityUtils"%> <!-- authorize  -->
<%@ include file="/common/taglib.jsp" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!-- Header Start -->
<div class="header-area">
	<div class="main-header ">
		<div class="header-top black-bg d-none d-md-block">
			<div class="container">
				<div class="col-xl-12">
					<div class="row d-flex justify-content-between align-items-center">
						<div class="header-info-left"></div>
						<div class="header-info-right">
							<ul class="header-social">
								<security:authorize access="isAnonymous()">
								<li><a href="${context}/login">Login</a></li>
								<li><a href="${context}/register">Register</a></li>								
								</security:authorize>
								<security:authorize access="isAuthenticated()">
								<li><a href="#">Welcome <%=SecurityUtils.getPrincipal().getFullName()%></a></li>
								<li><a href="${context}/logout">Logout</a></li>								
								</security:authorize>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="header-mid d-none d-md-block">
			<div class="container">
				<div class="row d-flex align-items-center">
					<!-- Logo -->
					<div class="col-xl-3 col-lg-3 col-md-3">
						<div class="logo">
							<a href="${context}/"><img src="${context}/template/web/assets/img/logo/logo.png"
								alt=""></a>
						</div>
					</div>
					<div class="col-xl-9 col-lg-9 col-md-9">
						
					</div>
				</div>
			</div>
		</div>
		<div class="header-bottom header-sticky">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-xl-10 col-lg-10 col-md-12 header-flex">
						<!-- sticky -->
						<div class="sticky-logo info-open">
							<a href="${context}/"><img src="${context}/template/web/assets/img/logo/logo.png"
								alt=""></a>
						</div>
						<!-- Main-menu -->
						<div class="main-menu d-none d-md-block">
							<nav>
								<ul id="navigation">
									<li><a href="${context}/">Home</a></li>
									
									<!-- show categories -->
									<c:forEach var="c" items="${categories}" >
											<li><a href="${context}/news/${c.code}">${c.name}</a></li>							
									</c:forEach>
									
									<!-- <li><a href="latest_news.html">Latest News</a></li> -->
									<!-- <li><a href="about.html">About</a></li> -->
								</ul>
							</nav>
						</div>
					</div>
					<div class="col-xl-2 col-lg-2 col-md-4">
						<div class="header-right-btn f-right d-none d-lg-block">
							<i class="fas fa-search special-tag"></i>
							<div class="search-box">
								<form action="#">
									<input type="text" placeholder="Search">

								</form>
							</div>
						</div>
					</div>
					<!-- Mobile Menu -->
					<div class="col-12">
						<div class="mobile_menu d-block d-md-none">
							<div class="slicknav_menu">
								<a href="${context}/" aria-haspopup="true" role="button" tabindex="0"
									class="slicknav_btn slicknav_collapsed"><span
									class="slicknav_menutxt">MENU</span><span class="slicknav_icon"><span
										class="slicknav_icon-bar"></span><span
										class="slicknav_icon-bar"></span><span
										class="slicknav_icon-bar"></span></span></a>
								<ul class="slicknav_nav slicknav_hidden" aria-hidden="true"
									role="menu" style="display: none;">
									<li><a href="${context}/home" role="menuitem" tabindex="-1">Home</a></li>
									<c:forEach var="c" items="${categories}" >
											<li><a href="${context}/category/${c.id}" role="menuitem" tabindex="-1">${c.name}</a></li>							
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


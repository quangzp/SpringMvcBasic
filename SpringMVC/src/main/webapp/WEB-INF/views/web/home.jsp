<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>

<body>
	<!-- Trending Area Start -->
	<div class="trending-area fix">
		<div class="container">
			<div class="trending-main">
				<!-- Trending Tittle -->
				<div class="row">
					<div class="col-lg-12">
						<div class="trending-tittle">
							<!-- <strong>Trending now</strong> -->
							<!-- <p>Rem ipsum dolor sit amet, consectetur adipisicing elit.</p> -->
							<!-- <div class="trending-animated">
								<ul id="js-news" class="js-hidden">
									<li class="news-item">Bangladesh dolor sit amet,
										consectetur adipisicing elit.</li>
									<li class="news-item">Spondon IT sit amet,
										consectetur.......</li>
									<li class="news-item">Rem ipsum dolor sit amet,
										consectetur adipisicing elit.</li>
								</ul>
							</div> -->
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-8">
						<!-- Trending Top -->
						<div class="trending-top mb-30">
							<div class="trend-top-img">
								<img src="${lastestNews.get(0).thumbnail}" alt="">
								<div class="trend-top-cap">
									<span>${lastestNews.get(0).category.name}</span>
									<h2>
										<a href="${context}/news/${lastestNews.get(0).id}/${lastestNews.get(0).slug}">${lastestNews.get(0).title}</a>
									</h2>
								</div>
							</div>
						</div>
						<!-- Trending Bottom -->
						<div class="trending-bottom">
							<div class="row">
								<c:forEach var="i" begin = "1" end = "3">
									<div class="col-lg-4">
										<div class="single-bottom mb-35">
											<div class="trend-bottom-img mb-30">
												<img src="${lastestNews.get(i).thumbnail}" alt="">
											</div>
											<div class="trend-bottom-cap">
												<span class="color${i}">${lastestNews.get(i).category.name}</span>
												<h4>
													<a href="${context}/news/${lastestNews.get(i).id}/${lastestNews.get(i).slug}">${lastestNews.get(i).title}</a>
												</h4>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
					<!-- Riht content -->
					<div class="col-lg-4">
						<c:forEach var="i" begin = "4" end = "8">
							<div class="trand-right-single d-flex">
								<div class="trand-right-img">
									<img src="${lastestNews.get(i).thumbnail}" alt="" width="120px">
								</div>
								<div class="trand-right-cap">
									<span class="color1">${lastestNews.get(i).category.name}</span>
									<h4>
										<a href="${context}/news/${lastestNews.get(i).id}/${lastestNews.get(i).slug}">${lastestNews.get(i).title}</a>
									</h4>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Trending Area End -->
	<!-- Whats New Start -->
	<section class="whats-news-area pt-50 pb-20">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="row d-flex justify-content-between">
						<div class="col-lg-3 col-md-3">
							<div class="section-tittle mb-30">
								<h3>Whats new</h3>
							</div>
						</div>
						<div class="col-lg-9 col-md-9">
							<div class="properties__button">
								<!--Nav Button  -->
								<nav>
									<div class="nav nav-tabs" id="nav-tab" role="tablist">
										<a class="nav-item nav-link active" id="nav-all-tab"
											data-toggle="tab" href="#nav-all" role="tab"
											aria-controls="nav-all" aria-selected="true">All</a>
										<c:forEach var="c" items="${categories}">
											<a class="nav-item nav-link" id="nav-${c.code}-tab"
												data-toggle="tab" href="#nav-${c.code}" role="tab"
												aria-controls="nav-${c.code}" aria-selected="false">${c.name}</a>										
										</c:forEach>
									</div>
								</nav>
								<!--End Nav Button  -->
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<!-- Nav Card -->
							<div class="tab-content" id="nav-tabContent">
								<!-- card one -->
								<div class="tab-pane fade show active" id="nav-all"
									role="tabpanel" aria-labelledby="nav-all">
									<div class="whats-news-caption">
										<div class="row">
											<c:forEach var="i" begin="9" end="12">
												<div class="col-lg-6 col-md-6">
													<div class="single-what-news mb-100">
														<div class="what-img">
															<img src="${lastestNews.get(i).thumbnail}" alt="">
														</div>
														<div class="what-cap" style="height:64%;">
															<span class="color1">${lastestNews.get(i).category.name}</span>
															<h4>
																<a href="${context}/news/${lastestNews.get(i).id}/${lastestNews.get(i).slug}">${lastestNews.get(i).title}</a>
															</h4>
														</div>
													</div>
												</div>
											</c:forEach>
											
										</div>
									</div>
								</div>
								<!-- Card two -->
								<div class="tab-pane fade" id="nav-life-style" role="tabpanel"
									aria-labelledby="nav-life-style">
									<div class="whats-news-caption">
										<div class="row">
											<c:forEach var="i" begin="0" end="3">
												<div class="col-lg-6 col-md-6">
													<div class="single-what-news mb-100">
														<div class="what-img">
															<img src="${lifeStyle.get(i).thumbnail}" alt="">
														</div>
														<div class="what-cap" style="height:64%;">
															<span class="color1">${lifeStyle.get(i).category.name}</span>
															<h4>
																<a href="${context}/news/${lifeStyle.get(i).id}/${lifeStyle.get(i).slug}">${lifeStyle.get(i).title}</a>
															</h4>
														</div>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
								<!-- Card three -->
								<div class="tab-pane fade" id="nav-travel" role="tabpanel"
									aria-labelledby="nav-travel">
									<div class="whats-news-caption">
										<div class="row">
											<c:forEach var="i" begin="0" end="3">
												<div class="col-lg-6 col-md-6">
													<div class="single-what-news mb-100">
														<div class="what-img">
															<img src="${travel.get(i).thumbnail}" alt="">
														</div>
														<div class="what-cap" style="height:64%;">
															<span class="color1">${travel.get(i).category.name}</span>
															<h4>
																<a href="${context}/news/${travel.get(i).id}/${travel.get(i).slug}">${travel.get(i).title}</a>
															</h4>
														</div>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
								<!-- card fure -->
								<div class="tab-pane fade" id="nav-fashion" role="tabpanel"
									aria-labelledby="nav-fashion">
									<div class="whats-news-caption">
										<div class="row">
											<c:forEach var="i" begin="0" end="3">
												<div class="col-lg-6 col-md-6">
													<div class="single-what-news mb-100">
														<div class="what-img">
															<img src="${fashion.get(i).thumbnail}" alt="">
														</div>
														<div class="what-cap" style="height:64%;">
															<span class="color1">${fashion.get(i).category.name}</span>
															<h4>
																<a href="${context}/news/${fashion.get(i).id}/${fashion.get(i).slug}">${fashion.get(i).title}</a>
															</h4>
														</div>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
								<!-- card Five -->
								<div class="tab-pane fade" id="nav-sport" role="tabpanel"
									aria-labelledby="nav-sport">
									<div class="whats-news-caption">
										<div class="row">
											<c:forEach var="i" begin="0" end="3">
												<div class="col-lg-6 col-md-6">
													<div class="single-what-news mb-100">
														<div class="what-img">
															<img src="${sport.get(i).thumbnail}" alt="">
														</div>
														<div class="what-cap" style="height:64%;">
															<span class="color1">${sport.get(i).category.name}</span>
															<h4>
																<a href="${context}/news/${sport.get(i).id}/${sport.get(i).slug}">${sport.get(i).title}</a>
															</h4>
														</div>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
								<!-- card Six -->
								<div class="tab-pane fade" id="nav-technology" role="tabpanel"
									aria-labelledby="nav-technology">
									<div class="whats-news-caption">
										<div class="row">
											<c:forEach var="i" begin="0" end="3">
												<div class="col-lg-6 col-md-6">
													<div class="single-what-news mb-100">
														<div class="what-img">
															<img src="${technology.get(i).thumbnail}" alt="">
														</div>
														<div class="what-cap" style="height:64%;">
															<span class="color1">${technology.get(i).category.name}</span>
															<h4>
																<a href="${context}/news/${technology.get(i).id}/${technology.get(i).slug}">${technology.get(i).title}</a>
															</h4>
														</div>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
							<!-- End Nav Card -->
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<!-- Section Tittle -->
					<div class="section-tittle mb-40">
						<h3>Follow Us</h3>
					</div>
					<!-- Flow Socail -->
					<div class="single-follow mb-45">
						<div class="single-box">
							<div class="follow-us d-flex align-items-center">
								<div class="follow-social">
									<a href="#"><img src="${context}/template/web/assets/img/news/icon-fb.png" alt=""></a>
								</div>
								<div class="follow-count">
									<span>8,045</span>
									<p>Fans</p>
								</div>
							</div>
							<div class="follow-us d-flex align-items-center">
								<div class="follow-social">
									<a href="#"><img src="${context}/template/web/assets/img/news/icon-tw.png" alt=""></a>
								</div>
								<div class="follow-count">
									<span>8,045</span>
									<p>Fans</p>
								</div>
							</div>
							<div class="follow-us d-flex align-items-center">
								<div class="follow-social">
									<a href="#"><img src="${context}/template/web/assets/img/news/icon-ins.png" alt=""></a>
								</div>
								<div class="follow-count">
									<span>8,045</span>
									<p>Fans</p>
								</div>
							</div>
							<div class="follow-us d-flex align-items-center">
								<div class="follow-social">
									<a href="#"><img src="${context}/template/web/assets/img/news/icon-yo.png" alt=""></a>
								</div>
								<div class="follow-count">
									<span>8,045</span>
									<p>Fans</p>
								</div>
							</div>
						</div>
					</div>
					<!-- New Poster -->
					<div class="news-poster d-none d-lg-block">
						
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Whats New End -->
	<!--   Weekly2-News start -->
	<div class="weekly2-news-area  weekly2-pading gray-bg">
		<div class="container">
			<div class="weekly2-wrapper">
				<!-- section Tittle -->
				<div class="row">
					<div class="col-lg-12">
						<div class="section-tittle mb-30">
							<h3>Weekly Top News</h3>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
						<div class="weekly2-news-active dot-style d-flex dot-style">
							<c:forEach var="item" items="${topNews}">
								<div class="weekly2-single">
									<div class="weekly2-img">
										<img src="${item.thumbnail}" alt="">
									</div>
									<div class="weekly2-caption">
										<span class="color1">${item.category.name}</span>
										<p>${item.createdDate}</p>
										<h4>
											<a href="${context}/news/${item.id}/${item.slug}">${item.title}</a>
										</h4>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Weekly-News -->
	
	<!--  Recent Articles start -->
	<%-- <div class="recent-articles">
		<div class="container">
			<div class="recent-wrapper">
				<!-- section Tittle -->
				<div class="row">
					<div class="col-lg-12">
						<div class="section-tittle mb-30">
							<h3>Recent Articles</h3>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
						<div class="recent-active dot-style d-flex dot-style">
							<div class="single-recent mb-100">
								<div class="what-img">
									<img src="${context}/template/web/assets/img/news/recent1.jpg" alt="">
								</div>
								<div class="what-cap">
									<span class="color1">Night party</span>
									<h4>
										<a href="#">Welcome To The Best Model Winner Contest</a>
									</h4>
								</div>
							</div>
							<div class="single-recent mb-100">
								<div class="what-img">
									<img src="${context}/template/web/assets/img/news/recent2.jpg" alt="">
								</div>
								<div class="what-cap">
									<span class="color1">Night party</span>
									<h4>
										<a href="#">Welcome To The Best Model Winner Contest</a>
									</h4>
								</div>
							</div>
							<div class="single-recent mb-100">
								<div class="what-img">
									<img src="${context}/template/web/assets/img/news/recent3.jpg" alt="">
								</div>
								<div class="what-cap">
									<span class="color1">Night party</span>
									<h4>
										<a href="#">Welcome To The Best Model Winner Contest</a>
									</h4>
								</div>
							</div>
							<div class="single-recent mb-100">
								<div class="what-img">
									<img src="${context}/template/web/assets/img/news/recent2.jpg" alt="">
								</div>
								<div class="what-cap">
									<span class="color1">Night party</span>
									<h4>
										<a href="#">Welcome To The Best Model Winner Contest</a>
									</h4>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> --%>
	<!--Recent Articles End -->
	<!--Start pagination -->
	<!-- <div class="pagination-area pb-45 text-center">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="single-wrap d-flex justify-content-center">
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-start">
								<li class="page-item"><a class="page-link" href="#"><span
										class="flaticon-arrow roted"></span></a></li>
								<li class="page-item active"><a class="page-link" href="#">01</a></li>
								<li class="page-item"><a class="page-link" href="#">02</a></li>
								<li class="page-item"><a class="page-link" href="#">03</a></li>
								<li class="page-item"><a class="page-link" href="#"><span
										class="flaticon-arrow right-arrow"></span></a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div> -->
	<!-- End pagination  -->
	<script type="text/javascript">
	</script>
</body>

</html>
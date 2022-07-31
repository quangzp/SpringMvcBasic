<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${news.title}</title>
</head>
<body>
<div class="about-area">
	<div class="container">
	<!-- Starting Treding  -->
		<div class="row">
	        <div class="col-lg-8">
	        	<div class="section-tittle mb-30 pt-30">
	                <h3>${news.title}</h3>
                <p class="about-pera1 mb-25">${news.shortDescription}</p>
	            </div>
	        </div>
	    </div>
 <!-- End Trending -->
		<div class="row">
		    <div class="col-lg-8">
		        <!-- Trending Tittle -->
		        <div class="about-right mb-90">
		            <div class="about-img">
		                <img src="${news.thumbnail}" alt="${news.title}">
		            </div>
		            <div class="about-prea">
		                <p class="about-pera1 mb-25">${news.content}</p>
		            </div>
		            <div class="social-share pt-30">
		                <div class="section-tittle">
		                    <h3 class="mr-20">Share:</h3>
		                    <ul>
		                        <li><a href="#"><img src="${context}/template/web/assets/img/news/icon-ins.png" alt=""></a></li>
		                        <li><a href="#"><img src="${context}/template/web/assets/img/news/icon-fb.png" alt=""></a></li>
		                        <li><a href="#"><img src="${context}/template/web/assets/img/news/icon-tw.png" alt=""></a></li>
		                        <li><a href="#"><img src="${context}/template/web/assets/img/news/icon-yo.png" alt=""></a></li>
		                    </ul>
		                </div>
		            </div>
		     <!--Comments-area  -->
		            <div class="comments-area">
	                  <h4>05 Comments</h4>
	                  <div class="comment-list">
	                     <div class="single-comment justify-content-between d-flex">
	                        <div class="user justify-content-between d-flex">
	                           <div class="thumb">
	                              <img src="${context}/template/web/assets/img/comment/comment_3.png" alt="">
	                           </div>
	                           <div class="desc">
	                              <p class="comment">
	                                 Multiply sea night grass fourth day sea lesser rule open subdue female fill which them
	                                 Blessed, give fill lesser bearing multiply sea night grass fourth day sea lesser
	                              </p>
	                              <div class="d-flex justify-content-between">
	                                 <div class="d-flex align-items-center">
	                                    <h5>
	                                       <a href="#">Emilly Blunt</a>
	                                    </h5>
	                                    <p class="date">December 4, 2017 at 3:12 pm </p>
	                                 </div>
	                                 <div class="reply-btn">
	                                    <a href="#" class="btn-reply text-uppercase">reply</a>
	                                 </div>
	                              </div>
	                           </div>
	                        </div>
	                     </div>
	                   </div>
		             </div>
		       <!-- Comment Form  -->
		       		<div class="comment-form">
	                  <h4>Leave a Reply</h4>
	                  <form class="form-contact comment_form" action="#" id="commentForm">
	                     <div class="row">
	                        <div class="col-12">
	                           <div class="form-group">
	                              <textarea class="form-control w-100" name="comment" id="comment" cols="30" rows="9" placeholder="Write Comment"></textarea>
	                           </div>
	                        </div>
	                        <div class="col-sm-6">
	                           <div class="form-group">
	                              <input class="form-control" name="name" id="name" type="text" placeholder="Name">
	                           </div>
	                        </div>
	                        <div class="col-sm-6">
	                           <div class="form-group">
	                              <input class="form-control" name="email" id="email" type="email" placeholder="Email">
	                           </div>
	                        </div>
	                        <div class="col-12">
	                           <div class="form-group">
	                              <input class="form-control" name="website" id="website" type="text" placeholder="Website">
	                           </div>
	                        </div>
	                     </div>
	                     <div class="form-group">
	                        <button type="submit" class="button button-contactForm btn_1 boxed-btn">Send Message</button>
	                     </div>
	                  </form>
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
		            <img src="${context}/template/web/assets/img/news/news_card.jpg" alt="">
		        </div>
		    </div>
		</div>
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.springmvc.utils.SecurityUtils"%> <!-- authorize  -->
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:url var="commentApi" value="/api/comment" />
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
		            
		               <!-- Comment Form  -->
		       		<div class="comment-form">
	                  <h4>Leave a Reply</h4>
	                  <form class="form-contact comment_form" action="#" id="comment-form">
	                     <div class="row">
	                        <div class="col-12">
	                           <div class="form-group">
	                              <textarea class="form-control w-100" name="content" id="comment" cols="20" rows="4" placeholder="Write Comment"></textarea>
	                              <input type="hidden" name="newsId" value="${news.id}" />
	                           </div>
	                        </div>
	                     </div>
	                     <div id="alert-login" class="alert alert-danger" style="display:none;">Login please!</div>
	                     <div class="form-group">
	                        <button id="btn-comment" type="button" class="button button-contactForm btn_1 boxed-btn">Send Comment</button>
	                     </div>
	                  </form>
	               </div>
	               <!-- end Comment  -->
	               
		     <!--Comments-area  -->
		            <div class="comments-area" id=comments-area>
	                  <h4 id="total-comment">${comments.totalItems} Comments</h4>
	                  <c:forEach var="commentItem" items="${comments.list}">
	                  	<div class="comment-list">
	                     <div class="single-comment justify-content-between d-flex">
	                        <div class="user justify-content-between d-flex">
	                           <div class="thumb">
	                              <img src="${context}/template/web/assets/img/comment/comment_3.png" alt="">
	                           </div>
	                           <div class="desc">
	                             <p class="comment">${commentItem.content}</p>
	                              <div class="d-flex justify-content-between">
	                                 <div class="d-flex align-items-center">
	                                    <h5>
	                                       <a href="#">${commentItem.userFullName}</a>
	                                    </h5>
	                                    <p class="comment-date date">${commentItem.createdDate}</p>
	                                    <script></script>
	                                 </div>
	                                 <div class="reply-btn">
	                                    <a href="#" class="btn-reply text-uppercase">reply</a>
	                                 </div>
	                              </div>
	                           </div>
	                        </div>
	                     </div>
	                   </div>
	                  </c:forEach>
		             </div>
                  	<div class="view_more_comment justify-content-center">
                  		<c:if test="${comments.limitItems < comments.totalItems}">
                  			<a id="show_more_comment" href="javascript:;" class="txt_666 genric-btn danger-border circle arrow" title="Show more">Show more</a>
                  		</c:if>
                 	 </div>
                 	 <!-- end comment  -->
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
		                        <p>hâm mộ</p>
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

<script type="text/javascript">
	/* Begin Set comment time  */
	let date = document.getElementsByClassName('comment-date');
	for(let i = 0; i < date.length; i++){
		date[i].innerHTML = moment(date[i].innerHTML).fromNow();
	}
	/* End Set comment time  */
	
	/* Global var */
	var totalComments = ${comments.totalItems};
	var newsId = ${news.id};
	
	
	// send comment
	$('#btn-comment').click(function(event){
		event.preventDefault();
		var data = {};
		var formData = $('#comment-form').serializeArray();
		$.each(formData,function(i, value){
			data[value.name] = value.value;
		});
        
		$.ajax({
			url: '${commentApi}',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function(result){
				let text = document.getElementById('total-comment');
				let html = commentHTML(result);
				text.insertAdjacentHTML("afterend", html);
				text.innerText = `\${++totalComments} Comments`;
				document.getElementById('comment-form').reset();
			},
			
			error: function(error){
				$('#alert-login').css("display","block");
			}
		});
	});
	
	///////////////////////////////////
	
	$('#show_more_comment').click(function(){
		// get total commtents are showing
		var size = $('.comment-list').length;
		
		// default load from page 2nd
		var currentPage = 1; 
		
		showComments(newsId, currentPage, size); 
	});
	
	function showComments(newsId,page,size){
		
		var url = '${commentApi}' +"?newsId="+newsId+"&page="+page+"&size="+size;
		
		$.ajax({
			url: url,
			type: 'GET',
			dataType: 'json',
			//contentType: 'application/json',
			success: function(result){
				var area = document.getElementById('comments-area');
				var arr = result.list;
				for(let i in arr){
					area.innerHTML +=  commentHTML(arr[i]) ;
				}
				if($('.comment-list').length === result.totalItems){
					$('.view_more_comment').css("display", "none");
				}
								
			},
			
			error: function(error){
				console.log(error);
			}
		});
	} 
	
	function commentHTML(item){
		return `<div class="comment-list">
			 <div class="single-comment justify-content-between d-flex">
			<div class="user justify-content-between d-flex">
		  <div class="thumb">
             <img src="${context}/template/web/assets/img/comment/comment_3.png" alt="">
          </div>
          <div class="desc">
            <p class="comment">\${item.content}</p>
             <div class="d-flex justify-content-between">
                <div class="d-flex align-items-center">
                   <h5>
                      <a href="#">\${item.userFullName}</a>
                   </h5>
                   <p class="date">\${moment(item.createdDate).fromNow()}</p>
                </div>
                <div class="reply-btn">
                   <a href="#" class="btn-reply text-uppercase">reply</a>
                </div>
		             </div>
		          </div>
		       </div>
		    </div>
		  </div>`;
	}
	
</script>
</body>
</html>
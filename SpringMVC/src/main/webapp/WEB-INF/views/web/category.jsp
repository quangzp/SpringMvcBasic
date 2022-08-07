<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/common/taglib.jsp"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>${news.category.name}</title>
</head>
<body>
<section class="blog_area section-padding">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mb-5 mb-lg-0">
                <div class="blog_left_sidebar">
                
                	<c:forEach var="item" items="${news.list}">
	                    <article class="blog_item">
	                        <div class="blog_item_img">
	                            <img class="card-img rounded-0" src="${item.thumbnail}" alt="">
	                            <div class="blog_item_date">
	                            	<div hidden="true">${item.createdDate}</div>
	                                <h3 class="day"></h3>
	                                <p class="month"></p>
	                            </div>
	                        </div>
	
	                        <div class="blog_details">
	                            <a class="d-inline-block" href="${context}/news/${item.id}/${item.slug}">
	                                <h2>${item.title}</h2>
	                            </a>
	                            <p>${item.shortDescription}</p>
	                            <ul class="blog-info-link">
	                                <li><a href="#"><i class="fa fa-comments"></i>${item.totalComments}</a></li>
	                            </ul>
	                        </div>
	                    </article>
                	</c:forEach>	
                    <ul class="pagination" id="pagination"></ul>
                </div>
            </div>
        </div>
    </div>
</section>

<script type="text/javascript">
	/* Begin fommat time news  */
	let arrPostDate = document.getElementsByClassName('blog_item_date');
	var months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
	for(let i = 0; i < arrPostDate.length; i++){	
		var date = new Date(arrPostDate[i].children[0].innerText);
		arrPostDate[i].children[1].innerText = date.getDate();
		arrPostDate[i].children[2].innerText = months[date.getMonth()];
	}
	/* End fommat time news  */
	var totalPages = ${news.totalPages}
	var currentPage = ${news.page} +1;
	$(function () {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages: totalPages,
				visiblePages: (totalPages>5)?5:totalPages,
				startPage: currentPage,
				onPageClick: function (event, page) {
					if(currentPage != page){
						$('#page').val(page-1);
					}
				}
			}).on('page', function (event, page) {
				let path = location.pathname;
				page-=1;
                window.location.href = path+'?page='+page;
            });
		});
	
</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <title></title> -->
</head>
<body>
	<div id="layoutAuthentication" class="bg-primary">
	    <div id="layoutAuthentication_content">
	        <main>
	            <div class="container">
	                <div class="row justify-content-center">
	                    <div class="col-lg-5">
	                        <div class="card shadow-lg border-0 rounded-lg mt-5">
	                        	<c:if test="${param.incorrectAccount != null}">
		                        	<div class="card bg-danger text-white mb-4">
	                                	<div class="card-body">User name or password is incorrect</div>
	                            	</div>
	                        	</c:if>
	                        	<c:if test="${param.sessionTimeOut != null}">
		                        	<div class="card bg-warning text-white mb-4">
	                                	<div class="card-body">Account is expired!</div>
	                            	</div>
	                        	</c:if>
	                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
	                            <div class="card-body">
	                                <form action ="j_spring_security_check" id="formSubmit" method="post">
	                                    <div class="form-floating mb-3">
	                                        <input class="form-control" id="inputEmail" type="text" placeholder="name@example.com" name ="j_username"/>
	                                        <label for="inputEmail">Email address</label>
	                                    </div>
	                                    <div class="form-floating mb-3">
	                                        <input class="form-control" id="inputPassword" type="password" placeholder="Password" name ="j_password" />
	                                        <label for="inputPassword">Password</label>
	                                    </div>
	                                    <div class="form-check mb-3">
	                                        <input class="form-check-input" id="inputRememberPassword" type="checkbox" value="" />
	                                        <label class="form-check-label" for="inputRememberPassword">Remember Password</label>
	                                    </div>
	                                    <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
	                                        <a class="small" href="password.html">Forgot Password?</a>
	                                        <button class="btn btn-primary"  type="submit">Login</button>
	                                    </div>
	                                </form>
	                            </div>
	                            <div class="card-footer text-center py-3">
	                                <div class="small"><a href="register.html">Need an account? Sign up!</a></div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </main>
	    </div>
	</div>
</body>
</html>
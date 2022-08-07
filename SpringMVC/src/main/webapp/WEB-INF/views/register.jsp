<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<div id="layoutAuthentication" class="bg-primary">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                            <div class="card-body">
                                <form:form action="/register"  method="post" modelAttribute="user" >
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <form:input cssClass="form-control" path="firstName" id="inputFirstName" type="text" placeholder="Enter your first name"/>
                                                <form:errors path="firstName" cssClass="form-control tex-danger" element="div"/>
                                                <label for="inputFirstName">First name</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <form:input cssClass="form-control" path="lastName" id="inputLastName" type="text" placeholder="Enter your last name"/>
                                                <form:errors path="lastName" cssClass="form-control tex-danger" element="div"/>
                                                <label for="inputLastName">Last name</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <form:input cssClass="form-control" path="userName" id="inputEmail" type="text" placeholder="User name"/>
                                        <form:errors path="userName" cssClass="form-control tex-danger" element="div"/>
                                        <label for="inputEmail">User name</label>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <form:input cssClass="form-control" path="password" id="inputPassword" type="password" placeholder="Create a password"/>
                                                <form:errors path="password" cssClass="form-control tex-danger" element="div"/>
                                                <label for="inputPassword">Password</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <form:input cssClass="form-control" path="confirmPassword" id="inputPasswordConfirm" type="password" placeholder="Confirm password"/>
                                                <form:errors path="confirmPassword" cssClass="form-control tex-danger" element="div" />
                                                <label for="inputPasswordConfirm">Confirm Password</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mt-4 mb-0">
                                        <div class="d-grid"><button class="btn btn-primary btn-block" type="submit">Create Account</button></div>
                                    </div>
                                </form:form>
                            </div>
                            <div class="card-footer text-center py-3">
                                <div class="small"><a href='<c:url value ="/login"/>'>Have an account? Go to login</a></div>
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
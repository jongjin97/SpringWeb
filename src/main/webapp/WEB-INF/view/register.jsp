<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="./assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="./css/styles.css" rel="stylesheet" />
    </head>
<body>
		<jsp:include page="../module/navigation.jsp"></jsp:include>
        
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                                    <div class="card-body">
                                        <form:form action = "register" method="post" modelAttribute="registerRequest">
                                            <div class="form-floating mb-3">
                                                <form:input class="form-control" type="text" path="name" placeholder="Enter your first name"/>
                                                        <label for="inputFirstName">name</label>
                                                        <form:errors path="name"></form:errors>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <form:input class="form-control" id="email" type="email" placeholder="name@example.com" path="email"/>
                                                <label for="inputEmail">Email address</label>
                                                <form:errors path="email"></form:errors>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <form:input class="form-control" id="password" type="password" placeholder="Create a password" path="password"/>
                                                        <label for="inputPassword">Password</label>
                                                        <form:errors path="password"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <form:input class="form-control" id="confirm" type="password" placeholder="Confirm password" path="confirm"/>
                                                        <label for="inputPasswordConfirm">Confirm Password</label>
                                                        <form:errors path="confirm"></form:errors>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><input type = "submit" class="btn btn-primary btn-block" value="Create Account"/></div>
                                            </div>
                                        </form:form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="login.html">Have an account? Go to login</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>
        <!-- Footer-->
        <jsp:include page="../module/footer.jsp"></jsp:include>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
</body>
</html>
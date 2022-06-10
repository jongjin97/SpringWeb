<!--
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
-->
<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    </head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="/main">Start Bootstrap</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/main">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="/product/ProductView?device=SmartPhone">Smart Phone</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="/product/ProductView?device=Tablet">Tablet</a></li>
                                <li><a class="dropdown-item" href="/product/ProductView?device=Watch">Watch</a></li>
                                <li><a class="dropdown-item" href="/product/ProductView?device=Buz">Buz</a></li>
                                <li><a class="dropdown-item" href="/product/ProductView?device=GalaxyBook">Galaxy Book</a></li>
                            </ul>
                        </li>
                        
                        <!-- manager -->
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
	                        <li class="nav-item dropdown">
	                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Manage</a>
	                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	                                <li><a class="dropdown-item" href="/manage/addProduct">Add Products</a></li>
	                                <li><hr class="dropdown-divider" /></li>
	                                <li><a class="dropdown-item" href="/manage/manageProduct">Manage Products</a></li>
	                                <li><a class="dropdown-item" href="/manage/manageUser">Manage User</a></li>
	                            </ul>
	                        </li>
                        </sec:authorize>

                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/chat" id="go-chat">Chat</a></li>
                    </ul>
                    <sec:authorize access="isAuthenticated()">
                   		<a class="navbar-brand"><sec:authentication property="principal.username"/>님</a>
                        <input type="hidden" id="login-user" value= <sec:authentication property="principal.username" /> />
                   		<form class="d-flex">
	                        <button class="btn btn-outline-dark" type="button" onclick="location.href='/user/logout'">
	                            Logout
	                        </button>
                   		 </form>
                    </sec:authorize>

                  	
                    <sec:authorize access="isAnonymous()">
	                  	<form class="d-flex">
	                        <button class="btn btn-outline-dark" type="button" onclick="location.href='/user/login'">
	                            Login
	                        </button>
	                    </form>
	                    <form class="d-flex">
	                        <button class="btn btn-outline-dark" type="button" onclick="location.href='/user/register'">
	                            Regist
	                        </button>
	                    </form>
                    </sec:authorize>
                    <form class="d-flex">
                        <button class="btn btn-outline-dark" type="button" onclick="location.href='/myCart/list'">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">${cart.size() }</span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        
</body>


</html>
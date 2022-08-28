<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<div style="width:100%;  background-color: #F7F7F7;">
	        <div class="container">
	        	<form:form action="/cart/addCart" method="post" target="iframe1" modelAttribute="product">
		            <div class="row">
		                <!-- Blog entries-->
		                <div class="col-lg-8">
		                    <!-- Featured blog post-->
		                    <div class="card mb-4">
								<div style="width:50%" style="height: 50%">
										<a href="#!"><img class="card-img-top" src="${product.file_path }" alt="..." /></a>
								</div>
		                    </div>
		                </div>
		                <!-- Side widgets-->
		                <div class="col-lg-4">
		                    <!-- Search widget-->
		                    <div class="card mb-4">
		                        <div class="card-body">
		                        	<div class="input-group">
		                            </div>
		                            <div class="input-group">
		                                <h1>${product.name }</h1>
										<form:input path="id" type="hidden" value="${product.id}"/>
										<form:input path="category" type="hidden" value="${product.category}"/>
		                                <form:input path="name" type="hidden" value="${product.name}"/>
										<form:input path="price" type="hidden" value="${product.price}"/>
		                            </div>
		                            <div class="form-floating mb-3">
		                                <p>판매가  <fmt:formatNumber value="${product.price }" pattern="#,###,###"></fmt:formatNumber>원</p>
		                            </div>
									<div class="form-floating mb-3">
										<p>재고 ${product.qty}</p>
									</div>
		                            <div class="form-floating mb-3">
<											<form:input path="qty" class="form-control" id="qty" type="number" min="0" max="${product.qty}" value="0"/>
<%--										<input class="form-control" id="qty" type="number" min="0" max="${product.qty}" value="0"/>--%>
										<label for="inputFirstName">수량</label>
									</div>
		                            <hr>
		                            <div class="form-floating mb-3">
		                                <h1>판매가</h1><fmt:formatNumber value="${product.price }" pattern="#,###,###"></fmt:formatNumber>원

		                            </div>
		                            <hr>
		                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
		                                <input class="btn btn-primary" type="submit" value="장바구니" onclick="location.reload();"></a>
		                                <c:if test="${!empty authInfo}">
		                                	<a><input class="btn btn-primary" type="submit" value="바로구매" ></a>
		                                </c:if>
		                                <iframe id="iframe1" name="iframe1" style="display:none"></iframe>
		                                <c:if test="${empty authInfo}">
		                                	<a><input class="btn btn-primary" type="submit" value="바로구매" ></a>
		                                </c:if>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		            </div>
	            </form:form>
	            <div class="row">
	                <!-- Blog entries-->
	                <div class="col-lg-16">
	                    <!-- Featured blog post-->
	                    <div class="card mb-4" style="overflow:hidden; display: flex;">
	                    	<div class="imageContainer">
	                        	${product.content }
	                        </div>
	                    </div>
	                </div>
	            </div>
	            
	        </div>
        </div>
        
        
        <!-- Footer-->
        <jsp:include page="../module/footer.jsp"></jsp:include>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
</body>
</html>
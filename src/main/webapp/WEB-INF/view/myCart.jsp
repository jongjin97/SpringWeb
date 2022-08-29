<%@ page import="shop.entity.ProductDomain" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Shop Homepage - Start Bootstrap Template</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="./assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />

<!-- Core theme CSS (includes Bootstrap)-->
<link href="./css/styles2.css" rel="stylesheet" />
<link href="./css/styles.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="../module/navigation.jsp"></jsp:include>

	<div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div>
                    	<div>
                    		<h1>My Cart</h1>
                    		<br>
                    	</div>
	                    <div>
	                    	<c:forEach var="cart" items="${cart }">
		                    	<div style="width:70%; float:left;">
		                    		<div style="width:10%; float:left;">
		                    			<form action="/cart/${cart.id }" method="post" onclick="window.location.reload();">
			                    		<input type="submit" value="삭제" >
			                    		<iframe id="iframe1" name="iframe1" style="display:none"></iframe> 
			                    		</form>
		                    		</div>
		                    		<div style="width:20%; float:left;"><img class="card-img-top" src="<c:out value="${cart.filePath }"/>" alt="..." /></div>
		                    		<div style="width:30%; float:left;">
		                    			<p>${cart.productName }</p>
		                    		</div>
		                    		<div style="width:20%; float:left;">
		                    			<tr style="text-align:center;">
										    <td>수량</td>
										    <td class="bseq_ea"></td>
										    <hr>
										</tr>

		                    		</div>
		                    		<div style="width:20%; float:left;">
		                    			<fmt:formatNumber value="${cart.product_Price }" pattern="#,###,###"></fmt:formatNumber>원
		                    		</div>
		                    	</div>
	                    	</c:forEach>
							<form action="/order/product" method="post">
								<div style="width:30%; float:right;">
									<div>
										<c:if test="${sum > 0}">
										<p>주문 금액</p>
										<br/>
										<fmt:formatNumber value="${sum}" pattern="#,###,###"></fmt:formatNumber>원
											<br/>
										<input type="submit" value="주문하기">
										</c:if>
									</div>
								</div>
							</form>
                    	</div>
                    </div>
                </main>
            </div>
        </div>
	

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
</body>

<script type="text/javascript">
</script>
</html>
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
		<div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                    	<div class="row justify-content-center">
	                    	<div>
	                    		<h1>Manage Product</h1>
	                    		<br>
	                    	</div>
		                    <div>
		                    	<c:forEach var="list" items="${list }">
			                    	<div style="width:100%; float:left;">
			                    		
			                    		<div style="width:20%; float:left;"><img class="card-img-top" src="<c:out value="${list.file_path }"/>" alt="..." /></div>
			                    		<div style="width:20%; float:left;">
			                    			<p>${list.name }</p>
			                    			<p>모델명</p>
			                    			<p>색상/메모리</p>
			                    		</div>
			                    		<div style="width:20%; float:left;">
			                    			<fmt:formatNumber value="${list.price }" pattern="#,###,###"></fmt:formatNumber>원
			                    		</div>
			                    		<div style="width:20%; float:left;">
			                    			<button class="btn btn-primary" value="수정" onclick="location.href='modifyProduct?name=${list.name}'">수정</button>
			                    		</div>
			                    		<div style="width:20%; float:left;">
			                    			<button class="btn btn-primary" value="삭제" onclick="location.href='deleteProduct?name=${list.name}'">삭제</button>
			                    		</div>
			                    	</div>
		                    	</c:forEach>
	                    	</div>
                    	</div>
                    </div>
                </main>
            </div>
        </div>
        
        
        <!-- Footer-->
        <%-- <jsp:include page="../module/footer.jsp"></jsp:include> --%>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
</body>
</html>
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
		                    			<form action="delete?name=${cart.name }" method="post" target="iframe1" onclick="location.reload();">
			                    		<input type="submit" value="삭제" >
			                    		<iframe id="iframe1" name="iframe1" style="display:none"></iframe> 
			                    		</form>
		                    		</div>
		                    		<div style="width:20%; float:left;"><img class="card-img-top" src="<c:out value="${cart.file_path }"/>" alt="..." /></div>
		                    		<div style="width:30%; float:left;">
		                    			<p>${cart.name }</p>
		                    			<p>모델명</p>
		                    			
		                    			<p>색상/메모리</p>
		                    		</div>
		                    		<div style="width:20%; float:left;">
		                    			<tr style="text-align:center;">
										    <td>수량</td>
										    <td class="bseq_ea">1</td>
										    <hr>
										    <td>
										        <button type ="button" onclick="fnCalCount('p',this);">+</button>
										        <input type="text" name="pop_out" value="0" readonly="readonly" style="text-align:center;"/>
										        <button type="button" onclick="fnCalCount('m', this);">-</button>
										    </td>
										</tr>

		                    		</div>
		                    		<div style="width:20%; float:left;">
		                    			<fmt:formatNumber value="${cart.price }" pattern="#,###,###"></fmt:formatNumber>원
		                    		</div>
		                    	</div>
	                    	</c:forEach>
	                    	<div style="width:30%; float:right;">
	                    		<div>
	                    			<p>주문 금액</p>
	                    			<hr>
	                    			<p>결제 예정 금액</p>
	                    			<input type="button" value="주문하기">
	                    		</div>
	                    	</div>
                    	</div>
                    </div>
                </main>
            </div>
        </div>
	
	<jsp:include page="../module/footer.jsp"></jsp:include>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
</body>
<script type="text/javascript">
function fnCalCount(type, ths){
    var $input = $(ths).find("input[name='pop_out']");
    var tCount = Number($input.val());
    var tEqCount = Number($(ths).find("td.bseq_ea").html());
    
    if(type=='p'){
        if(tCount < tEqCount) $input.val(Number(tCount)+1);
        
    }else{
        if(tCount >0) $input.val(Number(tCount)-1);    
        }
}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

<script type="text/javascript" src="./smarteditor2/js/HuskyEZCreator.js" charset="utf-8"></script>

</head>
<body>
	<jsp:include page="../module/navigation.jsp"></jsp:include>
	
	<div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-12">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Add Product</h3></div>
                                    <div class="card-body">
                                        <form:form action = "register" method="post">
                                            <div class="form-floating mb-3">
                                                <input class="form-control" type="text" path="name"/>
                                                        <label for="inputFirstName">Name</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" type="number" path="price"/>
                                                <label for="inputEmail">Price</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <select class="form-control" name="device">
													  <option> Smart Phone </option>
													  <option> Tablet </option>
													  <option> Watch </option>
                                                </select>
                                                <label for="inputEmail">Category</label>
                                            </div>
                                             <div class="form-floating mb-3">
                                                <textarea name="ir1" id="ir1" rows="10" cols="100" style="width: 100%; height: 500px;"></textarea>

                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><input type = "submit" class="btn btn-primary btn-block" value="Add Product"/></div>
                                            </div>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>

	<jsp:include page="../module/footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
</body>

<script>
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef: oEditors,
			elPlaceHolder: "ir1",
			sSkinURI: "./smarteditor2/SmartEditor2Skin.html",
			fCreator: "createSEditor2"
		});
	</script>
</html>
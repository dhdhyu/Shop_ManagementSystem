<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="sidebar">
		<!-- Start .sidebar-inner -->
		<div class="sidebar-inner">
			<!-- Start #sideNav -->
			<ul id="sideNav" class="nav nav-pills nav-stacked">

				<li><a href="index">首页 <i class="im-screen"></i></a></li>
				<li><a href="showProductUI">商品一览 <i class="st-chart"></i></a></li>
				<li><a href="#"> 商品操作 <i class="im-paragraph-justify"></i></a>
					<ul class="nav sub">
						<li><a href="addProductUI"><i class="ec-pencil2"></i> 商品添加</a></li>
						<li><a href="searchProductUI"><i
								class="im-checkbox-checked"></i> 商品查询</a></li>

					</ul>
				</li>
				<li><a href="#"> 商品分类操作 <i class="im-paragraph-justify"></i></a>
					<ul class="nav sub">
						<li><a href="addCategory.jsp"><i class="ec-pencil2"></i> 添加分类</a></li>
					</ul>
				</li>
			</ul>
			<!-- End #sideNav -->
			<!-- Start .sidebar-panel -->

			<!-- End .sidebar-panel -->
		</div>
		<!-- End .sidebar-inner -->
	</div>



</body>
</html>
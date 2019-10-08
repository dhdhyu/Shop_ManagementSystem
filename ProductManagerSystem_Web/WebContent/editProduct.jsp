<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>商品管理系统-修改</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="author" content="SuggeElson" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="application-name" content="sprFlat admin template" />
<link href="assets/css/icons.css" rel="stylesheet" />
<link href="assets/css/sprflat-theme/jquery.ui.all.css" rel="stylesheet" />
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/plugins.css" rel="stylesheet" />
<link href="assets/css/main.css" rel="stylesheet" />
<link href="assets/css/custom.css" rel="stylesheet" />
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/img/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/img/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/img/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/img/ico/apple-touch-icon-57-precomposed.png">
<link rel="icon" href="assets/img/ico/favicon.ico" type="image/png">
<meta name="msapplication-TileColor" content="#3399cc" />
</head>
<body>
	<div id="header">
		<div class="container-fluid">
			<jsp:include page="/common/navbar.jsp"></jsp:include>
		</div>
	</div>
	<jsp:include page="/common/sidebar.jsp"></jsp:include>
	<div id="content">
		<div class="content-wrapper">
			<div class="row">
				<div class="col-lg-12 heading">
					<h1 class="page-header">
						<i class="im-paragraph-justify"></i> 修改商品
					</h1>
				</div>
			</div>
			<div class="outlet">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default toggle">
							<div class="panel-heading">
								<h3 class="panel-title">修改商品信息</h3>
							</div>
							<div class="panel-body">
								<form class="form-horizontal group-border hover-stripped"
									role="form" action='editProduct?currentCid=${currentCid }&page=${page}' method='post'>
									<div class="form-group">
										<label class="col-lg-2 col-md-2 col-sm-12 control-label">商品ID</label>
										<div class="col-lg-10 col-md-10">
											<input type="text" class="form-control" readonly="readonly"
												placeholder="系统自动生成" value='${p.p_id }' name='p_id'>
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 col-md-2 col-sm-12 control-label">商品名称</label>
										<div class="col-lg-10 col-md-10">
											<input type="text" class="form-control"
												placeholder="请输入商品名称" value='${p.p_name }' name='p_name'>
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 col-md-2 col-sm-12 control-label">商品价格</label>
										<div class="col-lg-10 col-md-10">
											<input type="number" step="0.01" class="form-control"
												placeholder="请输入商品价格" value='${p.p_price }' name='p_price'>
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 col-md-2 col-sm-12 control-label">商品分类</label>
										<div class="col-lg-10 col-md-10">
											<select class="form-control" name='c_id'>
											    <c:forEach var='cate' items='${ cates}'>
											<c:if test="${cate.c_id==p.p_category_id }">
												<option value='${cate.c_id }' selected>${cate.c_name }</option>
											</c:if>
											<c:if test="${cate.c_id!=p.p_category_id }">
												<option value='${cate.c_id }'>${cate.c_name }</option>
											</c:if>
										</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 col-md-2 col-sm-12 control-label"></label>
										<div class="col-lg-5 col-md-5 ">
											<input type="submit" class="form-control btn btn-success"
												value='修改'>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<script src="assets/plugins/core/pace/pace.min.js"></script>
	<script src="assets/js/jquery-1.8.3.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="assets/js/libs/jquery-2.1.1.min.js">\x3C/script>')
	</script>
	<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="assets/js/libs/jquery-ui-1.10.4.min.js">\x3C/script>')
	</script>
	<script src="assets/js/bootstrap/bootstrap.js"></script>
	<script src="assets/js/jRespond.min.js"></script>
	<script src="assets/plugins/core/slimscroll/jquery.slimscroll.min.js"></script>
	<script
		src="assets/plugins/core/slimscroll/jquery.slimscroll.horizontal.min.js"></script>
	<script src="assets/plugins/forms/autosize/jquery.autosize.js"></script>
	<script src="assets/plugins/core/quicksearch/jquery.quicksearch.js"></script>
	<script src="assets/plugins/ui/bootbox/bootbox.js"></script>
	<script src="assets/plugins/core/moment/moment.min.js"></script>
	<script src="assets/plugins/charts/sparklines/jquery.sparkline.js"></script>
	<script src="assets/plugins/charts/pie-chart/jquery.easy-pie-chart.js"></script>
	<script src="assets/plugins/forms/icheck/jquery.icheck.js"></script>
	<script src="assets/plugins/forms/tags/jquery.tagsinput.min.js"></script>
	<script src="assets/plugins/forms/tinymce/tinymce.min.js"></script>
	<script src="assets/plugins/forms/switch/jquery.onoff.min.js"></script>
	<script src="assets/plugins/forms/maxlength/bootstrap-maxlength.js"></script>
	<script
		src="assets/plugins/forms/bootstrap-filestyle/bootstrap-filestyle.js"></script>
	<script src="assets/plugins/forms/color-picker/spectrum.js"></script>
	<script src="assets/plugins/forms/daterangepicker/daterangepicker.js"></script>
	<script
		src="assets/plugins/forms/datetimepicker/bootstrap-datetimepicker.min.js"></script>
	<script src="assets/plugins/forms/globalize/globalize.js"></script>
	<script src="assets/plugins/forms/maskedinput/jquery.maskedinput.js"></script>
	<script src="assets/plugins/forms/select2/select2.js"></script>
	<script
		src="assets/plugins/forms/dual-list-box/jquery.bootstrap-duallistbox.js"></script>
	<script src="assets/plugins/forms/password/jquery-passy.js"></script>
	<script src="assets/plugins/forms/checkall/jquery.checkAll.js"></script>
	<script src="assets/plugins/misc/highlight/highlight.pack.js"></script>
	<script src="assets/plugins/misc/countTo/jquery.countTo.js"></script>
	<script src="assets/js/jquery.sprFlat.js"></script>
	<script src="assets/js/app.js"></script>
	<script src="assets/js/pages/forms.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="cn">
<head>
<meta charset="utf-8">
<title>商品管理系统-首页</title>
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
						<i class="im-screen"></i> 首页
					</h1>
				</div>
			</div>
			<div class="outlet">
				<div class="row">
					<div class="col-lg-6 col-md-6 sortable-layout">
						<div class="panel panel-brown panelMove">
							<div class="panel-heading">
								<h4 class="panel-title">
									<i class="st-camera"></i> 图片轮播
								</h4>
								<div class="pull-right mt10">
									<a href="#" class="color-grayspr">@Truuess</a>
								</div>
							</div>
							<div class="panel-body p0">
								<div class="instagram-widget">
									<div class="instagram-widget-header gray-bg">
										<div class="col-lg-4 col-md-4 col-xs-4 text-center">
											<a href="#">
												<p class="instagram-widget-text">Followers</p> <strong
												class="instagram-widget-number">1256</strong>
											</a>
										</div>
										<div class="col-lg-4 col-md-4 col-xs-4 text-center">
											<a href="#">
												<p class="instagram-widget-text">Following</p> <strong
												class="instagram-widget-number">345</strong>
											</a>
										</div>
										<div class="col-lg-4 col-md-4 col-xs-4 text-center">
											<a href="#">
												<p class="instagram-widget-text">Shots</p> <strong
												class="instagram-widget-number">176</strong>
											</a>
										</div>
									</div>
									<div class="instagram-widget-image">
										<div id="instagram-widget" class="carousel slide">
											<!-- Indicators -->
											<ol class="carousel-indicators dotstyle">
												<li data-target="#instagram-widget" data-slide-to="0"
													class="active"><a href="#">Image 1</a></li>
												<li data-target="#instagram-widget" data-slide-to="1"><a
													href="#">Image 2</a></li>
												<li data-target="#instagram-widget" data-slide-to="2"><a
													href="#">Image 3</a></li>
											</ol>
											<div class="carousel-inner">
												<figure class="item active">
													<img class="img-responsive"
														src="assets/img/instagram/instagram.jpg" alt="image">
												</figure>
												<figure class="item">
													<img class="img-responsive"
														src="assets/img/instagram/instagram2.jpg" alt="image">
												</figure>
												<figure class="item">
													<img class="img-responsive"
														src="assets/img/instagram/instagram3.jpg" alt="image">
												</figure>
											</div>
										</div>
									</div>
									<div class="instagram-widget-footer">
										<div class="col-lg-6 col-md-6 col-xs-6 text-center">
											<p>
												<a href="#"> <i class="ec-chat mr5"></i> <strong
													class="instagram-widget-number">17</strong>
												</a>
											</p>
										</div>
										<div class="col-lg-6 col-md-6 col-xs-6 text-center">
											<p>
												<a href="#"> <i class="ec-heart mr5"></i> <strong
													class="instagram-widget-number">27</strong>
												</a>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 sortable-layout">
						<div class="weather-widget panel panel-primary plain toggle panelMove panelClose panelRefresh">
							<div class="panel-heading">
								<h4 class="panel-title">实时天气</h4>
							</div>
							<div class="panel-body blue-bg text-center">
								<canvas id="weather-now" width="128" height="128"></canvas>
								<p class="weather-location">
									<strong>23&deg;C</strong> 小雨
								</p>
							</div>
							<div class="panel-footer white-bg text-center">
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
									<p class="weather-day">周一</p>
									<canvas id="forecast-now" width="64" height="64"></canvas>
									<p class="weather-degree">23&deg;C</p>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
									<p class="weather-day">周二</p>
									<canvas id="forecast-day1" width="64" height="64"></canvas>
									<p class="weather-degree">17&deg;C</p>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
									<p class="weather-day">周三</p>
									<canvas id="forecast-day2" width="64" height="64"></canvas>
									<p class="weather-degree">15&deg;C</p>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
									<p class="weather-day">周四</p>
									<canvas id="forecast-day3" width="64" height="64"></canvas>
									<p class="weather-degree">18&deg;C</p>
								</div>
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
	<script src="assets/js/jquery-ui.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="assets/js/libs/jquery-ui-1.10.4.min.js">\x3C/script>')
	</script>
	<script src="assets/js/bootstrap/bootstrap.js"></script>
	<script src="assets/js/jRespond.min.js"></script>
	<script src="assets/plugins/core/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/plugins/core/slimscroll/jquery.slimscroll.horizontal.min.js"></script>
	<script src="assets/plugins/forms/autosize/jquery.autosize.js"></script>
	<script src="assets/plugins/core/quicksearch/jquery.quicksearch.js"></script>
	<script src="assets/plugins/ui/bootbox/bootbox.js"></script>
	<script src="assets/plugins/charts/flot/jquery.flot.js"></script>
	<script src="assets/plugins/charts/flot/jquery.flot.pie.js"></script>
	<script src="assets/plugins/charts/flot/jquery.flot.resize.js"></script>
	<script src="assets/plugins/charts/flot/jquery.flot.time.js"></script>
	<script src="assets/plugins/charts/flot/jquery.flot.growraf.js"></script>
	<script src="assets/plugins/charts/flot/jquery.flot.categories.js"></script>
	<script src="assets/plugins/charts/flot/jquery.flot.stack.js"></script>
	<script src="assets/plugins/charts/flot/jquery.flot.tooltip.min.js"></script>
	<script src="assets/plugins/charts/flot/date.js"></script>
	<script src="assets/plugins/charts/sparklines/jquery.sparkline.js"></script>
	<script src="assets/plugins/charts/pie-chart/jquery.easy-pie-chart.js"></script>
	<script src="assets/plugins/forms/icheck/jquery.icheck.js"></script>
	<script src="assets/plugins/forms/tags/jquery.tagsinput.min.js"></script>
	<script src="assets/plugins/forms/tinymce/tinymce.min.js"></script>
	<script src="assets/plugins/misc/highlight/highlight.pack.js"></script>
	<script src="assets/plugins/misc/countTo/jquery.countTo.js"></script>
	<script src="assets/plugins/ui/weather/skyicons.js"></script>
	<script src="assets/plugins/ui/notify/jquery.gritter.js"></script>
	<script src="assets/plugins/ui/calendar/fullcalendar.js"></script>
	<script src="assets/js/jquery.sprFlat.js"></script>
	<script src="assets/js/app.js"></script>
	<script src="assets/js/pages/dashboard.js"></script>
</body>
</html>
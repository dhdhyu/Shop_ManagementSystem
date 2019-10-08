<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="cn">
<head>
<meta charset="utf-8">
<title>商品管理系统-搜索</title>
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
						<i class="im-table2"></i> 商品搜索
					</h1>
				</div>
			</div>
			<div class="outlet">
				<div class="row">
					<div class="col-lg-12">
						<div
							class="panel panel-default plain toggle panelClose panelRefresh">
							<div class="panel-heading white-bg">
								<h4 class="panel-title"></h4>
							</div>
							<div class="panel-body-">
								<form action="searchProduct" method='post'>
									<div class="row">
										<div class="col-xs-1" style='padding-left: 25px'>
											<span><strong>商品分类</strong></span> <select id='category'
												class='form-control input-small' name="cateid">
												<c:forEach var='cate' items='${cates }'>
													<c:if test="${currentcid==cate.c_id }">
														<option value='${cate.c_id }' selected>${cate.c_name }</option>
													</c:if>
													<c:if test="${currentcid!=cate.c_id }">
														<option value='${cate.c_id }'>${cate.c_name }</option>
													</c:if>
												</c:forEach>
											</select>
										</div>
									</div>
									<p></p>
									<div class="row" style="line-height: 30px">
										<div class="col-xs-4" style='padding-left: 25px'>
											<input type="text" placeholder='请输入要搜索的关键字' value="${searchName }" name="searchName"/> <input
												type="submit" value='搜索' class='btn btn-success' />
										</div>
									</div>
								</form>
								<c:if test="${empty error }">
									<table class="table display" id="datatable">
										<thead>
											<tr>
												<th>商品ID</th>
												<th>商品名称</th>
												<th>商品价格</th>
												<th>上架时间</th>
												<th>商品信息操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var='p' items='${pageBean.list}'>
												<tr class="odd gradeX">
													<td>${p.p_id }</td>
													<td>${p.p_name }</td>
													<td>${p.p_price }</td>
													<td>${p.p_addtime }</td>
													<td><a href='editProductUI?p_id=${p.p_id }'
														class='btn btn-info'>修改商品</a> <a
														href='deleteProduct?p_id=${p.p_id }'
														class='btn btn-danger'>删除商品</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</c:if>
								<c:if test="${not empty error }">
									<h1>${ error }</h1>
								</c:if>
							</div>
							<div class="row">
								<div class="col-xs-12 text-right" style="overflow: hidden">
									<span style="float: right; line-height: 76px">
										&nbsp;&nbsp; <span>总共:${pageBean.totalPage}页</span>&nbsp;&nbsp;到第<input
										style="width: 50px; line-height: 30px" type="number"
										value="${pageBean.currentPage }" step="1" id="inputNumber">页
										,
										<button style="height: 30px; line-height: 30px"
											onclick="changePage()">确定</button>
									</span>
									<nav aria-label="Page navigation" style="float: right">
										<ul class="pagination">
											<!-- 在第一页的情况 -->
											<c:if test="${pageBean.currentPage==1 }">
												<li class="disabled"><a href="javascript:void(0)"
													aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
												</a></li>
											</c:if>
											<!-- 不在第一页的情况 -->
											<c:if test="${pageBean.currentPage!=1 }">
												<li><a
													href="${pageContext.request.contextPath }/searchProduct?cateid=${currentcid}&searchName=${searchName }&currentPage=${pageBean.currentPage-1}"
													aria-label="Previous"> <span aria-hidden="true">&laquo;
													</span>
												</a></li>
											</c:if>
											<!-- 中间的页面 -->
											<c:forEach var="page" items="${pageBean.pageValue }">
												<c:if test="${pageBean.currentPage==page }">
													<li class="active"><a href="javascipt:void(0)">${page }</a>
													</li>
												</c:if>
												<c:if test="${page == -1 }">
													<li><a href="javascript:return false" id="dot"
														style="cursor: default; opacity: 0.6;">...</a></li>
												</c:if>
												<c:if test="${pageBean.currentPage!=page && page!=-1 }">
													<li><a
														href="${pageContext.request.contextPath }/searchProduct?cateid=${currentcid}&searchName=${searchName }&currentPage=${page}">${page }</a>
													</li>
												</c:if>
											</c:forEach>
											<!-- 最后一页的逻辑 -->
											<c:if test="${pageBean.currentPage==pageBean.totalPage }">
												<li class="disabled"><a href="javascript:void(0)"
													aria-label="Next"> <span aria-hidden="true">&raquo;</span>
												</a></li>
											</c:if>

											<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
												<li><a
													href="${pageContext.request.contextPath }/searchProduct?cateid=${currentcid}&searchName=${searchName }&currentPage=${pageBean.currentPage+1}"
													aria-label="Next"> <span aria-hidden="true">&raquo;</span>
												</a></li>
											</c:if>
										</ul>
									</nav>
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
		$("#inputNumber").bind("input propertychange", function(event) {
			console.log($("#inputNumber").val())
		});
		function changePage() {
			//console.log($("#inputNumber").val());

			location.href = "${pageContext.request.contextPath }/searchProductUI?cateid=${currentcid}&searchName=${searchName }&currentPage="
					+ $("#inputNumber").val();
		}
	</script>
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
	<script src="assets/plugins/tables/datatables/jquery.dataTables.min.js"></script>
	<script src="assets/plugins/tables/datatables/jquery.dataTablesBS3.js"></script>
	<script
		src="assets/plugins/tables/datatables/tabletools/ZeroClipboard.js"></script>
	<script src="assets/plugins/tables/datatables/tabletools/TableTools.js"></script>
	<script src="assets/plugins/misc/highlight/highlight.pack.js"></script>
	<script src="assets/plugins/misc/countTo/jquery.countTo.js"></script>
	<script src="assets/js/jquery.sprFlat.js"></script>
	<script src="assets/js/app.js"></script>
	<script src="assets/js/pages/data-tables.js"></script>
</body>
</html>
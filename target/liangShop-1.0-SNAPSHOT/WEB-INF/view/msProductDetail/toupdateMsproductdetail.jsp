<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>亮亮商城</title>
	<%@include file="../include/css.jsp"%>
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

	<!-- Main Header -->
	<%@include file="../include/navhead.jsp"%>
	<!-- Left side column. contains the logo and sidebar -->
	<%@include file="../include/sider.jsp"%>

	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				亮亮商城
				<small>商品管理</small>
			</h1>

		</section>

		<!-- Main content -->
		<section class="content container-fluid">

			<!--------------------------
              | Your Page Content Here |
              -------------------------->



			<form action="updateMsproductdetail" method="post">

			</form>
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">添加商品</h3>
				</div>
				<!-- /.box-header -->
				<!-- form start -->
				<form role="form"   action="applyMsProduct" method="post">
					<div class="box-body">
						商品产地:<input name="productPalce" value="${msProductDetail.productPalce }"></br>
						商品名称:<input name="productName" value="${msProductDetail.productName }"></br>
						商品品牌:<input name="brandName" value="${msProductDetail.brandName }"></br>
						商品重量:<input name="productWeight" value="${msProductDetail.productWeight }"></br>
						规格和包装:<input name="specification" value="${msProductDetail.specification }"></br>
						商品详情图片地址:<input name="imageSrc" value="${msProductDetail.imageSrc }"></br>


					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<button type="submit" class="btn btn-primary" onclick="submit(this)">提交</button>
					</div>
				</form>

		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->

	<!-- Main Footer -->
	<%@include file="../include/footer.jsp"%>

</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->
<%@include file="../include/js.jsp"%>


<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>














</div>
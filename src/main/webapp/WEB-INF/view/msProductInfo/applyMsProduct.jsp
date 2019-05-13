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

			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">添加商品</h3>
				</div>
				<!-- /.box-header -->
				<!-- form start -->
				<form role="form"   action="applyMsProduct" method="post">
					<div class="box-body">



						<div class="form-group">
							<label>商品id：</label>
							<input type="text" class="form-control" name="productId" placeholder="商品id" >
						</div>
						<div class="form-group">
							<label>商品标题：</label>
							<input type="text" class="form-control"  name="productTitle" placeholder="商品标题" >
						</div>
						<div class="form-group">
							<label>商品图片地址：</label>
							<input type="text" class="form-control" name="productPic"  placeholder="商品图片地址" >
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">价格:</label>
							<input type="text" class="form-control" name="miaoshaPrice"  id="exampleInputEmail1" placeholder="价格:">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">原价:</label>
							<input type="email" class="form-control" name="productOgPrice"   id="exampleInputEmail1" placeholder="原价">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">商家id:</label>
							<input type="text" class="form-control"  name="merchant"  id="exampleInputEmail1" placeholder="商家id:">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">开始时间:</label>
							<input type="text" class="form-control"  name="startTimeString"  id="exampleInputEmail1" placeholder="开始时间:">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">结束时间:</label>
							<input type="text" class="form-control"  name="endTimeString"  id="exampleInputEmail1" placeholder="结束时间:">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">数量:</label>
							<input type="text" class="form-control"  name="productCount"  id="exampleInputEmail1" placeholder="数量:">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">库存:</label>
							<input type="text" class="form-control"  name="stockCount"  id="exampleInputEmail1" placeholder="库存:">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">描述:</label>
							<input type="text" class="form-control"  name="description"  id="exampleInputEmail1" placeholder="描述:">
						</div>


					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<button type="submit" class="btn btn-primary" onclick="submit(this)">提交</button>
					</div>
				</form>
			</div>
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

<script type="text/javascript">
    function submit(obj){
        obj.parent.sumbit();
    }
</script>
<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>







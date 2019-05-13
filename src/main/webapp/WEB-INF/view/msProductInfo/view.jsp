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
        Page Header
        <small>Optional description</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <!--------------------------
        | Your Page Content Here |
        -------------------------->
		 <form action="add">
			亮亮商城商品的id: ${msProductInfo.productId }</br>
				亮亮商城商品的标题: ${msProductInfo.productTitle }</br>
				亮亮商城商品的图片地址: ${msProductInfo.productPic }</br>
				亮亮商城商品价格: ${msProductInfo.miaoshaPrice }</br>
				商家的id: ${msProductInfo.merchant }</br>
				商品原价: ${msProductInfo.productOgPrice }</br>
				亮亮商城商品的申请时间: ${msProductInfo.applayDate }</br>
				亮亮商城商品的审核时间: ${msProductInfo.aidotStatus }</br>
				亮亮商城的开始时间: ${msProductInfo.startTime }</br>
				亮亮商城的结束时间: ${msProductInfo.endTime }</br>
				亮亮商城数量: ${msProductInfo.productCount }</br>
				亮亮商城的库存: ${msProductInfo.stockCount }</br>
				亮亮商城的描述: ${msProductInfo.description }</br>
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

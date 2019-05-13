<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
  <title>亮亮商城</title>
 <%@include file="include/css.jsp"%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
 <%@include file="include/navhead.jsp"%>
  <!-- Left side column. contains the logo and sidebar -->
  <%@include file="include/sider.jsp"%>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       亮亮商城
        <small>主页</small>
      </h1>

    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <!--------------------------
        | Your Page Content Here |
        -------------------------->
		<!-- 亮亮商城商品  -->

<div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">亮亮商城商品列表</h3>

              <div class="box-tools">
               <!-- <button  type="button" class="btn btn-block btn-default" onclick="location='toApplyMsProduct'">申请亮亮商城商品</button> -->
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tbody>
                	<tr>
		                   
							<th>商品标题</th>
							<th>图片地址</th>
							<th>价格</th>
							<th>原价</th>
							<th>秒杀开始时间</th>
							<th>秒杀结束时间</th>
							<th>查看</th>
							
                	</tr>
               <c:forEach items="${listMsProduct}" var="item">
                <tr>
	                   
						<th>${item.productTitle }</th>
						<th>${item.productPic }</th>
						<th>${item.miaoshaPrice }</th>
						<th>${item.productOgPrice }</th>
						<th>${item.startTime }</th>
						<th>${item.endTime }</th>
                            <th><span class="label label-success"><a href="viewProductDetail?id=${item.id}">123</a></span>
						</th>
						
                </tr>
                </c:forEach>
              </tbody></table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
      </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <%@include file="include/footer.jsp"%>

</div>
<!-- ./wrapper -->
<!-- REQUIRED JS SCRIPTS -->
 <%@include file="include/js.jsp"%>
<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>

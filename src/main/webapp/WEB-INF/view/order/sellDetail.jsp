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
        <small>商品详情</small>
      </h1>

    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <!--------------------------
        | Your Page Content Here |
        -------------------------->
		<!-- 亮亮商城商品  -->
<form action="${pageContext.request.contextPath }/orderAction/toPayOrder">
		
		<input type="hidden" name="id" value="${msproduct.id}">
<div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">信息</h3>

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
							<th>开始时间</th>
							<th>结束时间</th>
							<th>商品数</th>
							<th>数量</th>
							<th>库存</th>
							
                	</tr>
             
                <tr>
						<th>${msproduct.productTitle }</th>
						<th>${msproduct.productPic }</th>
						<th>${msproduct.miaoshaPrice }</th>
						<th>${msproduct.productOgPrice }</th>
						<th>${msproduct.startTime }</th>
						<th>${msproduct.endTime }</th>
						<th></th>
						<th>${msproduct.productCount }</th>
						<th>${msproduct.stockCount }</th>
                </tr>
             
              </tbody>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">详情</h3>

              <div class="box-tools">
               <!-- <button  type="button" class="btn btn-block btn-default" onclick="location='toApplyMsProduct'">申请亮亮商城商品</button> -->
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tbody>
                	<tr>
						<th>商品产地</th>
						<th>商品名称</th>
						<th>商品品牌</th>
						<th>商品重量</th>
						<th>规格和包装</th>
						<th>商品详情图片地址</th>
                	</tr>
                <tr>
						<td>${msproductDetail.productPalce}</td>
						<td>${msproductDetail.productName}</td>
						<td>${msproductDetail.brandName}</td>
						<td>${msproductDetail.productWeight}</td>
						<td>${msproductDetail.specification}</td>
						<td>${msproductDetail.imageSrc}</td>
                </tr>
              </tbody>
              </table>
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix">
              <div class="input-group input-group-sm" style="width: 250px;">
                  <input type="text" name="num" class="form-control pull-right" id="num" placeholder="输入购买数量">

                  <div class="input-group-btn">
                    <button type="submit" class="btn btn-default"><i class="">立即购买</i></button>
                  </div>

                </div>
            </div>
          </div>
          <!-- /.box -->
        </div>
      </div>
<%-- <input type="button" value="立即购买" onclick="submit(this)"/>--%>
</form>
        <a href="javascript:submit('${msproduct.id}');" class="btn btn-default btn-flat">添加到购物车</a>
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
<script src="${pageContext.request.contextPath }/static/plugins/layer/layer.js"></script>
<script type="text/javascript">
function submit(productId){

    var num = $("#num").val();
    $.ajax({
        url : '/cart/addProductToCard',
        type : 'post',
        async: false,//使用同步的方式,true为异步方式
        data : {'productId':productId,'num':num},//这里使用json对象
        dataType : "json",
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',//防止乱码
        success : function(data){
            if (data.success){
                // window.location.reload();
                layer.msg('添加成功', {icon: 1});
                /*layer.open({
                    title:"删除成功",
                    time:5000,
                    content:"成功删除"+data.msg+"个父组"
                });*/
            }else{
                layer.msg(data.msg, {icon: 2});
            }
//code here...
        },
        error:function(){
            layer.msg('error:请求失败', {icon: 2});
        }

    });
}
</script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>

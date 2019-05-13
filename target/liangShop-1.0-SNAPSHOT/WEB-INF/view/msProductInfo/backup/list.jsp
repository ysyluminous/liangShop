<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><a href="toApplyMsProduct">申请亮亮商城商品</a></center>
<table border="2">
	<tr>
		<td>商品id</td>
		<td>商品标题</td>
		<td>图片地址</td>
		<td>亮亮商城价格</td>
		<td>商家id</td>
		<td>亮亮商城原价</td>
		<td>申请时间</td>
		<td>状态</td>
		<td>亮亮商城开始时间</td>
		<td>亮亮商城结束时间</td>
		<td>亮亮商城商品数</td>
		<td>库存</td>
		<td>商品描述</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${listMsProduct}" var="item">
		<tr>
		<td>${item.productId }</td>
		<td>${item.productTitle }</td>
		<td>${item.productPic }</td>
		<td>${item.miaoshaPrice }</td>
		<td>${item.merchant }</td>
		<td>${item.productOgPrice }</td>
		<td>${item.applayDate }</td>
		<td>${item.aidotStatus }</td>
		<td>${item.startTime }</td>
		<td>${item.endTime }</td>
		<td>${item.productCount }</td>
		<td>${item.stockCount }</td>
		<td>${item.description }</td>
		<td>
			<a href="toUpdateMsProduct?id=${item.id}">修改</a>||
			<a href="deletemsproductByid?id=${item.id}">删除</a>||
			<a href="queryMsProductByid?id=${item.id}">查看</a>||
			<a href="toupdatemsproductstate?id=${item.id}">审核</a>||
			<a href="${pageContext.request.contextPath }/msProductDetailAction/toInsertMsProductDetail?productId=${item.productId}&&merchant=${item.merchant}">添加商品详情</a>||
			<a href="${pageContext.request.contextPath }/msProductDetailAction/queryMsproductdetailByid?productId=${item.productId}">查看商品详情</a>||
			<a href="${pageContext.request.contextPath }/msProductDetailAction/toupdateMsproductdetail?productId=${item.productId}">修改商品详情</a></td>
		</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
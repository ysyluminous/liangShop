<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="applyMsProduct" method="post">
	商品id:<input name="productId"></br>
	商品标题:<input name="productTitle"></br>
	商品图片地址:<input name="productPic"></br>
	亮亮商城价格:<input name="miaoshaPrice"></br>
	商品原价:<input name="productOgPrice"></br>
	商家id:<input name="merchant"></br>
	亮亮商城开始时间:<input name="startTimeString"></br>
	亮亮商城结束时间:<input name="endTimeString"></br>
	亮亮商城商品数量:<input name="productCount"></br>
	库存:<input name="stockCount"></br>
	描述:<input name="description"></br>
	<input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
	function submit(obj){
		obj.parent.sumbit();
	}
</script>
</html>
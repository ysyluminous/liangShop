<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="add" method = "post"> 
	商家的姓名:<input name="merchantName"></br>
	商家的店铺名称:<input name="merchantShopName"></br>
	商家账号:<input name="merchantAccount"></br>
	商家密码:<input name="merchantPassword"></br>
	商家经营范围:<input name="merchantScope"></br>
	<input type="button" value="提交" onclick="submit(this)">
</form>

</body>
<script type="text/javascript">
		function submit(obj){
			 obj.parent.submit();
		}

</script>
</html>
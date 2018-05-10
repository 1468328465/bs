<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工信息添加</title>

<!--可无视-->
<link rel="stylesheet" type="text/css" href="images/main.css" /> 

<!--主要样式-->
<link rel="stylesheet" type="text/css" href="images/jqtransform.css" /> 

<script type="text/javascript" src="js/jquery.js"></script> 
<script type="text/javascript" src="js/jquery.jqtransform.js"></script>
<script language="javascript">
$(function(){
	$('.jqtransform').jqTransform();
});
</script>

<style type="text/css">
.demo{width:680px; margin:10px auto; color:#333; background:#fff}
.page_title{width:680px; height:30px; margin:10px auto 0 auto; text-align:center; font-weight:bold;}
form p{padding:4px; line-height:20px; clear:both}
form p label{display:block; float:left; width:100px; padding-top:2px}
</style>

</head>

<body>


<div id="main">

	<h2 class="top_title"><a href="ceshi.hajjjc.com">员工信息添加</a></h2>
	<div class="demo">
		<form action="addEmplist.do" method="post" class="jqtransform">
		<p><label>员工编号：</label><input name="id"/></p>
		<p><label>姓名：</label><input name="name" /></p>
		<p><label>性别：</label><input type="radio" name="gender" value="男" /> <label style="width:auto">男</label> <input type="radio" name="gender" value="女" /> <label style="width:auto">女</label> </p>		
		<p><label>年龄：</label><input name="age"/></p>
		<p><label>联系方式：</label><input name="tel"/></p>
		<p><label>身份证号码：</label><input name="id_card"/></p>
		<p><label>住址：</label><input name="address"/></p>
		<p><label>备注：</label>
		<textarea name="other" rows="6" cols="40"></textarea>
		</p>
		<p><input type="submit" value="提 交" /><input type="reset" value="重置"/></p>
	</form>
	</div>

</div>


</body>
</html>

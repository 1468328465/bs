<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"  %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
  span{
    color:red;
  }
</style>
<script type="text/javascript" src="js/prototype-1.6.0.3.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript">
    function check_uname(){
      var xhr=getXhr();
    xhr.open('get','check_uname.do?username='+$('username').value,true);
    xhr.onreadystatechange=function(){
       if(xhr.readyState==4&&xhr.status==200){
         var txt=xhr.responseText;
         $('msg').innerHTML=txt;
       }
    };
    xhr.send(null); 
      }
      
    function check_code(){
    var xhr=getXhr();
    xhr.open('get','check_code.do?checkcode='+$('checkcode').value,true);
    xhr.onreadystatechange=function(){
       if(xhr.readyState==4&&xhr.status==200){
         var txt=xhr.responseText;
         $('msg_code').innerHTML=txt;
       }
    };
    xhr.send(null);
  }
  
    function check_pwd(){
    var xhr=getXhr();
    xhr.open('get','check_pwd.do?pwd1='+$('pwd1').value+'&pwd='+$('pwd').value,true);
    xhr.onreadystatechange=function(){
       if(xhr.readyState==4&&xhr.status==200){
         var txt=xhr.responseText;
         $('msg_pwd').innerHTML=txt;
       }
    };
    xhr.send(null);
  }
</script>
<title>人事管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Simple User Login Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, SonyErricsson, Motorola Web Design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //For-Mobile-Apps -->
<!-- Style --> <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
</head>
<body>
<div class="container">
<h1>人事管理系统--注册</h1>
     <div class="contact-form">
	 <div class="signin">
     <form action="regist.do" method="post">
	     <p><input  id="username" name="username"  type="text" class="user" value="请输入用户名" onfocus="this.value = '';" onblur="  check_uname()" /></p>
	     <span id="msg"></span>
	     <input id="pwd" name="pwd" type="password" class="pass" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" />
	     <p><input id="pwd1" name="pwd1" type="password" class="pass" value="Password" onfocus="this.value = '';" onblur="  check_pwd();" /></p>
	     <span  id="msg_pwd"></span>
	     <input name="name"  type="text" class="user" value="请输入真实姓名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入真实姓名';}" />
	     <input name="tel"  type="text" class="user" value="请输入手机号码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入手机号码';}" /><br/>
	     <label>性别:
	       <input type="radio" name="gender" value="m">男
	       <input type="radio" name="gender" value="f">女
	     </label>
	     <input id="checkcode" name="checkcode"  type="text" class="user" value="请输入验证码" onfocus="this.value = '';"  " onblur="if (this.value == '') {this.value = '请输入用验证码';} ; check_code();"/>
	     <img style="width:20%" src="checkcode" onclick="this.src='checkcode?'+Math.random();"/>
		 <span id="msg_code">${error_checkcode }</span>
         <input type="submit" value="注册" />	
         				
     </form>
	 </div>
	 </div> 
</div>
<div class="footer">
     <p>人事管理系统</p>
</div>
</body>
</html>
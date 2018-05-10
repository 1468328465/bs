<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<html>
  <head></head>
  <body>
  <%
    Object obj=session.getAttribute("user");
    if(obj==null){
      response.sendRedirect("login.jsp");
      return;
    }
   %>
   <h1>login success</h1>
  </body>
</html>
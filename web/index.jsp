<%-- 
    Document   : index
    Created on : May 6, 2017, 9:15:00 PM
    Author     : ZAS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>login form</title>
  <link rel="stylesheet" type="text/css" href="loginstyle.css">
</head>
 
<body >
    
<div class="login">
  <header class="login-header"><span class="text">LOGIN</span><span class="loader"></span></header>
  <form class="login-form" action="log">
      <input name="usr" class="login-input" type="text" placeholder="Username" required="required"/>
    <input name ="pas" class="login-input" type="password" placeholder="Password" required="required'
           "/>
    <button class="login-btn" type="submit">login</button>
  </form>
</div>

</body>
</html>


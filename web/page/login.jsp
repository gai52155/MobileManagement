<%-- 
    Document   : login
    Created on : May 18, 2016, 4:25:03 PM
    Author     : Katawut
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="../index.jsp">Mobile Management</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
        </ul>
      </div>
    </nav>
    
    <div class="container">
        <legend><h2>Login</h2></legend>
        <c:if test="${not empty error}">
            <c:set var="path" scope="request" value="Login"/>
            <div class="alert alert-danger">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <h4><c:out value="${error}"/></h4>
            </div>
        </c:if>
        <form role="form" class="col-md-6" method="POST" action="Login">
            <div class="form-group">
                <label for="Username">Username</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="pass">Password:</label>
                <input type="password" class="form-control" id="pass" name="pass" required>
            </div>
                <input type="submit" class="btn btn-primary" id="submit" name="submit" value="Login">
        </form>
    </div>

</body>
</html>

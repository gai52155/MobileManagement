<%-- 
    Document   : index
    Created on : May 18, 2016, 4:23:46 PM
    Author     : Katawut
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Mobile Management</title>
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
      <a class="navbar-brand" href="index.jsp">Mobile Management</a>
    </div>
    <c:choose>
        <c:when test="${sessionScope.user != null}">
            <ul class="nav navbar-nav">
                <li><a href="page/history.jsp">ดูประวัติการยืมอุปกรณ์</a></li>
                <li><a href="page/addemployee.jsp">เพิ่มพนักงาน</a></li>
                <li><a href="page/serachdevice.jsp">ค้นหาอุปกรณ์</a></li>
                
                
                
            </ul>
            <ul class="nav navbar-nav navbar-right">
            <li><a href="page/logout.jsp"><span class="glyphicon glyphicon-off"></span><c:out value=" ${user}"/></a></li>
        </c:when>
        <c:otherwise>
               <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                <li><a href="page/login.jsp"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
        </c:otherwise>
     </c:choose>
    </ul>
  </div>
</nav>
</body>
</html>

<%-- 
    Document   : addemployee
    Created on : May 18, 2016, 4:31:49 PM
    Author     : Katawut
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add employee</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:if test="${sessionScope.user == null}">
            <c:redirect url="../index.jsp"/>
        </c:if>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
              <div class="navbar-header">
                <a class="navbar-brand" href="../index.jsp">Mobile Management</a>
              </div>
              <c:choose>
                  <c:when test="${sessionScope.user != null}">
                        <ul class="nav navbar-nav">
                            <li><a href="history.jsp">ดูประวัติการยืมอุปกรณ์</a></li>
                            <li><a href="addemployee.jsp">เพิ่มพนักงาน</a></li>
                            <li><a href="serachdevice.jsp">ค้นหาอุปกรณ์</a></li>
                        </ul>
                      <ul class="nav navbar-nav navbar-right">
                      <li><a href="logout.jsp"><span class="glyphicon glyphicon-off"></span><c:out value=" ${user}"/></a></li>
                  </c:when>
                  <c:otherwise>
                        <ul class="nav navbar-nav">
                              <li class="active"><a href="#">Home</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
                  </c:otherwise>
               </c:choose>
              </ul>
            </div>
        </nav>
        <c:if test="${sessionScope.user == null}">
            <c:redirect url="../index.jsp"/>
        </c:if>
        
        <c:if test="${not empty message}">
            <div class="alert alert-info">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <h4><c:out value="${message}"/></h4>
            </div>
            <c:remove var="message" scope="session" />
        </c:if>
        <div class="container">
            <legend>เพื่มรายชื่อพนักงาน</legend>
            <form name="myForm" method="POST" action="AddEmployee">
                <div class="col-md-12">
                    <label class="control-label col-md-3" for="prefix">คำนำหน้า(ไทย) : </label>
                        <label class="radio-inline">
                        <input type="radio" id="prefixth" name="prefixth" value="นาย">นาย
                    </label>
                    <label class="radio-inline">
                      <input type="radio" id="prefixth" name="prefixth" value="นางสาว">นางสาว
                    </label>
                    <label class="radio-inline">
                      <input type="radio" id="prefixth" name="prefixth" value="นาง">นาง
                    </label>
                </div>
                
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label col-md-3" for="name(th)">ชื่อ(ไทย)</label>
                        <input type="text" class="form-control" id="nameth" name="nameth" required>
                    </div>
                </div>
                
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label col-md-3" for="name(en)">ชื่อ(อังกฤษ)</label>
                        <input type="text" class="form-control" id="nameen" name="nameen" required>
                    </div>
                </div>
                
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label col-md-3" for="lastname(th)">นามสกุล(ไทย)</label>
                        <input type="text" class="form-control" id="lastnameth" name="lastnameth" required>
                    </div>
                </div>
                
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label col-md-3" for="lastname(en)">นามสกุล(อังกฤษ)</label>
                        <input type="text" class="form-control" id="lastnameen" name="lastnameen" required>
                    </div>
                </div>
                
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label col-md-3" for="nickname">ชื่อเล่น</label>
                        <input type="text" class="form-control" id="nickname" name="nickname" required>
                    </div>
                </div>
                
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label col-md-3" for="identify">รหัสพนักงาน</label>
                        <input type="text" class="form-control" id="identify" name="identify" required>
                    </div>
                </div>
                
                <div class="col-md-12">
                    <center>
                        <input type="submit" class="btn btn-primary" name="submit" value='submit'>
                    </center>
                </div>
            </form>
          </div>
            <script>
                
            </script>
    </body>
</html>

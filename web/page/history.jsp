<%-- 
    Document   : history
    Created on : May 18, 2016, 4:32:17 PM
    Author     : Katawut
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>History</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link href="../css/loadingicon.css" rel="stylesheet" type="text/css"/>

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
        <div class="container">
            <c:choose>
                <c:when test="${not empty history}">
                    <%
                        String[] data = (String[]) request.getAttribute("history");
                        int row = data.length;
                        int record = row / 6;
                        int i = 0;
                    %>

                    <table class="table table-striped">
                        <tr>
                            <th>ID</th>
                            <th>IMEI</th>
                            <th>Employee ID</th>
                            <th>วันที่ยืม</th>
                            <th>LAT</th>
                            <th>LONG</th>
                        </tr>
                        <tr>
                            <%
                                while (i < record) {
                                    int col1 = 0 + (6 * i);
                                    int col2 = 1 + (6 * i);
                                    int col3 = 2 + (6 * i);
                                    int col4 = 3 + (6 * i);
                                    int col5 = 4 + (6 * i);
                                    int col6 = 5 + (6 * i);

                                    out.print("<td>" + data[col1] + "</td>");
                                    out.print("<td>" + data[col2] + "</td>");
                                    out.print("<td>" + data[col3] + "</td>");
                                    out.print("<td>" + data[col4] + "</td>");
                                    out.print("<td>" + data[col5] + "</td>");
                                    out.print("<td>" + data[col6] + "</td>");
                                    out.print("</tr>");
                                    i++;
                                }
                            %>
                    </table>
                    <center><a href="history.jsp" onclick="loading()"><span class="glyphicon glyphicon-off"></span>ดูวันอื่นๆ</a></center>
                    <div class="loader" id="loader"></div>
                    </c:when>
                    <c:otherwise>
                    <legend><h2>Search history list</h2></legend>
                    <c:if test="${data == 0 && not empty data}">
                        <div class="alert alert-danger">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <h4><c:out value="ไม่มีการยืมอุปกรณ์ในช่วงเวลาที่ค้นหา"/></h4>
                        </div>
                    </c:if>
                    <c:remove var="history" scope="session" />
                    <form name="myForm" method="post" action="History">
                        <div class="form-group col-md-6 col-sm-6">
                            <label>start time</label>
                            <input class="form-control" type="date" id="start_time" name="start_time" required>
                        </div>

                        <div class="form-group col-md-6 col-md-6">
                            <label>last time</label>
                            <input class="form-control"  type="date" id="last_time" name="last_time" required>
                        </div>
                        <center class="con-md-5">
                            <input type="submit" id="submit" name="submit" value='submit' onclick="loading()" class="btn btn-info">
                            <div class="loader" id="loader"></div>
                        </center>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
        <script>
            $(window).load(function () {
                $('#loader').hide();
            });
            function loading(){
                $('#loader').show();
            }
        </script>
    </body>
</html>

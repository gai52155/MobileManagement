<%-- 
    Document   : serachdevice
    Created on : May 18, 2016, 4:32:02 PM
    Author     : Katawut
--%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>

<sql:setDataSource var="connect" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://rd.promptnow.com:3306/trainee?useUnicode=true&characterEncoding=utf8"
     user="trainee"  password="trainee2016"/>

<sql:query dataSource="${connect}" var="allmobile">
    SELECT DISTINCT device_series FROM mobile;
</sql:query>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search Device</title>
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
    
            <legend>ค้นหาอุปกรณ์</legend>
            <div class="col-md-2 col-sm-2">
                        <div class="form-group">
                        <label for="device">รายชื่ออุปกรณ์</label>
                            <select multiple class="form-control" id="device"size="20">
                                <c:forEach var="row" items="${allmobile.rows}">
                                    <option onclick="selectfunction()" value='${row.device_series}'>${row.device_series}</option>
                                </c:forEach>
                            </select>
                        </div>
                </div>
                <div class="col-md-10 col-sm-10">
                    <table id="devicedata" class="table table-striped devicetable">
                        <tr>
                          <th>IMEI</th>
                          <th>Device Name</th> 
                          <th>Device Type</th>
                          <th>Device Series</th>
                          <th>Version</th>
                          <th>Color</th>
                          <th>DPI_H</th> 
                          <th>DPI_W</th>
                          <th>Operating System</th>
                          <th>LAT</th>
                          <th>LONG</th>
                          <th>Status</th> 
                          <th>update_datetime</th>
                        </tr>
                    </table>
                </div>
        <script>
            function selectfunction()
            {                
                var n = document.getElementById("device");
                var series = n.options[n.selectedIndex].value;
                
                var table = document.getElementById("devicedata");
                
                while(table.rows.length > 1)
                {
                    table.deleteRow(1);
                }
                
                $(document).ready(function() 
                {
                    $.post("../SearchDevice",
                    {
                         series:series
                    }).done(function( data ) 
                    {
                        obj = JSON.parse(data);
                        console.log(obj);
                        
                        for(i=0; i<obj.length;i++)
                        {
                             var $formrow = '<tr><td>'+obj[i].imei+
                                            '</td><td>'+obj[i].device_name+
                                            '</td><td>'+obj[i].device_type+
                                            '</td><td>'+obj[i].device_series+
                                            '</td><td>'+obj[i].version+
                                            '</td><td>'+obj[i].color+
                                            '</td><td>'+obj[i].dpi_h+
                                            '</td><td>'+obj[i].dpi_w+
                                            '</td><td>'+obj[i].os+
                                            '</td><td>'+obj[i].lat+
                                            '</td><td>'+obj[i].long+
                                            '</td><td>'+obj[i].status+
                                            '</td><td>'+obj[i].date+obj[i].time+
                                            '</td></tr>';
                            $('.devicetable').append($formrow);
                        }
                    });
                });
        }
        </script>
    </body>
</html>

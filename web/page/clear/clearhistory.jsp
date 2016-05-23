<%-- 
    Document   : clearhistory
    Created on : May 19, 2016, 4:46:57 PM
    Author     : Katawut
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <c:remove var="history" scope="session" />
        <c:remove var="data" scope="session" />
        <c:redirect url="../history.jsp"/>
    </body>
</html>
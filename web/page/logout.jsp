<%-- 
    Document   : logout
    Created on : May 18, 2016, 4:32:33 PM
    Author     : Katawut
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <c:remove var="user" scope="session" />
        <c:redirect url="../index.jsp"/>
    </body>
</html>
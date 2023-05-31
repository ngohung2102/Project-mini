<%-- 
    Document   : changePassword
    Created on : May 28, 2023, 8:03:51 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change PassWord Page</title>
    </head>
    <body>
        <form action="newPass" method="Post">
            ${sessionScope.userName} <br/>
            Pass<input type="text" name="pass"><br/>
            Re-Pass<input type="text" name="rePass"><br/>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>

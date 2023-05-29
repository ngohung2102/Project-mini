<%-- 
    Document   : OTP
    Created on : May 28, 2023, 5:51:54 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OTP Page</title>
    </head>
    <body>
        <form action="changePass" method="post">
            Hello ${sessionScope.userName} <br/>
            <input type="text" name="otp"> <input type="buttom" name="reSend" value="reSend"/><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>

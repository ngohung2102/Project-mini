<%-- 
    Document   : rePass
    Created on : May 14, 2023, 11:49:40 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="rePass" method="post">
            Account: <input type="text" name="account" required><br><br>
            <button type="button" onclick="refreshCaptcha()">recap</button>
            <img id="captchaImg" src="captchaServlet" alt="captch"/>
            <input type="text" name="captcha" required><br>
            <input type="submit" value="Send OTP">
            <h4>${err}</h4>
        </form>
        <script>
            function refreshCaptcha() {
                fetch('/SWP/captchaServlet', {

                    method: 'POST'
                })
                        .then(Response => Response.blob())
                        .then(Blob => {
                            const imageURL = URL.createObjectURL(Blob);
                            const imageElement = document.getElementById("captchaImg");
                            imageElement.src = imageURL;
                        })
                        .catch(Error => console.error(Error))
            }

        </script>
    </body>
</html>

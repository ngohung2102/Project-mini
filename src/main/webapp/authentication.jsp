<%-- 
    Document   : authentication
    Created on : May 22, 2023, 3:31:24 PM
    Author     : caoqu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Ma xac thuc da duoc gui ve email cua ban</h3>
        <h3>Nhap ma xac thuc de xac minh tai khoan</h3>
        <form action="authen" method="post">
            <input type="text" name="ma"><br><br>
            <button type="button" onclick="refreshCaptcha()">recap</button>
            <img id="captchaImg" src="captchaServlet" alt="captch"/>
            <input type="text" name="captcha"><br><br>
            <input type="submit" name="xacThuc" value="Xac thuc">
        </form>
        <h4>${err}</h4>
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

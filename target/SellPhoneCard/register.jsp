<%-- 
    Document   : resgister
    Created on : May 14, 2023, 11:48:52 PM
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
        
        <form action="register?capans=${capcha}" method="post">
            Account: <input type="text" name="account" ><br><br>
            Password: <input type="text" name="pass" ><br><br>
            Email: <input type="text" name="email" ><br><br>

            <button type="button" onclick="refreshCaptcha()">recap</button>

            <img id="captchaImg" src="captchaServlet" alt="captch"/>
            <input type="text" name="capcha"><br><br>
            <input type="submit" value="Dang ky"><br><br>
        </form>
    </body>

    <script>
        function refreshCaptcha() {
            fetch('http://localhost:8000/DemoProject/captchaServlet', {
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
</html>

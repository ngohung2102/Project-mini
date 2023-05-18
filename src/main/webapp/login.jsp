<%-- 
    Document   : login
    Created on : May 14, 2023, 11:48:46 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        
        <br><br><br><br>
    <center>
        <h3>Login Form</h3>
        <form action="login" method="post">
            Account: <input type="text" name="account"><br><br>
            Password: <input type="text" name="pass"><br><br>
            <input type="submit" value="Login" name="login"><br><br>
            <input type="submit" value="Sign Up" name="signUp"> 
            <input type="submit" value="Foget password" name="rePass"><br><br>
            
            <button type="button" onclick="refreshCaptcha()">recap</button>
            <img id="captchaImg" src="captchaServlet" alt="captch"/>
            <input type="text" name="captcha"><br><br>
        </form>
    </center>
    
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

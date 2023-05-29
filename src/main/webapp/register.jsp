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
    <!DOCTYPE html>
    <html>
        <head>
            <title>Đăng ký</title>
            <style>
                /* Thiết lập kiểu cho form đăng ký */
                form {
                    border: 3px solid #f1f1f1;
                    margin-top: 50px;
                    width: 500px;
                    padding: 20px;
                }

                /* Thiết lập kiểu cho các thẻ input */
                input[type="text"],
                input[type="password"],
                input[type="email"],
                input[type="submit"] {
                    width: 100%;
                    padding: 12px 20px;
                    margin: 8px 0;
                    display: inline-block;
                    border: 1px solid #ccc;
                    box-sizing: border-box;
                }

                /* Thiết lập kiểu cho nút submit */
                input[type="submit"] {
                    background-color: #4caf50;
                    color: white;
                    border: none;
                    cursor: pointer;
                }

                /* Thiết lập kiểu cho khi rê chuột vào nút submit */
                input[type="submit"]:hover {
                    background-color: #45a049;
                }
            </style>
        </head>

        <body>

            <form action="register" method="post">
                Account: <input type="text" name="account" ><br><br>
                Password: <input type="text" name="pass" ><br><br>
                Email: <input type="text" name="email" ><br><br>
                <button type="button" onclick="refreshCaptcha()">recap</button>
                <img id="captchaImg" src="captchaServlet" alt="captch"/>
                <input type="text" name="captcha"><br><br>
                <input type="submit" value="Đăng Ký"><br><br>
            </form>
            <h4>${notice}</h4>
        </body>

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
    </html>
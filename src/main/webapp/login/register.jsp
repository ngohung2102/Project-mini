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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="keywords" content="Official Signup Form Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- fonts -->
        <link href="//fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
        <!-- /fonts -->
        <!-- css -->
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style_1.css" rel='stylesheet' type='text/css' media="all" />
        <!-- /css -->
        <style>



        </style>
    </head>
    <body>

        <form action="register" method="post">
            <div class="form-control w3layouts"> 
                <input type="text" id="firstname" name="account" placeholder="Account" title="Please enter your First Name" required="" autocomplete="off">
            </div>
            <div class="form-control agileinfo">	
                <input type="password" class="lock" name="pass" placeholder="Password" id="password1" required="" autocomplete="off">
            </div>
            <div class="form-control w3layouts">	
                <input type="email" id="email" name="email" placeholder="mail@example.com" title="Please enter a valid email" required="" autocomplete="off">
            </div>
            <div class="captcha-container">
                <button class="recap" type="button" onclick="refreshCaptcha()">recap</button>
                <img id="captchaImg" src="CaptchaServlet" alt="captch"/>
            </div>
            <input type="text" name="captcha"><br><br>		

            <input type="submit" class="register" value="Register">
            <h4>${notice}</h4>
        </form>
    </body>

    <script>
        function refreshCaptcha() {
            fetch('/SWP/CaptchaServlet', {
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
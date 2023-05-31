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
        <title>authentication</title>
    </head>
    <body>
        <h3>Ma xac thuc da duoc gui ve email cua ban</h3>
        <h3>Nhap ma xac thuc de xac minh tai khoan</h3>
        <form action="authen" method="post">
            <input type="text" name="ma"><br><br>
            <input type="submit" name="xacThuc" value="Xac thuc">
        </form>
        <p>An OTP has been resent to your email.</p>
        <p>Time remaining: <span id="timer"></span></p>
        <p id="resendLink" style="visibility: hidden;">Click <a href="#">here</a> to resend OTP</p>
        <h4>${err}</h4>
        <!-- Add JavaScript code for countdown timer  -->
        <script type="text/javascript">
            var countdown;
            function startTimer(duration, display) {
                var timer = duration, minutes, seconds;
                countdown = setInterval(function () {
                    minutes = parseInt(timer / 60, 10);
                    seconds = parseInt(timer % 60, 10);
                    minutes = minutes < 10 ? "0" + minutes : minutes;
                    seconds = seconds < 10 ? "0" + seconds : seconds;
                    display.textContent = minutes + ":" + seconds;
                    if (--timer < 0) {
                        clearInterval(countdown);
                        display.textContent = "Time's up!";
                        enableResendLink();
                    }
                }, 1000);
            }

            function enableResendLink() {
                var resendLink = document.getElementById("resendLink");
                resendLink.style.visibility = "visible";
                resendLink.onclick = function () {
                    // Call your resend OTP function or redirect the user to the resend page
                    // Example: window.location.href = "resend_otp.jsp";
                    window.location.href = "authen";
                };
            }

            window.onload = function () {
                var duration = 60; // Duration in seconds (e.g., 5 minutes)
                var display = document.querySelector('#timer');
                startTimer(duration, display);
            };
        </script>
    </body>
</html>

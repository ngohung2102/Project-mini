/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.SendingMailDAO;
import DAO.capchaDAO;
import Model.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author PC
 */
@WebServlet("/changePass")
public class changePassController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputOtp = req.getParameter("otp");
        HttpSession sess = req.getSession();
        String otp = (String) sess.getAttribute("otp");
        if (inputOtp.equals(otp)) {
            req.getRequestDispatcher("changePassword.jsp").forward(req, resp);
        } else {
            req.setAttribute("err", "sai OTP");
            req.getRequestDispatcher("OTP.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sess = req.getSession();
        // SendMail
        String title = "update otp";
        capchaDAO rand = new capchaDAO();
        String newPass = rand.getCapcha();
        sess.setAttribute("otp", newPass);
        Account acc = (Account)sess.getAttribute("repassAccount");
        String mail =acc.getEmail();
        String content = "your new otp is " + newPass;
        SendingMailDAO sendMail = new SendingMailDAO();
        boolean send = sendMail.SendingMail(resp, req, mail, title, content);
        req.getRequestDispatcher("OTP.jsp").forward(req, resp);
    }

}

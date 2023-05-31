/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import DAO.SendingMailDAO;
import DAO.capchaDAO;
import Model.Account;
import Model.Hashing;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {

    public static final String FiLE_TYPE = "jpeg";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //data recive from jsp
        String account = request.getParameter("account");
        String pass = request.getParameter("pass");
        String reciveEmail = request.getParameter("email");
        String capchaInput = request.getParameter("captcha");

        //hashing password
        Hashing hashing = new Hashing();
        String encryptPass = "";
        try {
            encryptPass = hashing.encrypt(pass);
        } catch (Exception ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }

        HttpSession sess = request.getSession();
        //check valid acc
        AccountDAO a = new AccountDAO();
        List<Account> listA = a.listAll();
        boolean checkValid = false;
        for (Account a1 : listA) {
            if (a1.getUserName().equals(account)) {
                checkValid = true;
            }
        }
        //add data
        AccountDAO c = new AccountDAO();
        if (!checkValid) {
            c.addAll(account, encryptPass, reciveEmail, 1000000, 2, false);
        }

        //sending mail
        SendingMailDAO sendMail = new SendingMailDAO();
        capchaDAO random = new capchaDAO();
        //sending ma xac nhan to authen servlet
        String maXacNhan = random.getCapcha();
        Account acc = new Account(account, encryptPass, reciveEmail, 1000000, 1, false);
        sess.setAttribute("registerAccount", acc);
        sess.setAttribute("maXacNhan", maXacNhan);
        //set content and title mail
        String title = "authentication";
        String content = "anh tung dep trai gui ma cho em " + maXacNhan;
        boolean checkMail = sendMail.SendingMail(response, request, reciveEmail,
                title, content);

        //lay captcha tu session
        String capchaAnswer = (String) sess.getAttribute("captcha");
        //check valid captcha
        boolean checkCaptcha = capchaAnswer.equals(capchaInput);

        //thong bao sau khi ko thoa man dk
        String notice = "";
        if (checkMail && checkCaptcha && !checkValid) {
            request.getRequestDispatcher("authentication.jsp").forward(request, response);
        } else {
            if (!checkMail) {
                notice += "mail failed ";
            }
            if (!checkCaptcha) {
                notice += "captcha failed ";
            }
            if (checkValid) {
                notice += "account exsit ";
            }
        }
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import Model.Account;
import Model.Hashing;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
@WebServlet("/login")

public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //check what button is clicked
        if (request.getParameter("login") != null) {
            //get user input form jsp
            String acc = request.getParameter("account");
            String pass = request.getParameter("pass");
            String captchaInput = request.getParameter("captcha");
            //get captcha from servlet
            HttpSession sess = request.getSession();
            String captcha = (String) sess.getAttribute("captcha");
            boolean checkCaptcha=false;
            if(captcha.equals(captchaInput)){
                checkCaptcha=true;
            }
            //decryted password and check account exsit
            AccountDAO a = new AccountDAO();
            Hashing hashing = new Hashing();
            Account account = a.findAccount(acc);
            boolean checkAccount = false;
            
            if (account != null) {
                String encrytedPass = account.getPassword();
                String decrytedPass = "";
                try {
                    decrytedPass = hashing.decrypt(encrytedPass);
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

                //check input pass equals decryted pass
                if (decrytedPass.equals(pass)) {
                    checkAccount = true;
                }
            }

            if (checkCaptcha && checkAccount) {
                PrintWriter out = response.getWriter();
                out.print("Succes");
                
            } else {
                request.setAttribute("err", "Wrong account or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        }

        if (request.getParameter("signUp") != null) {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }

        if (request.getParameter("rePass") != null) {
            request.getRequestDispatcher("rePass.jsp").forward(request, response);
        }

    }
    //
}

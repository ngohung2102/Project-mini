/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import DAO.capchaDAO;
import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
//import nl.captcha.Captcha;

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
        //check what button is clicked
        if (request.getParameter("login") != null) {
            String acc = request.getParameter("account");
            String pass = request.getParameter("pass");
            
            String captchaInput = request.getParameter("captcha");
            HttpSession sess = request.getSession();
            String captcha = (String) sess.getAttribute("captcha");
            
            AccountDAO a = new AccountDAO();
            boolean checkAccount = a.checkAccount(acc, pass);
            
            if (captcha.equals(captchaInput) && checkAccount) {
                PrintWriter out = response.getWriter();
                out.print("Succus");
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

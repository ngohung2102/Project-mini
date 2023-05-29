/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import Model.Hashing;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
@WebServlet("/newPass")
public class newPassController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sess = req.getSession();
        String userName = (String) sess.getAttribute("userName");
        String newPass = req.getParameter("pass");
        String rePass = req.getParameter("rePass");
        if(newPass.equals(rePass)){
            AccountDAO account = new AccountDAO();
            Hashing hash = new Hashing();
            String hashPass = "";
            try {
                hashPass = hash.encrypt(newPass);
            } catch (Exception ex) {
                Logger.getLogger(newPassController.class.getName()).log(Level.SEVERE, null, ex);
            }
            account.updateNewPass(userName, hashPass);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }else{
            req.setAttribute("err", "pass va re-pass khong giong nhau");
            req.getRequestDispatcher("changePassword.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}

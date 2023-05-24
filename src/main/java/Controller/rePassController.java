/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.AccountDAO;
import DAO.capchaDAO;
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
 * @author caoqu
 */
@WebServlet(name="rePassController", urlPatterns={"/rePass"})
public class rePassController extends HttpServlet {
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String acc = request.getParameter("account");
        String captchaInput = request.getParameter("captcha");
        HttpSession sess = request.getSession();
        String captcha = (String) sess.getAttribute("captcha");

        // check userName exist?
        AccountDAO a = new AccountDAO();
        boolean checkAccount = false;
        List<Account> list = a.listAll();
        String mail = "";
        for (Account account : list) {
            if (account.getUserName().equals(acc)) {
                mail = account.getEmail();
                checkAccount = true;
            }
        }

        // SendMail
//        SendingMailDAO sendMail = new SendingMailDAO();
        String title = "update password";
        capchaDAO rand = new capchaDAO();
        String newPass = rand.getCapcha();
        if (captcha.equals(captchaInput) && checkAccount == true) {
//            boolean send = sendMail.SendingMail(response, request, mail, title, newPass);
            a.updateNewPass(acc, newPass);
            Hashing hashing = new Hashing();
            String hashPass = "";
            try {
                hashPass = hashing.encrypt(newPass);
            } catch (Exception ex) {
                Logger.getLogger(rePassController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        request.setAttribute("newPass", newPass);

        request.getRequestDispatcher("login.jsp").forward(request, response);
        
    }

    

}

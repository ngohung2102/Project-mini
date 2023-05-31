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
import java.util.Random;
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

//        HttpSession session = request.getSession();
//        Random random = new Random();
//        int r = random.nextInt(256); // giá trị R từ 0 đến 255
//        int g = random.nextInt(256); // giá trị G từ 0 đến 255
//        int b = random.nextInt(256); // giá trị B từ 0 đến 255
//
//        String rgb = String.format("#%02x%02x%02x", r, g, b);
//
//        String letter = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
////        Random random = new Random();
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < 6; i++) {
//            int index = random.nextInt(letter.length());
//            char randomChar = letter.charAt(index);
//            sb.append(randomChar);
//        }
//        String randomString = sb.toString();
//// Chuyển hướng đến trang JSP và gửi captchaText qua request
//        session.setAttribute("captchaText", randomString);
//        session.setAttribute("rgb", rgb);
        request.getRequestDispatcher("login.jsp").forward(request, response);
//        response.sendRedirect("login.jsp");

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
            boolean checkCaptcha = false;
            if (captcha.equals(captchaInput)) {
                checkCaptcha = true;
            }

            //check if login is valid
            boolean checkAccount = isValidLogin(acc, pass);
            //check activation
            AccountDAO accountDao = new AccountDAO();
            Account account = accountDao.findAccount(acc);
            boolean isAcitive = account.isStatus();

            if (checkCaptcha && checkAccount && isAcitive) {
                System.out.println("Both captcha and account are valid");
                HttpSession session = request.getSession();
                session.setAttribute("account", acc);
                session.setAttribute("password", pass);
//                request.getRequestDispatcher("output.jsp").forward(request, response);
                if (account.getRoleId() == 1) {
                    request.getRequestDispatcher("admin/index.jsp").forward(request, response);
                }else if(account.getRoleId() == 2){
                    request.getRequestDispatcher("client/index.jsp").forward(request, response);
                }
            } else {
                System.out.println("Either captcha or account is invalid");
                request.setAttribute("err", "Wrong account or password or captcha");
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

    /**
     * Kiểm tra tính hợp lệ của thông tin đăng nhập.
     */
    private boolean isValidLogin(String username, String password) {
        boolean result = false;

        // Tìm kiếm tài khoản trong cơ sở dữ liệu.
        AccountDAO accountDao = new AccountDAO();
        Account account = accountDao.findAccount(username);

        if (account != null) {
            // Nếu tài khoản tồn tại, so sánh mật khẩu đã nhập với mật khẩu đã được mã hóa.
            Hashing hashing = new Hashing();
            String encryptedPassword = account.getPassword();

            try {
                String decryptedPassword = hashing.decrypt(encryptedPassword);

                if (decryptedPassword.equals(password)) {
                    result = true;
                }
            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

}

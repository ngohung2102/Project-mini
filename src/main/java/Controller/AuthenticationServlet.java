/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author caoqu
 */
@WebServlet(name="AuthenticationServlet", urlPatterns={"/authen"})
public class AuthenticationServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AuthenticationServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AuthenticationServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if (request.getParameter("xacThuc") != null) {
            String maXacThuc = request.getParameter("ma");
            String captchaInput = request.getParameter("captcha");
            HttpSession sess = request.getSession();
            String captcha = (String) sess.getAttribute("captcha");
            String err = "";
            if (!maXacThuc.equals("quang") || !captcha.equals(captchaInput)) {
                if (!captcha.equals(captchaInput)) {
                    err += " Ma captcha loi ";
                }
                if (!maXacThuc.equals("quang")) {
                    err += "Ma xac thuc loi ";
                }
                request.setAttribute("err", err);
                request.getRequestDispatcher("authentication.jsp").forward(request, response);
                return;
            }
            request.setAttribute("err", "Xac thuc thanh cong");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

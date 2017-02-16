package com.mycompany.aula02calculadora;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.EmptyStackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(name = "calc", urlPatterns = {"/calc"})
public class calc extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            try {
                if((request.getParameter("n1") == "") || request.getParameter("n2") == ""){
                   throw new Exception("NUMEROS VAZIOS");
                }
                if(request.getParameter("op") == ""){
                   throw new Exception("OP VAZIA");
                }
                String op = request.getParameter("op");
                Double n1 = Double.parseDouble(request.getParameter("n1"));
                Double n2 = Double.parseDouble(request.getParameter("n2"));

                if ((n1 != 0) && (n2 != 0)) {
                    switch (op) {
                        case "+":
                            out.println("Soma:"+(n1+n2));
                            break;
                        case "-":
                            out.println("Subt:"+(n1-n2));
                            break;
                        case "*":
                            out.println("Mult:"+(n1*n2));
                            break;
                        case "/":
                            out.println("Div:"+(n1/n2));
                            break;
                        default:

                            break;
                    }
                }
            } catch (Exception ex) {
                out.println(ex);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

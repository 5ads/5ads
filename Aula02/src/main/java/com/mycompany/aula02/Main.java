package com.mycompany.aula02;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css\">");
            out.println("<link href=\"http://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">");
            out.println("<script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Seja bem-vindo!</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Seja bem-vindo " + ("".equals(request.getParameter("nome"))?"Nanimonai":request.getParameter("nome")) + "</h1>");
            
            String[] strNumeros;
            double soma = 0.0;
            switch(request.getParameter("evento")){
                case "s":
                    strNumeros = request.getParameterValues("numero");
                    
                    for (String s : strNumeros) {
                        if (!s.isEmpty()) {
                            soma += Double.parseDouble(s);
                        }
                    }
                    break;
                case "ma":
                    strNumeros = request.getParameterValues("numero");
                    Double maior = -10E10;
                    for (String s : strNumeros) {
                        if (!s.isEmpty()) {
                             if(Double.parseDouble(s) > maior){ 
                                 maior = Double.parseDouble(s);
                             }
                        }
                    }
                    if(maior == -10E10){
                        out.println("NENHUM MAIOR??? Pelo menos não que "+maior);
                    }
                    else{
                        out.println("O MAIOR É: "+maior);
                    }
                    break;
                case "me":
                    strNumeros = request.getParameterValues("numero");
                    Double menor = 10E10;
                    for (String s : strNumeros) {
                        if (!s.isEmpty()) {
                             if(Double.parseDouble(s) < menor){ 
                                 menor = Double.parseDouble(s);
                             }
                        }
                    }
                    if(menor == -10E10){
                        out.println("NENHUM MENOR??? Pelo menos não que "+menor);
                    }
                    else{
                        out.println("O MENOR É: "+menor);
                    }
                    break;
                    
                default:
                    break;
            }
                
            
            
            
            out.println("Soma: "+soma);
            out.println("<br>");
            out.println("<button class='waves-effect waves-light btn' onclick='history.back()'>VOLTAR</button>");
            out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js\"></script>");
            out.println("</body>");
            out.println("</html>");
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
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

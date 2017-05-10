/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DB.MyDb;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ZAS
 */
public class log extends HttpServlet {

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
            String usr=request.getParameter("usr");
            String pas=request.getParameter("pas");
            Class.forName("com.mysql.jdbc.Driver");
           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM student where USR=? and PAS=?");
            pst.setString(1, usr);
            pst.setString(2, pas);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                out.println("<html ><body>");
             
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"datasheet.css\">");
                out.println("<table border=1 width=50% height=50% align=center% >");
                out.println("<thead>\n <tr>\n" );
                out.println("<th colspan=\"2\" > WELCOME "+rs.getString("USR")+"</th>");
                out.println("</tr> </thead>");
                out.println("<tbody>");
                out.println("<tr><td> Name </td> ");
                out.println("<td>"+rs.getString("NAME")+"</td>");
                out.println("</tr> ");
                out.println("<tr><td> ID </td> ");
                out.println("<td>"+rs.getInt("ID")+"</td>");
                out.println("</tr>");
                out.println("<tr><td> GPA</td> ");
                out.println("<td>"+rs.getString("GPA")+"</td>");
                out.println("</tr>");
                out.println("<tr><td> class </td> ");
                out.println("<td>"+rs.getInt("CLASS")+"</td>");
                out.println("</tr>");
                out.println("</tbody>");
                out.println("</table>");
             out.println("</html></body>");
             con.close();
                
            } 
            else {
                out.println("Incorrect login credentials");
            }
        } catch (SQLException ex) {
            //out.println("Incorrect login credentials");
            Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.prueba.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.ittepic.prueba.ejbs.EJBAlumno;

/**
 *
 * @author pi
 */
@WebServlet( name = "NewAlumno" , urlPatterns =
         {
             "/NewAlumno"
} )
public class NewAlumno extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    EJBAlumno ejb;
    protected void processRequest( HttpServletRequest request , HttpServletResponse response )
        throws ServletException , IOException
    {
        response.setContentType( "application/json; charset=UTF-8" );
        response.setHeader( "Cache-Control" , "no-store" );

        PrintWriter out = response.getWriter();
        String nombre = request.getParameter( "nombre" );
        String apellido = request.getParameter( "apellido" );
        String idsemestre = request.getParameter( "idsemestre" );

        out.print( ejb.newAlumno( nombre , apellido , idsemestre ) );

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet( HttpServletRequest request , HttpServletResponse response )
        throws ServletException , IOException
    {
        processRequest( request , response );
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost( HttpServletRequest request , HttpServletResponse response )
        throws ServletException , IOException
    {
        processRequest( request , response );
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}

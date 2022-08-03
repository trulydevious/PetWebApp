package com.example.petwebapp;

import database.Groomer;
import database.UserDAO;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

/**
 * This class is used to process HTTP requests for basic user.
 * User is created in MySQL Server.
 */
@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {

    private DataSource dataSource;
    private UserDAO dbUser;

    /**
     * Constructor of UserServlet class.
     * * @throws NamingException
     */
    public UserServlet() throws NamingException {

        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        dataSource = (DataSource) envCtx.lookup("jdbc/petWebApp");
    }

    /**
     * This method is used to initialize servlet and database connection.
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();

        try{
            dbUser = new UserDAO(dataSource);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method allows user to send request to get data from database.
     * @param request
     * @param response
     * @throws Exception
     */
    private void listGroomers(HttpServletRequest request, HttpServletResponse response) throws Exception{

        List<Groomer> groomer = dbUser.getGroomersList();
        request.setAttribute("GROOMERS_LIST", groomer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/user_view.jsp");
        dispatcher.forward(request,response);
    }

    /**
     * This method corresponds to http GET request.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            listGroomers(request,response);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method corresponds to http POST request.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}

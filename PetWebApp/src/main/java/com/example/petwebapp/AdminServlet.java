package com.example.petwebapp;

import database.AdminDAO;
import database.Groomer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 * This class is used to process HTTP requests for admin user.
 * User is created in MySQL Server.
 */
@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {

    private AdminDAO dbUtil;
    private final String url = "jdbc:mysql://localhost:3306/petWebApp?useSSL=false&allowPublicKeyRetrieval=true&" + "serverTimezone=CET";

    /**
     * This method is used to initialize servlet and database connection.
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        try {
            dbUtil = new AdminDAO(url);
        } catch (Exception e) {
            throw new ServletException(e);
        }

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

        try {

            String command = request.getParameter("command");
            if (command == null)
                command = "LIST";

            switch (command) {
                case "LIST":
                    listGroomer(request, response);
                    break;
                case "ADD":
                    addGroomer(request, response);
                    break;
                case "LOAD":
                    loadGroomer(request, response);
                    break;
                case "UPDATE":
                    updateGroomer(request, response);
                    break;
                case "DELETE":
                    deleteGroomer(request, response);
                    break;
                default:
                    listGroomer(request, response);
            }

        } catch (Exception e) {
            throw new ServletException(e);
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

        response.setContentType("text/html");
        String login = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");

        dbUtil.setLogin(login);
        dbUtil.setPassword(password);

        if (validate(login, password)) {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_view.jsp");
            List<Groomer> groomerList = null;

            try {
                groomerList = dbUtil.getGroomersList();
            } catch (Exception e) {
                e.printStackTrace();
            }

            request.setAttribute("GROOMERS_LIST", groomerList);
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_log.html");
            dispatcher.include(request, response);
        }

    }

    /**
     * This method is used to get database connection status.
     * @param login
     * @param pass
     * @return status
     */
    private boolean validate(String login, String pass) {

        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, login, pass);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    /**
     * This method is used to create request to get current list of groomer.
     * @param request
     * @param response
     * @throws Exception
     */
    private void listGroomer(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Groomer> groomerList = dbUtil.getGroomersList();
        request.setAttribute("GROOMERS_LIST", groomerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_view.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * This method is used to create request to add groomer.
     * @param request
     * @param response
     * @throws Exception
     */
    private void addGroomer(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String name = request.getParameter("nameInput");
        String website = request.getParameter("websiteInput");
        String openDays = request.getParameter("openDaysInput");
        String city = request.getParameter("cityInput");
        String pets = request.getParameter("petsInput");

        Groomer groomer = new Groomer(name, website, openDays, city, pets);
        dbUtil.addGroomer(groomer);
        listGroomer(request, response);
    }

    /**
     * This method is used to create request to get data about specific groomer.
     * @param request
     * @param response
     * @throws Exception
     */
    private void loadGroomer(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String id = request.getParameter("groomerID");
        Groomer groomer = dbUtil.getGroomer(id);
        request.setAttribute("GROOMER",groomer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/update_form.jsp");
        dispatcher.forward(request,response);
    }

    /**
     * This method is used to create request to update groomer.
     * @param request
     * @param response
     * @throws Exception
     */
    private void updateGroomer(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int id = Integer.parseInt(request.getParameter("groomerID"));
        String name = request.getParameter("nameInput");
        String website = request.getParameter("websiteInput");
        String openDays = request.getParameter("openDaysInput");
        String city = request.getParameter("cityInput");
        String pets = request.getParameter("petsInput");

        Groomer groomer = new Groomer(id, name, website, openDays, city, pets);
        dbUtil.updateGroomer(groomer);
        listGroomer(request,response);
    }

    /**
     * This method is used to create request to delete groomer.
     * @param request
     * @param response
     * @throws Exception
     */
    private void deleteGroomer(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String id = request.getParameter("groomerID");
        dbUtil.deleteGroomer(id);
        listGroomer(request,response);
    }


}

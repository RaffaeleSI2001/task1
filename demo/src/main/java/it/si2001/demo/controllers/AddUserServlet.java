package it.si2001.demo.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import it.si2001.demo.models.User;
import it.si2001.demo.models.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add_user")
public class AddUserServlet extends HttpServlet {
  
  private UserDAO userDAO;
  
  public void init() {
    userDAO = new UserDAO();
  }
  
  private void showNewUserForm(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    RequestDispatcher dispatcher = req.getRequestDispatcher("/add_user.jsp");
    dispatcher.forward(req, res);
  }
  
  private void addUser(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");
    LocalDate birthDay = LocalDate.parse(req.getParameter("birthDay"));
    
    User newUSer = new User(firstName, lastName, birthDay);
    userDAO.saveUser(newUSer);
    
    res.sendRedirect("/list_users");
  }
  
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    showNewUserForm(req, res);
  }
  
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
    	addUser(req, res);
    } catch (SQLException e) {
    	throw new ServletException(e);
    }
  }
  
}

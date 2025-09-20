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

@WebServlet("/update_user")
public class UpdateUserServlet extends HttpServlet {
  
  private UserDAO userDAO;
  
  public void init() {
    userDAO = new UserDAO();
  }
  
  private void showEditUserForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, SQLException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    User existingUser = userDAO.getUserById(id);
    
    RequestDispatcher dispatcher = req.getRequestDispatcher("update_user.jsp");
    req.setAttribute("user", existingUser);
    dispatcher.forward(req, res);
  }
  
  private void updateUser(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");
    LocalDate birthDay = LocalDate.parse(req.getParameter("birthDay"));
    
    User user = new User(id, firstName, lastName, birthDay);
    userDAO.updateUser(user);
    
    res.sendRedirect("/list_users");
  }
  
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
    	showEditUserForm(req, res);
    } catch (SQLException e) {
    	throw new ServletException(e);
    }
  }
  
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
    	updateUser(req, res);
    } catch (SQLException e) {
    	throw new ServletException(e);
    }
  }
  
}

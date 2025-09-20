package it.si2001.demo.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import it.si2001.demo.models.User;
import it.si2001.demo.models.UserDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/list_users")
public class ListUsersServlet extends HttpServlet {
  
  private UserDAO userDAO;

  public void init() {
    userDAO = new UserDAO();
  }
  
  private void listUsers(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException, ServletException {
    List<User> users = userDAO.getAllUsers();
    req.setAttribute("listUsers", users);
    RequestDispatcher dispatcher = req.getRequestDispatcher("list_users.jsp");
    dispatcher.forward(req, res);
  }
  
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
    	listUsers(req, res);
    } catch (SQLException e) {
    	throw new ServletException(e);
    }
  }
  
}

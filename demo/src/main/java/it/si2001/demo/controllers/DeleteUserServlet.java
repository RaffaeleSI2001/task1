package it.si2001.demo.controllers;

import java.io.IOException;
import java.sql.SQLException;

import it.si2001.demo.models.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete_user")
public class DeleteUserServlet extends HttpServlet {
  
  private UserDAO userDAO;
  
  public void init() {
    userDAO = new UserDAO();
  }
  
  private void deleteUser(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));

    userDAO.deleteUser(id);

    res.sendRedirect("/list_users");
  }
  
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
    	deleteUser(req, res);
    } catch (SQLException e) {
    	throw new ServletException(e);
    }
  }
  
}

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <title>Demo - Users</title>
</head>

<body style="display: flex; justify-content: center;">
  
  <div>
    <h1>Users</h1>
    
    <!-- WIP: add new user -->
    <a href="">Add New User</a>
    
    <table>
      <thead>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Birthday</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <c:forEach var="user" items="${listUsers}">
            <!-- WIP: FIELDS -->
            <td><c:out value="user.id"/></td>
            <td><c:out value="user.firstName"/></td>
            <td><c:out value="user.LastName"/></td>
            <td><c:out value="user.birthDay"/></td>
            <!-- WIP: EDIT/DELETE -->
            <td><a href="">Edit</a></td>
            <td><a href="">Delete</a></td>
          </c:forEach>
        </tr>
      </tbody>
    </table>
    
  </div>
  
</body>

</html>

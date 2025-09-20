<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <title>Demo - Users</title>
</head>

<style>
  table {
    border-collapse: collapse;
    width: 100%;
    margin-top: 20px;
  }
  
  th, td {
    border: 1px solid #333;
    padding: 8px;
    text-align: left;
  }
  
  th {
    background-color: #f2f2f2;
    font-weight: bold;
  }
</style>

<body style="display: flex; justify-content: center;">
  
  <div>
    
    <h1>Users</h1>
    
    <a href="/add_user">Add New User</a>
    
    <table>
      <!-- HEAD -->
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Birthday</th>
          <th>Action</th>
        </tr>
      </thead>
      <!-- BODY -->
      <tbody>
        <c:forEach var = "user" items = "${listUsers}">
          <tr>
            <!-- FIELDS -->
            <td>${user.id}</td>
            <td>${user.firstName} ${user.lastName}</td>
            <td>${user.birthDay}</td>
            <!-- EDIT/DELETE -->
            <td>
              <a href="/update_user?id=${user.id}">Edit</a>
              <a href="/delete_user?id=${user.id}" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    
  </div>
  
</body>

</html>

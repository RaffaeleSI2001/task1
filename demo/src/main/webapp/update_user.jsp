<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <title>Demo - Update User</title>
</head>

<body style="display: flex; justify-content: center;">
  
  <div style="display: flex; flex-direction: column;">
    
    <h2>Current User</h2>
    <br>
    
    <form method="post" style="display: flex; flex-direction: column; gap: 1rem; max-width: 400px;">
      <!-- ID -->
      <div>
        <label>ID</label>
        <input type="text" name="id" value="${user.id}">
      </div>
      <!-- FIRST NAME -->
      <div>
        <label>First Name</label>
        <input type="text" value="${user.firstName}" name="firstName" required="required">
      </div>
      <!-- LAST NAME -->
      <div>
        <label>last Name</label>
        <input type="text" value="${user.lastName}" name="lastName" required="required">
      </div>
      <!-- BIRTHDAY -->
      <div>
        <label>Birthday</label>
        <input type="text" value="${user.birthDay}" name="birthDay" required="required">
      </div>
      <!-- SUBMIT/CANCEL -->
      <div>
        <button type="submit">Submit</button>
        <a href="/list_users">Cancel</a>
      </div>
    </form>
    
  </div>
  
</body>

</html>

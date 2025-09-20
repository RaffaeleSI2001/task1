<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <title>Demo - Add User</title>
</head>

<body style="display: flex; justify-content: center;">
  
  <div style="display: flex; flex-direction: column;">
    
    <h2>New User</h2>
    <br>
    
    <form action="/add_user" method="post" style="display: flex; flex-direction: column; gap: 1rem; max-width: 400px;">
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

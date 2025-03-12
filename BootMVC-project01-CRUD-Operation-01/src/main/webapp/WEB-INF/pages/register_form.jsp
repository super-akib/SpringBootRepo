<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="eng">
<head>
    <title>login section</title>
    <link rel="stylesheet" href="stylesheet/register.css">
</head>
<body>
       <div class="main-container">
        <form action="register" method="post">
          <h2>Register User Form</h2>
            <input type="text" name="userName" placeholder="Enter username" required>
            <br>
            <input type="email" name="emailId" placeholder="Enter email-id" required>
            <br>
            <input type="text" name="contactNumber" required  maxlength="10" placeholder="Enter mobile number">
            <br>
            <input type="text" name="address" required placeholder="Enter address">
            <br>
            <input type="submit" value="Add User"> 
        </form>
      </div>
</body>
</html>
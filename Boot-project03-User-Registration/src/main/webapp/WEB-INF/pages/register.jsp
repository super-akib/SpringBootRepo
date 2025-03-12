<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>
<style type="text/css">
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    form {
        width: 350px;
        padding: 20px;
        border-radius: 10px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin-bottom: 8px;
        color: #555;
    }
    input[type="text"], input[type="password"], input[type="email"], input[type="date"], select {
        width: calc(100% - 20px);
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 16px;
    }
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #4CAF50;
        border: none;
        border-radius: 5px;
        color: #fff;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
    <form action="register" method="post">
        <h2>Registration Form</h2>
        <label for="userName">User Name</label>
        <input type="text" id="userName" name="userName" required>
        
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
        
        <label for="emailId">Email ID</label>
        <input type="email" id="emailId" name="emailId" required>
        
        <label for="birthDate">Birth Date</label>
        <input type="date" id="birthDate" name="birthDate" required>
        
        <label for="profession">Profession</label>
        <select id="profession" name="profession" required>
            <option value="Developer">Developer</option>
            <option value="IT Manager">IT Manager</option>
            <option value="HR">HR</option>
            <option value="Sales Manager">Sales Manager</option>
        </select>
        
        <input type="submit" value="Register">
    </form>
</body>
</html>

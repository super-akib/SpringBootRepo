<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Spring Boot Registration Management System</title>
    <style type="text/css">
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        h1 {
            color: #4CAF50;
            text-align: center;
            margin-bottom: 30px;
        }
        button {
            border: none;
            border-radius: 5px;
            background-color: #4CAF50;
            font-size: 20px;
            padding: 15px 30px;
            margin: 10px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #45a049;
        }
        a {
            text-decoration: none;
            color: white;
        }
        output {
            display: block;
            color: red;
            font-size: 18px;
            margin-bottom: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>WELCOME TO SPRING BOOT REGISTRATION MANAGEMENT SYSTEM</h1>
    <output>${message}</output>
    <div>
    <button><a href="reg">Register</a></button>
    <button><a href="login">Login</a></button>
    </div>
</body>
</html>

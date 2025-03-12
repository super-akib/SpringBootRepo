<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html lang="eng">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="stylesheet/pagination.css">
</head>
<body>
   <div class="main-container">
        <div class="headline">
            <h2>CRUD (Create, Read, Update, Delete) Without Refresh / Reload</h2>
            <br>
            <button><a href="register" style="text-decoration: none; color: azure;">Add Users</a></button>
        </div>
        <div id="align-items">
            <hr style="padding-top:5px;">
            <span id="items">
                Show <select name="pageNo">
                    <option value="10">10</option>
                    <option value="8">8</option>
                    <option value="6">6</option>
                    <option value="3">3</option>
                </select> items
            </span>
            <span id="search">
                Search: <input type="search" style="border: none;">
            </span>
            <hr style="padding-top:5px;">
        </div>
        <div class="table-properties">
            <table>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Contact</th>
                    <th>Address</th>
                    <th style="text-align: center;">Action</th>
                </tr>
                <c:choose>
                    <c:when test="${!empty userDatalist.content}">
                        <c:forEach var="user" items="${userDatalist.content}"> 
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.userName}</td>
                                <td>${user.emailId}</td>
                                <td>${user.contactNumber}</td>
                                <td>${user.address}</td>
                                <td class="action-buttons">
                                    <span class="edit"><a href="edit?id=${user.id}" style="color:white; text-decoration: none; font-size: 10px">Edit</a></span>
                                    <span class="delete"><a href="delete?id=${user.id}"style="color:white; text-decoration: none; font-size: 10px"
                                    onclick=" return confirm('Do you want to delete this user')">Delete</a></span>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <h2 style="color:red; text-align: center;">Users entries not available</h2>
                    </c:otherwise>
                </c:choose>
            </table>
            <h3 style="color:red">${status}</h3>
            <h3 style="color:red">${message}</h3>
            <h3 style="color:red">${deleteMsg}</h3>
        </div>
        <br>
        <div>
           <span style="color: #696464;">Showing 1 to 10 of 30 entries (filtered from 30 total entries)</span> 
           <div class="pagination_section">
           <c:if test="${userDatalist.hasPrevious()}">
               <a href="show?page=${userDatalist.pageable.pageNumber-1}">Previous</a>
           </c:if>    
            
            <c:forEach var="i" begin="1" end="${userDatalist.totalPages}" step="1">
                  <a href="show?page=${i-1}">${i}</a>    
            </c:forEach>   
            
            <c:if test="${userDatalist.hasNext()}">
               <a href="show?page=${userDatalist.pageable.pageNumber+1}">Next</a>
            </c:if>  
            </div>
        </div>    
    </div>

</body>
</html>

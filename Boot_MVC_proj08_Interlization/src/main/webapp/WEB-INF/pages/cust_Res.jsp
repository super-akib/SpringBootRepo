<%@ page  isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp" %>

 <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
 
 
 <h1 style="color:red;text-align: center"> <sp:message code="cust.registration.title"></sp:message></h1>
<frm:form modelAttribute="cust">
<table border="1" align="center" background-color="green">

<tr>
<td> <sp:message code="cust.registration.name"></sp:message></td>
<td><frm:input path="name"/></td>
</tr>


<tr>
<td> <sp:message code="cust.registration.address"></sp:message></td>
<td><frm:input path="address"/></td>
</tr>

<tr>
<td> <sp:message code="cust.registration.billAmt"></sp:message></td>
<td><frm:input path="billAmt"/></td>
</tr>
<tr>
<td><input type="submit" value="<sp:message code="cust.btn.registor"></sp:message>"/></td>

</tr>
</table>
</frm:form>
<br> <br>
 <p>
 <a href="?lang=en_US">English</a> &nbsp; &nbsp; &nbsp;
 <a href="?lang=fr_FR"> Freanch</a> &nbsp; &nbsp; &nbsp;
  <a href="?lang=de_DE"> German</a> &nbsp; &nbsp; &nbsp;
   <a href="?lang=hi_IN"> हिंदी</a> &nbsp; &nbsp; &nbsp;
    <a href="?lang=ur_IN"> اردو</a> &nbsp; &nbsp; &nbsp;
    
 </p>
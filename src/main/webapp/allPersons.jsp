<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.01.2020
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My phonebook</title>
</head>
<%--FIXME  TABLE--%>
<body>
<table border="1">
    <tr>
        <th> LAST NAME </th>
        <th> FIRST NAME </th>
        <th> AGE </th>
        <th> GENDER </th>
        <th> PHONE NUMBER </th>
    </tr>
    <c:forEach var="person" items="${personListInJSP}">
        <tr>
            <td> ${person.lastName} </td>
            <td> ${person.name} </td>
            <td> ${person.age} </td>
            <td> ${person.gender} </td>
            <td> ${person.phoneNumber} </td>

        </tr>
    </c:forEach>
</table>

</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22.01.2020
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="newPerson" method="post" action="AddPerson">
    Last name person: <br/>
    <input type="text" id="lastNameField" name="lastName"/> <br/>

    First name  person: <br/>
    <input type="text" id="nameField" name="name"/> <br/>
<%--    <c:set var = "nameValid" scope="session" value="name"/>--%>

<%--        <c:if test="${messages.containsKey('name')}">--%>
<%--    <tr>--%>
<%--            <td> ${messages.name} </td>--%>
<%--    </tr>--%>
<%--        </c:if>--%>
    <c:if test="${not empty messages.name}"> <!-- if(messages.get("name") ! = null) -->
        <b>Enter name</b> <br>
        "${messages.name}"<br>
    </c:if>

        <%-- TODO if message.name != null
        <span class="error">${message.name}</span>--%>
        <%--
        ${hmap.containsKey('REGION')}--%>

    <span class="error">${message.name}</span>

            Age  person: <br/>
            <input type="text" id="ageField" name="age"/> <br/>
            Gender  person: <br/>
            <select name="genderList">
                <option value="M"> Male</option>
                <option value="F"> Female</option>
            </select> <br/>
            Phone Number person: <br/>
            <input type="text" id="tel" name="phoneNumber" class="phoneNumber" placeholder="Телефон" value=""/> <br/> <br/>
            <input type="submit" value="Add Person" onclick='return validate()'/>

            <script type="text/javascript">

                document.getElementById('nameField').onkeydown = function (e) {
                    return (/^[А-Яа-яA-Za-z-]$/.test(e.key)||event.keyCode==8||
                        event.keyCode==37||event.keyCode==39||event.keyCode==46);
                }
                document.getElementById('lastNameField').onkeydown = function (e) {
                    return (/^[А-Яа-яA-Za-z]$/.test(e.key)||event.keyCode==8||
                event.keyCode==37||event.keyCode==39||event.keyCode==46);
                }
                document.getElementById('ageField').onkeydown = function (e) {
                    return (/^[0-9]$/.test(e.key)||event.keyCode==8||
                        event.which==37||event.keyCode==39||event.keyCode==46);
                }
                document.getElementById('tel').onkeydown = function (e) {
                    return (/^[0-9]$/.test(e.key)||event.keyCode==8||
                        event.keyCode==37||event.keyCode==39||event.keyCode==46);
                }
                //mask phone number
                window.addEventListener("DOMContentLoaded", function() {
                    function setCursorPosition(pos, elem) {
                        elem.focus();
                        if (elem.setSelectionRange) elem.setSelectionRange(pos, pos);
                        else if (elem.createTextRange) {
                            var range = elem.createTextRange();
                            range.collapse(true);
                            range.moveEnd("character", pos);
                            range.moveStart("character", pos);
                            range.select()
                        }
                    }
                    function mask(event) {
                    var matrix = "+38 (___) ___-__-__",
                        i = 0,
                        def = matrix.replace(/\D/g, ""),
                        val = this.value.replace(/\D/g, "");
                    if (def.length >= val.length) val = def;
                    this.value = matrix.replace(/./g, function(a) {
                        return /[_\d]/.test(a) && i < val.length ? val.charAt(i++) : i >= val.length ? "" : a
                    });
                    if (event.type == "blur") {
                        if (this.value.length == 2) this.value = ""
                    } else setCursorPosition(this.value.length, this)
                }
                var input = document.querySelector("#tel");
                input.addEventListener("input", mask, false);
                input.addEventListener("focus", mask, false);
                input.addEventListener("blur", mask, false);
                });

                // function validate() {
                //     //validate lastName
                //     var lastNameP = newPerson.lastName.value;
                //     if(lastNameP==null||lastNameP.trim() == ""){
                //         alert('Please enter last name!!!');
                //         newPerson.lastName.focus();
                //         return false;
                //     }
                //     //validate Name
                //     var nameP = newPerson.name.value;
                //     if(nameP==null||nameP.trim() == ""){
                //         alert('Please enter name!!!');
                //         newPerson.name.focus();
                //         return false;
                //     }
                //     //validate age
                //     var ageP = newPerson.age.value;
                //     if(ageP==null||ageP.trim() == ""){
                //         alert('Please enter AGE!');
                //         newPerson.age.focus();
                //         return false;
                //     } else if (ageP<10||ageP>100){
                //         alert('Please enter correct AGE!');
                //         newPerson.age.focus();
                //         return false;
                //     }
                //     //validate phoneNumber
                //     var tel = newPerson.phoneNumber.value;
                //     if(tel==null||tel.trim() == ""){
                //         alert('Please enter phone number!');
                //         newPerson.phoneNumber.focus();
                //         return false;
                //     } else if (tel.length <19){
                //         alert('Please enter correct phone number!');
                //         newPerson.phoneNumber.focus();
                //         return false;
                //     }
                //
                //     document.newPerson.submit();
                //     return true;
                // }
            </script>
        </form>
        </body>
        </html>

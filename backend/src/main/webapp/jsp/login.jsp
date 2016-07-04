<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Login form
<br/>

<c:if test="${fail}">
    Logowanie nieudane. Spróbuj ponownie <br/>
</c:if>
<form action="/login" method="post">
    <label> Login
        <input name="username">
    </label>
    <label>  Haslo
        <input name="password" type="password">
    </label>

    <button type="submit">Login</button>
</form>
</body>
</html>
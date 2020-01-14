<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<body>

<h1>Object Bot- Answer Service</h1>

<div th:if="${message}">
    <h2 th:text="${message}"/>
</div>

<div th:if="${replyMessage}">
    <h2 th:text="${replyMessage}"/>
</div>

</body>
</html>

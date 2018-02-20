<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Spring MVC Test</title>
</head>
<body>

<h2>Student Information</h2>
<form:form modelAttribute="userAttr">
    <form:input type="text" path="username"></form:input>
    <form:input type="text" path="password"></form:input>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
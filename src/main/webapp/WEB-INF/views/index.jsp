<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Spring Social</title>
        <link href="<c:url value="/resources/css/application.css" />" rel="stylesheet"/>
        <script src="<c:url value="/resources/js/application.js"/>"> </script>
    </head>

    <body>

        <p> Most Appropriate and Easy to use <b> Spring Social </b> Example</p>

        <form action="connect/facebook" method="POST" name="fbForm">
            <input type="hidden" name="scope" value="user_posts" />
            <a href="javascript:;" onclick="facebookForm()">
                <input type="image" src="resources/img/facebook.png" />
            </a>
        </form>
    </body>
</html>

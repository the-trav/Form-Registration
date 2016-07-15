<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Successful Submission</title>
    </head>
    <body>
        <h1>You Have Successfully Registered!</h1>
        <p><%=session.getAttribute("theUser")%> </p>
    </body>
</html>

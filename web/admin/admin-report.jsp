<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.appspot.engineerassessment.data.RetrieveAllUsersDB"%>
<%@page import="com.appspot.engineerassessment.business.User"%>
<%!/**
 * method creates table from scratch utilizing the list that is provided via RetrieveAllUsersDB.
 * If a database connection can not be made however there will be an error message displayed instead of that populated table
 */
    public String displayTable() {
    String setTableHeader="<table class=\"reportTable\"><thead><tr><th>First Name</th><th>Last Name</th><th>Address1</th><th>Address2 (optional)</th><th>City</th><th>State</th><th>Zip</th><th>Country</th><th>Date</th></tr></thead>";
        StringBuilder theUserReport = new StringBuilder();
        try {
            List<User> theUsers = new RetrieveAllUsersDB().getAllUsers();
            theUserReport.append(setTableHeader);
            for (int i = 0; i < theUsers.size(); i++) {
                theUserReport.append("<tr>");
                theUserReport.append("<td>");
                theUserReport.append(theUsers.get(i).getFirstName());
                theUserReport.append("</td>");

                theUserReport.append("<td>");
                theUserReport.append(theUsers.get(i).getLastName());
                theUserReport.append("</td>");

                theUserReport.append("<td>");
                theUserReport.append(theUsers.get(i).getAddress());
                theUserReport.append("</td>");

                theUserReport.append("<td>");
                theUserReport.append(theUsers.get(i).getAddressOptional());
                theUserReport.append("</td>");

                theUserReport.append("<td>");
                theUserReport.append(theUsers.get(i).getCity());
                theUserReport.append("</td>");

                theUserReport.append("<td>");
                theUserReport.append(theUsers.get(i).getState());
                theUserReport.append("</td>");

                theUserReport.append("<td>");
                theUserReport.append(theUsers.get(i).getZip());
                theUserReport.append("</td>");

                theUserReport.append("<td>");
                theUserReport.append(theUsers.get(i).getCountry());
                theUserReport.append("</td>");

                theUserReport.append("<td>");
                theUserReport.append(theUsers.get(i).getJoinDate());
                theUserReport.append("</td>");
                theUserReport.append("</tr>");
            }
            theUserReport.append("</table>");
        } catch (RetrieveAllUsersDB.DataBaseException dbe) {
            theUserReport.append("<h1>Database Error</h1><br/> <p>You have encountered an error with the user registration database. "
                    + "If this problem persists than please contact the owner</p> <p>To try again, <a href=\"index.jsp\">click the link from this page.</a></p>");
        }

        return theUserReport.toString();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <link rel="stylesheet" href="../css/adminReport.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Report</title>
    </head>
    <body>
        <h1>All Registered Users</h1>
        <%=displayTable()%>
        <img class="footer"src="../img/helloWorld.png"/>
    </body>
</html>

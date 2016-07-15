/**
 * I lack in experience/knowledge of properly automating tests for database interactions.i hope this is not a deal breaker :-(
 * I apologize for not providing a test class supporting this transaction. :-(
 */
package com.appspot.engineerassessment.data;

import com.appspot.engineerassessment.business.User;
import com.appspot.engineerassessment.data.DatabaseURLConnection.DataBaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trav
 * class that accesses database and retrieves all users within database that is then stored into an list
 */
public class RetrieveAllUsersDB extends DatabaseURLConnection {

    /**
     * 
     * @return a list of users that populate the database
     * @throws com.appspot.engineerassessment.data.DatabaseURLConnection.DataBaseException 
     */
    public List<User> getAllUsers() throws DataBaseException {
        List<User> allUsers = new ArrayList<User>();
        Connection conn = null;
        PreparedStatement getAllUsersStatement;
        ResultSet results;
        try {
            String sqlGetAllUserStatement = "SELECT * from users ORDER BY join_date DESC";
            conn = DriverManager.getConnection(getDatabaseURL());
            getAllUsersStatement = conn.prepareStatement(sqlGetAllUserStatement);
            results = getAllUsersStatement.executeQuery();

            while (results.next()) {//cycle through results
                User theCurrentUser = new User();
                theCurrentUser.setFirstName(results.getString("firstName"));
                theCurrentUser.setLastName(results.getString("lastName"));
                theCurrentUser.setAddress(results.getString("address1"));
                theCurrentUser.setAddressOptional(results.getString("address2"));
                theCurrentUser.setCity(results.getString("city"));
                theCurrentUser.setState(results.getString("state"));
                theCurrentUser.setZip(results.getString("zip"));
                theCurrentUser.setJoinDate(results.getTimestamp("join_date").toString());
                allUsers.add(theCurrentUser);
            }
            //cleaning enviorment
            results.close();
            getAllUsersStatement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InsertUserDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {//ensuring connection gets closed
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                Logger.getLogger(InsertUserDB.class.getName()).log(Level.SEVERE, null, se);
            }
        }
        return allUsers;
    }//end of getAllUsers
}

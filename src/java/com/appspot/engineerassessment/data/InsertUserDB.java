/**
 * I lack in experience/knowledge of properly automating tests for database interactions.i hope this is not a deal breaker :-(
 * I apologize for not providing a test class supporting this transaction. :-(
 */
package com.appspot.engineerassessment.data;

import com.appspot.engineerassessment.business.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trav
 */
public class InsertUserDB extends DatabaseURLConnection {

    private final User theCurrentUser;

    public InsertUserDB(User theCurrentUser) {
        this.theCurrentUser = theCurrentUser;
    }

    /**
     * method that will add user into the database.
     *
     * @throws com.appspot.engineerassessment.data.DatabaseURLConnection.DataBaseException
     *  will be thrown if database url is incorrect
     */
    public void insertUser() throws DataBaseException {
        String sqlUserInsertStatement = "INSERT INTO users (firstName,lastName,address1,address2,city,state,zip,country,join_date)"
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        Connection conn =null;
        PreparedStatement addEntry;
        try {
            conn = DriverManager.getConnection(getDatabaseURL());//opening connection with database
            addEntry = conn.prepareStatement(sqlUserInsertStatement);
            
            java.util.Date date = new java.util.Date();//creating time stamp 
            //i noticed the timestamp is 4 hours ahead of eastern time. i hope this is okay for this purpose?
            Object timeStamp = new java.sql.Timestamp(date.getTime());

            addEntry.setString(1, theCurrentUser.getFirstName());
            addEntry.setString(2, theCurrentUser.getLastName());
            addEntry.setString(3, theCurrentUser.getAddress());
            addEntry.setString(4, theCurrentUser.getAddressOptional());
            addEntry.setString(5, theCurrentUser.getCity());
            addEntry.setString(6, theCurrentUser.getState());
            addEntry.setString(7, theCurrentUser.getZip());
            addEntry.setString(8, theCurrentUser.getCountry());
            addEntry.setObject(9, timeStamp);
            addEntry.executeUpdate();
            
            addEntry.close();//cleaning the enviorment
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InsertUserDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                Logger.getLogger(InsertUserDB.class.getName()).log(Level.SEVERE, null, se);
            }
        }
    }//end insert User
}
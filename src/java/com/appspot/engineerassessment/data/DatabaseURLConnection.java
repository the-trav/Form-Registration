package com.appspot.engineerassessment.data;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trav
 * decided to make the retrieval of the database url an abstract class.
 * I decided to do this for i could separate the two different transactions that is used on the sql database.
 */
abstract class DatabaseURLConnection {
    private String databaseURL;
    
    public String getDatabaseURL() throws DataBaseException{
        if (System.getProperty("com.google.appengine.runtime.version").startsWith("Google App Engine/")) {
            // Check the System properties to determine if we are running on appengine or not
            // Google App Engine sets a few system properties that will reliably be present on a remote
            // instance.
            databaseURL = System.getProperty("ae-cloudsql.cloudsql-database-url");
            try {
                // Load the class that provides the new "jdbc:google:mysql://" prefix.
                Class.forName("com.mysql.jdbc.GoogleDriver");
            } catch (ClassNotFoundException cnf) {
                throw new DataBaseException("Error loading Google JDBC Driver", cnf);
            }
        } else {
            // Set the url with the local MySQL database connection url when running locally
            databaseURL = System.getProperty("ae-cloudsql.local-database-url");
        }
        return databaseURL;
    }
    
     /** created a custom exception class that
     * notifies if the database url is inncorrect OR unreachable(database server is down)
     * if so check config files -> appengine-web.xml to ensure the credentials are correct.
     * 
     * this exception is used in several occasions in order to provide proper error messages for
     * displaying that the connection to the database is unreachable.
     */
    public static class DataBaseException extends Exception {

        DataBaseException(String errorMessage, Exception cnf) {
            Logger.getLogger(DataBaseException.class.getName()).log(Level.SEVERE, errorMessage, cnf);
        }
    }
}

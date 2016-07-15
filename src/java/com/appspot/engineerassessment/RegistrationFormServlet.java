/**
 * I lack in experience/knowledge of properly automating tests for servlet interactions, i hope this is not a deal breaker :-(
 * I apologize for not providing a test class supporting this transaction. :-(
 */
package com.appspot.engineerassessment;

import com.appspot.engineerassessment.business.User;
import com.appspot.engineerassessment.data.InsertUserDB;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author trav
 */
public class RegistrationFormServlet extends HttpServlet {
    private User createNewUser;
    private final Pattern ALPHABET_PATTERN = Pattern.compile("^[a-zA-Z]*");
    private final Pattern ALPHABET_WITH_SPACE_PATTERN = Pattern.compile("^[a-zA-Z\\s]*");
    private final Pattern ALPHANUMERIC_WITH_SPACE_PATTERN = Pattern.compile("^[a-zA-Z0-9\\s]*");
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * method handles the direction of what happens when user hits submit.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        createNewUser = new User();
        createNewUser.setFirstName(request.getParameter("firstName") );
        createNewUser.setLastName(request.getParameter("lastName") );
        createNewUser.setAddress(request.getParameter("address") );
        createNewUser.setAddressOptional(request.getParameter("addressOptional") );
        createNewUser.setCity(request.getParameter("city") );
        createNewUser.setState(request.getParameter("state") );
        createNewUser.setZip(request.getParameter("zip") );
        
        if (serverValidation() ) {
            try{
                InsertUserDB accessAndInsertToDB = new InsertUserDB(createNewUser);
                accessAndInsertToDB.insertUser();
                HttpSession session = request.getSession();
                session.setAttribute("theUser", createNewUser.toString());
                response.sendRedirect("successful-submission.jsp");
            } catch (InsertUserDB.DataBaseException ex) {
                response.sendRedirect("error_sql.html");
                Logger.getLogger(RegistrationFormServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//end of successful request
        
        //if one of the validation fails
        else{
            failedRequest(response);
        }//end of failed request
    }


    
    /**
     * if failed request just reload the page.
     * I was skeptical of just simply reloading the page. The only way this method will process is if html 5 validation
     * fails and javascript is disabled.
     * Which will happen with browsers that do no support html5 validation and the user disabled javascript. :-(
     * 
     * I was thinking of creating 9 other JSP that helped the user with what validation they are missing 
     * the jsp would display which validation they did not meet such as:
     * if(firstNameValidation() != true)
     * response.sendRedirect("first-name-error.jsp"); - that jsp would indicate somewhere that they entered a incorrect first name
     * etc
     * @param response
     * @throws IOException 
     */
    private void failedRequest(HttpServletResponse response) throws IOException {
        response.sendRedirect("");
    }

    /**
     * 
     * @return true if all server validation passes than preceed with accessing the database and transitioning to correct webpage
     */
    private boolean serverValidation() {
        return firstNameValidation()==true && lastNameValidation()==true && cityValidation() == true &&zipValidation()==true &&addressValidation()==true && addressOptionalValidation()==true;
    }

    private boolean addressOptionalValidation(){
        Pattern empty = Pattern.compile("^$");
        Matcher doesAddressOptionalMatchEmpty = empty.matcher(createNewUser.getAddressOptional());
        Matcher doesAddressOptionalMatchAlphanumeric = ALPHANUMERIC_WITH_SPACE_PATTERN.matcher(createNewUser.getAddressOptional());
        return doesAddressOptionalMatchEmpty.matches() ==true || doesAddressOptionalMatchAlphanumeric.matches()==true;
    }
    
    /**
     * 
     * @return true if firstName contains only alphabetic characters
     */
    private boolean firstNameValidation() {
        Matcher doesFirstNameMatch = ALPHABET_PATTERN.matcher(createNewUser.getFirstName());
        return doesFirstNameMatch.matches();
    }

    /**
     * 
     * @return true if lastName contains only alphabetic characters
     */
    private boolean lastNameValidation() {
        Matcher doesLastNameMatch = ALPHABET_PATTERN.matcher(createNewUser.getLastName());
        return doesLastNameMatch.matches();
    }
    
    /**
     * 
     * @return true if city contains only alphabetic characters spaces allowed
     */
    private boolean addressValidation(){
        Matcher doesAddressMatch = ALPHANUMERIC_WITH_SPACE_PATTERN.matcher(createNewUser.getAddress());
        return doesAddressMatch.matches();
    }

    /**
     * 
     * @return true if city contains only alphabetic characters spaces allowed
     */
    private boolean cityValidation() {
        Matcher doesCityMatch = ALPHABET_WITH_SPACE_PATTERN.matcher(createNewUser.getCity());
        return doesCityMatch.matches();
    }
    
    /**
     * 
     * @return true if zip contains 5 digits or 5digits hyphen 4digits 12345-1234
     */
    private boolean zipValidation(){
        Pattern zip_five_or_nine_digits = Pattern.compile("^[0-9]{5}(?:-[0-9]{4})?$");
        Matcher doesZipMatch = zip_five_or_nine_digits.matcher(createNewUser.getZip());
        return doesZipMatch.matches();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet that reacts when user submits registration form, this servlet will than re route the user accordingly if he/she did or did not meet the validations";
    }// </editor-fold>

}

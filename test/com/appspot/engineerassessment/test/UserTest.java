package com.appspot.engineerassessment.test;

import com.appspot.engineerassessment.business.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author trav
 * tests user POJO
 */
public class UserTest {
    private User testUser;
    
    public UserTest() {
        testUser = new User();
    }

    @Test
    public void testFirstName(){
        String firstName = "bob";
        testUser.setFirstName(firstName);
        assertEquals("Bob", testUser.getFirstName());
    }
    
    @Test
    public void testLastName(){
        String lastName = "scott";
        testUser.setLastName(lastName);
        assertEquals("Scott", testUser.getLastName());
    }
    
    @Test
    public void testAddress(){
        String address = "1234 road";
        testUser.setAddress(address);
        assertEquals(address, testUser.getAddress());
    }
    
    @Test
    public void testAddressOptional(){
        String addressOptional = "apt. 219";
        testUser.setAddressOptional(addressOptional);
        assertEquals(addressOptional, testUser.getAddressOptional());
    }
    
    @Test
    public void testCity(){
        String city = "utica";
        testUser.setCity(city);
        assertEquals("Utica", testUser.getCity());
    }
    
    @Test
    public void testState(){
        String state = "Michigan";
        testUser.setState(state);
        assertEquals(state, testUser.getState());
    }
    
    @Test
    public void testZip(){
        String zip = "48094";
        testUser.setZip(zip);
        assertEquals(zip, testUser.getZip());
    }
    
    @Test
    public void testCountry(){
        assertEquals("US", testUser.getCountry());
    }
    
    @Test
    public void testToString(){
        StringBuilder theToString = new StringBuilder();
        theToString.append(testUser.getFirstName());
        theToString.append(" ");
        theToString.append(testUser.getLastName());
        theToString.append(" ");
        theToString.append(testUser.getAddress());
        theToString.append(" ");
        theToString.append(testUser.getAddressOptional());
        theToString.append(" ");
        theToString.append(testUser.getCity());
        theToString.append(" ");
        theToString.append(testUser.getState());
        theToString.append(" ");
        theToString.append(testUser.getZip());
        theToString.append(" ");
        theToString.append(testUser.getCountry());
        assertEquals(theToString.toString(),testUser.toString());
    }

    
}

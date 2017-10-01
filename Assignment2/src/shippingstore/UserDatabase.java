package shippingstore;

import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class UserDatabase{

  private final String userID;
  private final String firstName;
  private final String lastName;

  /**
   * This constructor initializes the user database object. The constructor provides no
   * user input validation. That should be handled by the class that creates a
   * package order object.
   *
   * @param userID a <b><CODE>String</CODE></b> that represents the tracking number
   *
   * @param firstName a <b><CODE>String</CODE></b> that represents the type.
   *
   * @param lastName a <b><CODE>String</CODE></b> that represents the specification.
   *
   *
   */
  public  UserDatabase(String userID, String firstName, String lastName){
    this.userID = userID; 
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getUserID(){
    return userID;
  }

  public String getFirstName(){
    return firstName;
  }
  public String getLastName(){
    return lastName;
  }




}

package starter.stepdefinitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.domain.User;

import java.util.List;
import java.util.Map;

public class ListingUsersStepDefinitions {
    @When("we search users on page {int}")
    public void serachUsersOnpage(int page){

    }

    //we are sending table here from feature file as List<Map<String, String>>
    /*
    Examples:
      | Page | email                      | first_name | last_name |
      | 1    | george.bluth@reqres.in     | George     | Bluth     |
      | 1    | emma.wong@reqres.in        | Emma       | Wong      |
      | 2    | lindsay.ferguson@reqres.in | Lindsay    | Ferguson  |
     */
    /*
    [
    {email=george.bluth@reqres.in, first_name=George, last_name=Bluth},             -->1. map
    {email=emma.wong@reqres.in, first_name=Emma, last_name=Wong},                   -->2.map
    {email=lindsay.ferguson@reqres.in, first_name=Lindsay, last_name=Ferguson}      -->3.map
    ]

     */
//    @Then("the users should include:")
//    public void userListShouldInclude(List<Map<String, String>> userData){
//        System.out.println(userData);
//        // output:  [{email=emma.wong@reqres.in, first_name=Emma, last_name=Wong}]
//    }
    /*
    2. way to send table is using domain object, here we used record object,
    instead of List<Map<String, String>> userData,
    we use List<User> users  --> List of User objects

    sout --> [User[email=george.bluth@reqres.in, firstName=George, lastName=Bluth]]
     */
    @DataTableType
    public User user(Map<String, String> userData){
        return new User(
                userData.get("email"),
                userData.get("first_name"),
                userData.get("last_name")
        );
        /*
        1- The get() method's string input parameter ("first_name") corresponds
        to the column name in your feature file (first_name).
        2- The keys in the map must match exactly with the row names in the datatable in your feature file.
         */
    }
    @Then("the users should include:")
    public void userListShouldInclude(List<User> users){
        System.out.println(users);
    }

}

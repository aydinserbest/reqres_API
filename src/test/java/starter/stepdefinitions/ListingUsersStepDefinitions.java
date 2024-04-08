package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ListingUsersStepDefinitions {
    @When("we search users on page {int}")
    public void serachUsersOnpage(int page){

    }

    //we are sending table from feature file as List<Map<String, String>>
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
    @Then("the users should include:")
    public void userListShouldInclude(List<Map<String, String>> userData){
        System.out.println(userData);
        // output:  [{email=emma.wong@reqres.in, first_name=Emma, last_name=Wong}]
    }

}

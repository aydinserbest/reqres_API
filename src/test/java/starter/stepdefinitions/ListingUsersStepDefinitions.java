package starter.stepdefinitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import starter.domain.User;
import starter.domain.response.ApiResponse;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class ListingUsersStepDefinitions {
    int page;
    @When("we search users on page {int}")
    public void serachUsersOnpage(int page) {
        this.page = page;

    }
    //The ways of passing table in feature file to the step definition:
    //1- List<Map<String, String>>

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
    public User user(Map<String, String> userData) {
        return new User(
                userData.get("email"),
                userData.get("first_name"),
                userData.get("last_name")
        );
    }
        /*
    1- The get() method's string input parameter ("first_name") corresponds to the column name in your feature file (first_name).
        2- The keys in the map must match exactly with the row names in the datatable in your feature file.
         */

    @Then("the users should include:")
    public void userListShouldInclude(User expectedUser) { //WE DO NOT NEED TO USE List<User> users

        /*
        1-
        hard coded:
        Response = RestAssured.get("https://reqres.in/api/users?page=2");// this line will give us a response

         */
        /*
        2-
        we can get page from above:
        RestAssured.given()
                .get("https://reqres.in/api/users?page="+page);

         */
        //3-using query param:
        // we retrieve the data
        List<Map<String, Object>> users
                = RestAssured.given()
                             .queryParam("page", page)
                             .get("https://reqres.in/api/users")
                             .jsonPath()
                             .getList("data");



//        System.out.println(users);
//        System.out.println(users.get(0).get("first_name"));

        assertThat(users).anyMatch(
                returnedUser -> isSameUser(returnedUser, expectedUser)
        );



//        ApiResponse us = response.as(ApiResponse.class);
//        List<ApiResponse.Data> data = us.data();
//        System.out.println(data.get(0).first_name());

//        List<Map<String, String>> list = response.jsonPath().get("data");
//        System.out.println(list.get(0).get("first_name"));
//        System.out.println(response.asString());
//        System.out.println(response.asPrettyString());
    }

    /*
    //3.way of passing table in feature file to the step definition is using DataTable
    //if we will not use User.class inside asList ( ) parameter,
    //we do not need @DataTableType annotation

    @Then("the users should include:")
    public void userListShouldInclude(DataTable table) {
        List<Map<String, String>> list = table.asMaps(String.class, String.class);
        System.out.println(list);
    }

     */
    /*
    if we will benefit of User domain object,
    we need @DataTableType annotation

    @Then("the users should include:")

    public void userListShouldInclude(DataTable table) {
        List<User> list = table.asList(User.class);
        System.out.println(list);
    }

     */

    private boolean isSameUser(Map<String, Object> returnedUser,User expectedUser){
        return returnedUser.get("email").equals(expectedUser.email())
                && returnedUser.get("first_name").equals(expectedUser.firstName())
                && returnedUser.get("last_name").equals(expectedUser.lastName());
    }
}

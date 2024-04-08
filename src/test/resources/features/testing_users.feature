Feature: Listing Users

  Scenario Outline: View all known users
    When we search users on page <Page>
    Then the users should include:
      | email   | first_name   | last_name   |
      | <email> | <first_name> | <last_name> |
    Examples:
      | Page | email                      | first_name | last_name |
      | 1    | george.bluth@reqres.in     | George     | Bluth     |
      | 1    | emma.wong@reqres.in        | Emma       | Wong      |
      | 2    | lindsay.ferguson@reqres.in | Lindsay    | Ferguson  |

#  Scenario Outline: View a specifik user
#    When we search for a user by id <id>
#    Then the following user should be returned:
#      | email   | first_name   | last_name   |
#      | <email> | <first_name> | <last_name> |
#    Examples:
#      | id | email                    | first_name | last_name |
#      | 3  | emma.wong@reqres.in      | Emma       | Wong      |
#      | 5  | charles.morris@reqres.in | Charles    | Morris    |





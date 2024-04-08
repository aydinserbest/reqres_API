package starter.domain;

public record User(String email, String firstName, String lastName) {
}
    /*
    Then the users should include:
      | email   | first_name   | last_name   |  --> these will be the field name of this  User Record
      | <email> | <first_name> | <last_name> |
    Examples:
      | Page | email                      | first_name | last_name |
      | 1    | george.bluth@reqres.in     | George     | Bluth     |

      we are receiving Then part, row titles from feature file
     */
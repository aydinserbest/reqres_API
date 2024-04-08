package starter.domain;

public record User(String email, String firstName, String lastName) {
}
/*
    1- Cucumber performs field name to column name matching in a case-sensitive manner.
    2- If the field names in your User class do not exactly match the column names in your feature file,
    Cucumber will not be able to perform the transformation correctly.
    3- This class should have fields that match the column headers in the table and the field names
    should be the same as the column names, case sensitively.
 */

package edu.guilford;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   
        //Intantiates two users
        //User user1 = new User("John", "Smith", "smithj@guilford.edu", "smithj", 19991231, "blue", "Fluffy", 6587, "pizza");
        //User user2 = new User("Jane", "Doe", "doej@guilford.edu", "doej", 19960229, "red", "Spot", 1928, "Ice Cream");

        //creates two users
        User user1 = createUser();
        User user2 = createUser();

        //generates passwords for both users
        user1.generatePassword();
        user2.generatePassword();

        //prints passwords
        System.out.println("User 1's password is: " + user1.getPassword() + 
                "\n\tEncrypted password is: " + user1.encryptPassword() + 
                "\n\tKey: " + user1.getKey() +
                "\n\tDecrypted password is: " + AES.decrypt(user1.encryptPassword(), user1.getKey()));
        System.out.println("User 2's password is: " + user2.getPassword() + 
                "\n\tEncrypted password is: " + user2.encryptPassword() + 
                "\n\tKey: " + user2.getKey() +
                "\n\tDecrypted password is: " + AES.decrypt(user2.encryptPassword(), user2.getKey()));
    }

    //creates a method that prompts user for attributes and creates a user
    public static User createUser() {
        //creates scanner
        Scanner input = new Scanner(System.in);

        //prompts user for attributes
        System.out.println("Enter first name: ");
        String firstName = input.nextLine();
        System.out.println("Enter last name: ");
        String lastName = input.nextLine();
        System.out.println("Enter email: ");
        String email = input.nextLine();
        System.out.println("Enter username: ");
        String username = input.nextLine();
        System.out.println("Enter date of birth (YYYYMMDD): ");
        int dateOfBirth = input.nextInt();
        System.out.println("Enter favorite color: ");
        String favoriteColor = input.nextLine();
        System.out.println("Enter pet name: ");
        String petName = input.nextLine();
        System.out.println("Enter favorite number: ");
        int favoriteNumber = input.nextInt();
        System.out.println("Enter favorite food: ");
        String favoriteFood = input.nextLine();

        //closes scanner
        input.close();

        //creates user
        User user = new User(firstName, lastName, email, username, dateOfBirth, favoriteColor, petName, favoriteNumber, favoriteFood);

        //returns user
        return user;
    }

}

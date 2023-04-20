package edu.guilford;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   
        //Intantiates two users
        User user1 = new User("John", "Smith", "smithj@guilford.edu", "smithj", 19991231, "blue", "Fluffy", 6587, "pizza");
        User user2 = new User("Jane", "Doe", "doej@guilford.edu", "doej", 19960229, "red", "Spot", 1928, "Ice Cream");

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
}

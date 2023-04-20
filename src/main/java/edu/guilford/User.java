package edu.guilford;

public class User {
    //attributes
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private int dateOfBirth; //YYYYMMDD
    private String password = "";
    private String key = "";
    
    private String favoriteColor;
    private String petName;
    private int favoriteNumber;
    private String favoriteFood;

    //constructor
    public User(String firstName, String lastName, String email, String username, int dateOfBirth, String favoriteColor, String petName, int favoriteNumber, String favoriteFood) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.favoriteColor = favoriteColor;
        this.petName = petName;
        this.favoriteNumber = favoriteNumber;
        this.favoriteFood = favoriteFood;
        
        //removes spaces from pet name and favorite color
        this.petName = this.petName.replaceAll("\\s+","");
        this.favoriteColor = this.favoriteColor.replaceAll("\\s+","");
        //generates random key
        for(int i = 0; i < 16; i++){
            key += (char)(Math.random()*(126-32)+32);
        }
    }

    //generate password
    public void generatePassword() {
        password += this.firstName.substring(0, 2);
        password += this.lastName.substring(0, 2);
        //adds last two digits of favorite number to password
        password += this.favoriteNumber%100;
        
        //adds random character out of !"#$%&'()*+,-./ to password"
        password += (char)(Math.random()*(47-33)+33);
        //alternates between adding characters from pet name amd favorite food to password
        int i = 0;
        while(i < this.petName.length() && i < this.favoriteFood.length() && i < 4) {
            password += this.petName.charAt(i) + "" + this.favoriteFood.charAt(i);
            i += 1;
        }
        //adds random character out of !"#$%&'()*+,-./ to password"
        password += (char)(Math.random()*(47-33)+33);
        //adds length of name of favorite color to password
        password += this.favoriteColor.substring(0, 2)+this.favoriteColor.length();
    }

    //encrypts password
    public String encryptPassword() {
        return AES.encrypt(this.password, this.key);
    }

    //getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getKey() {
        return key;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String firstPetName) {
        this.petName = firstPetName;
    }

    public int getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(int favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }
}

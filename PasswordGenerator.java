/*Simple Password Generator in Java. Will work towards adding a UI to this and will add it to github at a later date! Enjoy */



import java.util.Scanner;
import java.util.Random;

class PasswordGenerator{
    public static void main(String[]args){
      //Variables for the Program
      int userInput =0;
      Scanner input = new Scanner(System.in);
      Scanner lengthOfPass = new Scanner(System.in);
      String password ="";
      int lengthOfPassword= 0;

      do{
      //Prints the Menu 
        System.out.println("Option 1: Generate Password with numbers Only.");
        System.out.println("Option 2: Generate Password with lowercase letters Only.");
        System.out.println("Option 3: Generate Password with uppercase letters Only.");
        System.out.println("Option 4: Generate Password with both uppercase and lowercase letters.");
        System.out.println("Option 5: Generate Password with both numbers and letters(uppercase and lowercase).");
        System.out.println("Option 6: Quit Program.\n");

        System.out.print("Enter a Number 1-6: ");

        //Validates if the user entered a number
        while(!input.hasNextInt()){
          System.out.println("That's not a number!\n");
          System.out.print("Enter a Number 1-5: ");
          input.next();
        }
        userInput = input.nextInt();
        while(userInput > 6 || userInput < 1){
          System.out.println("Enter a valid option!");
          System.out.print("Enter a Number 1-6: ");
          if(input.hasNextInt()){
            userInput = input.nextInt();
          }else{
            input.next();
          }
        }

        if(userInput !=6){
          //Asks the User for the desired length of their password
          System.out.print("How long do you want your password (# of Characters)?: ");
          //Validates if the user entered a number
          while(!lengthOfPass.hasNextInt()){
            System.out.print("\nThats not a number!.\nHow long do you want your password (# of Characters)?: ");
            lengthOfPass.next();
          }
          lengthOfPassword = lengthOfPass.nextInt();
        }

        

        //Calls a method to generate a password with numbers only
        if(userInput == 1){
          password = OnlyNumbersPassword(lengthOfPassword);
        }
        //Calls a method to generate a password with lowercase letters only.
        else if(userInput ==2){
          password = OnlyLowercaseLettersPassword(lengthOfPassword);
        }
        else if(userInput ==3){
          password = OnlyUpperCaseLettersPassword(lengthOfPassword);
        }
        else if(userInput ==4){
          password = BothUpperandLowerCase(lengthOfPassword);
        }
        else if(userInput ==5){
          password = BothNumbersAndLettersPassword(lengthOfPassword);
        }
        System.out.println("\n\nYour Password is: " + password + "\n\n");
      }while(userInput !=6);
      input.close();
      lengthOfPass.close();
      System.out.println("\nProgram Ended!\n\n\n");
    }

    //Methods used to generate the passwords

    //Only Numbers
    public static String OnlyNumbersPassword(int lengthOfPassword){
      //Variables Used in method
      String password = "";
      Random rand = new Random();

      //Generates a new number for the password until the length requirement is met. Numbers can be from 0-9.
      for(int i = 0; i < lengthOfPassword; i++){
        int randomNumber = rand.nextInt(10);
        String numberString = String.valueOf(randomNumber);
        password += numberString;
      }
      return password;
    }
    //Only lowercase Letters
    public static String OnlyLowercaseLettersPassword(int lengthOfPassword){
      String password = "";
      //alphabet is used to obtain characters
      //randomIndex is used to pull the specific characters out
      String alpabet= "abcdefghijklmnopqrstuvxyz";
      Random rand = new Random();

      //Pulls out a random character from the alphabet string and places it into the password string. Goes until the length of the password is satisfied
      for(int i = 0; i < lengthOfPassword; i++){
        int index = rand.nextInt(26);
        password += getCharFromString(alpabet, index);
      }

      return password;
    }
    //Only Uppercase Letters
    //Identical to the previous method
    public static String OnlyUpperCaseLettersPassword(int lengthOfPassword){
      String password = "";
      //alphabet is used to obtain characters
      //randomIndex is used to pull the specific characters out
      String alpabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      Random rand = new Random();

      //Pulls out a random character from the alphabet string and places it into the password string. Goes until the length of the password is satisfied
      for(int i = 0; i < lengthOfPassword; i++){
        int index = rand.nextInt(26);
        password += getCharFromString(alpabet, index);
      }

      return password;
    }

    //Both Uppercase and Lowercase Letters
    //Similar to the previous two. The UpperOrLower variable determines if an uppercase or lowercase letter is pulled into the password!
    public static String BothUpperandLowerCase(int lengthOfPassword){
      String password = "";
      //alphabet is used to obtain characters
      //randomIndex is used to pull the specific characters out
      String upperCaseAlphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String lowerCaseAlphabet = "abcdefghijklmnopqrstuvxyz";
      Random rand = new Random();


      //Pulls out a random character from the alphabet string and places it into the password string. Goes until the length of the password is satisfied
      for(int i = 0; i < lengthOfPassword; i++){
        int UpperOrLower = rand.nextInt(2);
        if(UpperOrLower == 0){
          int index = rand.nextInt(26);
          password += getCharFromString(upperCaseAlphabet, index);
        }else{
          int index = rand.nextInt(26);
          password += getCharFromString(lowerCaseAlphabet, index);
        }
      }

      return password;
    }
    //Both Letters and Numbers
    //Similar the previous but the "determine" variable determines if its a lowercase letter, uppercase letter, or number put into the password.
    public static String BothNumbersAndLettersPassword(int lengthOfPassword){
      String password = "";
      String upperCaseAlphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String lowerCaseAlphabet = "abcdefghijklmnopqrstuvxyz";
      Random rand = new Random();

      for(int i = 0; i < lengthOfPassword; i++){
        int determine = rand.nextInt(3);

        //lnumber
        if(determine == 0){
          int randomNumber = rand.nextInt(10);
          String numberString = String.valueOf(randomNumber);
          password += numberString;
        }else if(determine == 1){
          int index = rand.nextInt(26);
          password += getCharFromString(lowerCaseAlphabet, index);
        }else{
          int index = rand.nextInt(26);
          password += getCharFromString(upperCaseAlphabet, index);
        }
      }

      return password;
    }

    //Supplemental Methods
    //Gets the character from the strings of alphabets in the methods above
    public static char getCharFromString(String string, int index){
      return string.charAt(index);
    }
}
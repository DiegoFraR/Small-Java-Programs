//Simple program that writes Fizzbuzz every time the number is divisible by 3 and 5. The program writes Fizz if the number is divisible by 3
//The program writes buzz if the number is divisible by 5. Otherwise, it prints the number.

public class FizzBizz {
    public static void main(String[]args){

        for(int number = 1; number <= 100; number++){
            if(number % 3 == 0 && number % 5 ==0){
                System.out.println("Fizzbuzz");
            }
            else if(number % 3 == 0){
                System.out.println("Fizz");
            }else if(number % 5 == 0){
                System.out.println("Buzz");
            }else{
                System.out.println(number);
            }
        }
    }
}

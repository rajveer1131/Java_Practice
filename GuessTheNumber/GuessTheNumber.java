import java.util.*;


 class GuessTheNumber {
    public static void main(String[] args) {
        System.out.println("Welcome to Guess The Number! \n" 
                        + "You Will Get 3 Chances! \n"
                        + "After every Try You will Get to Know if your No. is Less than or Greater Than The selected number \n"
                        + "The Game Will Over if You are able to guess the number or your chances runout \n"
                        + "Lets Start! \n \n"
                        + "Enter Your First Guess Below:");
        // Your code goes here

        
        Scanner sc = new Scanner(System.in);
        int guess = sc.nextInt();
        
        int random = (int)(Math.random()*100)+1;
        

        int i=2;
        while(i > 0){
            if(guess==random){
                System.out.println("Hooraaaay YOU WON!");
                break;
            }
            else if(guess>random){
                System.out.println("Your number is greater than the winning number. " + "Guess remaining: "+ i);
                guess = sc.nextInt();
                i--;
            }
            else{
                System.out.println("Your number is Less than the winning number. " + "Guess remaining: "+ i);
                guess = sc.nextInt();
                i--;
            }
        }
        if(i==0){
            System.out.println("YOU LOSE!!!!\n \n"+" The Winning Number was: "+ random);
        }
     sc.close();   
    }
}
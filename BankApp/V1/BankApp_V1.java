import java.util.*;

class UserData {
    private String name;
    private String phoneNumber;
    private double balance;

    UserData() {
        this.name = "Adam";
        this.phoneNumber = "0000000000";
        this.balance = 1000.00;
    }

    UserData(String name, String phoneNumber, double balance) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

}

public class BankApp_V1 {

    static Scanner sc = new Scanner(System.in);
    static UserData userData = new UserData();

    static void withdraw(){
        System.out.println("Enter the Amount you wish to withdraw.");

                while (true) {
                    double withdraw = sc.nextDouble();
                    if (withdraw <= userData.getBalance()) {
                        userData.setBalance( userData.getBalance() - withdraw);
                        System.out.println("You have withdrawn amount: " + withdraw
                                + "\nYour current Bank Account balance is: " + userData.getBalance());
                        break;
                    } else {
                        System.out.println(
                                "Entered Amount is more than the Account Balance. Please enter an amount less than or equal to: "
                                        + userData.getBalance());

                    }
                }


    }

    static void deposit(){
        System.out.println("Enter the Amount you wish to Deposit to Your Account.");
        userData.setBalance(userData.getBalance()+sc.nextDouble()); // For Deposit
        System.out.println("\nYour new current Bank Account balance is: " + userData.getBalance());
        
    }

    static void oldUser() {
        System.out.println("Welcome back, " + userData.getUserName() + "!");


        boolean exit = false;

        while(!exit){
System.out.println("Which Action do you wish to perform\n\n"
                + "Check Balance  -->  Press 1\n"
                + "Withdraw Money -->  Press 2\n"
                + "Deposit Money  -->  Press 3\n\n"
                + "Press 4 to Exit.");
            
            int userAction = sc.nextInt();

        switch (userAction) {
            case 1:
                System.out.println("\nBank Balance: " + userData.getBalance());

                break;
                case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                System.out.println("\nThanks for your visit.\n");
                exit=true;
                break;

            default:
                break;
            }
        }

    }

    static void newUser() {
        System.out.println("Do you wish to open a new account? Press 'y' for yes and 'n' for no");

        char c = sc.next().charAt(0);
        sc.nextLine();

        if (c == 'y') {
            System.out.println("Enter Your Name:");
            userData.setUserName(sc.nextLine());
            System.out.println("Enter Your Phone Number:");
            userData.setPhoneNumber(sc.nextLine());
            System.out.println("Enter The Amount you wish to add to your account:");
            userData.setBalance(sc.nextDouble());
            System.out.println("\nAccount Created Successfully! \nYour Details:\n" + "Name: " + userData.getUserName()
                    + "\nPhone number: " + userData.getPhoneNumber() + "\nBalance: " + userData.getBalance());

        }else{

            System.out.println("Thanks for your visit.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to ABC Bank \n");

        System.out.println("Are you a new User ? Press 'y' for yes and 'n' for no");

        char userInput = sc.next().charAt(0);

        if (userInput == 'y') {
            newUser();
        }

        else {
            oldUser();
        }

        sc.close();

    }
}
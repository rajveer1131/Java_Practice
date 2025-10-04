import java.util.*;

class Calculator{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Operation you want to perform --->  + - / * ");
        char op = sc.next().charAt(0);
        System.out.println("Enter no. 1");
        int n1 = sc.nextInt();
        System.out.println("Enter no. 2");

        int n2 = sc.nextInt();

        int ans = 0;

        switch (op) {
            case '+':
                ans=n1+n2;
                break;
            case '-':
                ans=n1-n2;
                break;
            case '*':
                ans=n1*n2;
                break;
            case '/':
                ans=n1/n2;
                break;
        
            default:
            
                break;
        }

        System.out.println(ans);

        sc.close();
        
    }
}
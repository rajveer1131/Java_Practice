import java.util.*;

class EvenOrOdd{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n%2!=0){
            System.out.println("ODD");
        }
        else{
            System.out.println("EVEN");
        }
    }
}
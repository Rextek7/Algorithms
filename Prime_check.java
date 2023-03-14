import java.util.Scanner;

public class Prime_check {


    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int N = obj.nextInt();

        Prime_check ob = new Prime_check();
        if(ob.isPrime(N) == true){
            System.out.println("prime");
        }else{
            System.out.println("composite");
        }

    }

    public Boolean isPrime(int x) {
        if (x < 2 || x % 2 == 0) return x == 2;
        for (int i = 3; i * i <= x; i += 2)
            if (x % i == 0){
                return false;
            }
        return true;
    }
}


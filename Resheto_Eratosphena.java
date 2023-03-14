import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class Resheto_Eratosphena {
    // Решето Эратосфена: Алгоритм заключается в том, что изначально мы берём всё множество целых чисел
    // в интересующем нас диапазоне, от 2 до N. Затем последовательно проходимся по этому множеству, вычёркивая каждое
    // чётное число, т.к. оно делится на 2. После этого возвращаемся в начало и вычёркиваем все числа, делящиеся на 3, если они ещё не зачёркнуты.
    // Затем делящиеся на следующее простое число - на 5. Затем на 7, на 11 и т. д.
    // То есть мы «просеиваем» исходное множество целых чисел через сито.
    // В итоге у нас останутся только простые числа.
    //https://devmark.ru/article/eratosthene-sieve#header1

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int k = obj.nextInt();
        Resheto_Eratosphena ob = new Resheto_Eratosphena();
        List<Integer> primes = ob.getAllPrimesLessThan(1000000);
        System.out.println(primes.get(k - 1));
    }

    public List<Integer> getAllPrimesLessThan(int sieveSize) {
        var sieve = new BitSet(sieveSize);
        sieve.set(0, sieveSize - 1, true);
        sieve.set(0, false);
        sieve.set(1, false);
        for (int i = 2; i * i < sieve.length(); i++) {
            if (sieve.get(i)) {
                for (int j = i * i; j < sieve.length(); j += i) {
                    sieve.set(j, false);
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < sieve.length(); i++) {
            if (sieve.get(i)) {
                primes.add(i);
            }
        }

        return primes;
    }
}


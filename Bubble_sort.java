import java.util.Arrays;
import java.util.Scanner;

public class Bubble_sort {
    //начиная с начала массива просматриваем попарно по 2 элемента
    //Если второй элемент в паре меньше первого элемента – перемещаем его на место первого,
    // а первый на место второго. Это мы делаем для всех элементов.
    //После того, как мы дошли до конца массива (сравнили предпоследний и последний элементы и сделали обмен, если нужно),
    // проверяем, был ли хотя бы один обмен.
    // Если да, значит массив не отсортирован и начинаем все сначала.
    // Повторяем такие проходы, пока не будет так, что мы проверили попарно все элементы от начала до конца, а обмена ни одного не было.
    // Таким образом элементы с самыми маленькими значениями потихоньку перемещаются справа налево.


    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int size = obj.nextInt();
        String str2 = obj.nextLine();

        String strArr[] = str2.split(" ");
        int[] numArr = new int[size];
        for (int i = 0; i < size; i++) {
            numArr[i] = obj.nextInt();
        }

        int m = 0;
        int k = 0;
        boolean sort = false;
        while (!sort) {
            sort = true;
            for (int i = 0; i < numArr.length - 1; i++) {
                if (numArr[i] > numArr[i + 1]) {
                    sort = false;
                    k++;
                    m = numArr[i];
                    numArr[i] = numArr[i + 1];
                    numArr[i + 1] = m;
                }
            }
        }
        String result = Arrays.toString(numArr).replace("[", "")
                .replace("]", "").replace(",", "");
        System.out.println(result);
        System.out.println(k);
    }
}
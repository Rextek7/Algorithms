import java.util.Arrays;
import java.util.Scanner;

public class Merge_sort {
    //Сортировка слиянием — это алгоритм «разделяй и властвуй», в котором мы сначала делим проблему на подзадачи.
    // Когда решения для подзадач готовы, мы объединяем их вместе, чтобы получить окончательное решение проблемы.
    //Мы можем описать алгоритм как следующий двухэтапный процесс:
    //Разделить: на этом шаге мы делим входной массив на 2 половины , причем точка опоры является средней точкой массива.
    // Этот шаг выполняется рекурсивно для всех полумассивов до тех пор, пока не останется разделяемых полумассивов.
    //Conquer: на этом этапе мы сортируем и объединяем разделенные массивы снизу вверх и получаем отсортированный массив.
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int size = obj.nextInt();
        String str2 = obj.nextLine();

        String strArr[] = str2.split(" ");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = obj.nextInt();

        }


        int l = 0;
        int r = arr.length - 1;
        Merge_sort ob = new Merge_sort();
        ob.sort(arr, l, r);
        printArray(arr);
    }
    void sort(int[] arr, int l, int r){
        if(l < r){
            int m = l + (r-l)/2;
            sort(arr, l, m);
            sort(arr, m+1 ,r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[q + 1 + j];

        // Сохранять текущий индекс подмассивов и основного массива
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        // Пока мы не достигнем конца либо L, либо M, выберите больший из элементов L и M и
        // поместите его в правильное положение на A[p..r].
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        // Когда у нас заканчиваются элементы в L или M,
        // берем оставшиеся элементы и помещаем в A[p..r]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }
    static void printArray(int arr[]) {
        int N = arr.length;
        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}

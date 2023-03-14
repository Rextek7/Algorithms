import java.util.Scanner;

public class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;


    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
    }


    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }


    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }


    private void maxHeapify(int pos) {
        if (isLeaf(pos))
            return;

        if (Heap[pos] < Heap[leftChild(pos)]
                || Heap[pos] < Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)]
                    > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }


    public void insert(int element) {
        Heap[size] = element;
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }



   public void print() {

       for (int i = 0; i < size / 2; i++) {

           System.out.print("Parent Node : " + Heap[i]);

           if (leftChild(i)
                   < size) // if the child is out of the bound
               // of the array
               System.out.print(" Left Child Node: "
                       + Heap[leftChild(i)]);

           if (rightChild(i)
                   < size) // the right child index must not
               // be out of the index of the array
               System.out.print(" Right Child Node: "
                       + Heap[rightChild(i)]);

           System.out.println(); // for new line
       }
   }


    public int extractMax() {
        int popped = Heap[0];
        Heap[0] = Heap[--size];
        maxHeapify(0);
        return popped;
    }


    public static void main(String[] arg) {
        Scanner obj = new Scanner(System.in);
        int size = obj.nextInt();
        obj.nextLine();
        int[] arr = new int[size];
        MaxHeap maxHeap = new MaxHeap(100000);
        for (int i = 0; i < size; i++) {
            String str2 = obj.nextLine();
            String strArr[] = str2.split(" ");
            if (strArr[0].equals("0")) {
                maxHeap.insert(Integer.parseInt(String.valueOf(strArr[1])));
            } else {
                arr[i] = maxHeap.extractMax();
            }
        }
        for (int i = 0; i < size; i++) {
            if (arr[i] == 0) {

            } else {
                System.out.println(arr[i]);
            }
        }
    }
}


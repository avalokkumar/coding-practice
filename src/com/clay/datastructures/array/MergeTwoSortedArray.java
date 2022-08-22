package array;

//Program to merge two sorted array
public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 18};
        int[] b = {2, 4, 6, 8, 10, 12, 16};
        int[] c = new int[a.length + b.length];
        mergeSortedArray(a, b, c);
        for (int x : c) {
            System.out.print(x + " ");
        }
    }

    private static void mergeSortedArray(int[] a, int[] b, int[] c) {
        int i=0,j=0, k=0;
        while (i < a.length && j < b.length){
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < a.length) {
            c[k++] = b[j++];
        }
    }
}

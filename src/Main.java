public class Main {
    public static void main(String[] args) {
        int[] numbers = generate(1, 100, 10000);
        mergesort(numbers, 0, numbers.length - 1);
        display(numbers);
    }

    public static int[] generate(int low, int high, int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = low + (int)(Math.random() * (high - low + 1));
        }
        return result;
    }

    public static void mergesort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergesort(a, low, mid);
            mergesort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= high) {
            temp[k++] = a[j++];
        }

        for (i = 0; i < temp.length; i++) {
            a[low + i] = temp[i];
        }
    }

    public static void display(int[] a) {
        for (int x : a) {
            System.out.print(x + "\t");
        }
    }
}

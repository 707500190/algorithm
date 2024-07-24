package example;

public class QuickSort {

    // 交换数组中的两个元素
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 划分函数，选择一个基准元素，将数组分为两部分
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // 快速排序的递归函数
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // 测试案例
    public static void main(String[] args) {
        int[] arr = {34, 2, 1, 54, 23, 11, 21, 33, 23, 32, 33};
        int n = arr.length;

        System.out.println("排序前的数组为:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        quickSort(arr, 0, n - 1);

        System.out.println("\n排序后的数组为:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}

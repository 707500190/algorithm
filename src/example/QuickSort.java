package example;

import java.util.Random;

public class QuickSort {

    public static int[] sortArray(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

    public static int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 测试案例
    public static void main(String[] args) {
        int[] arr = {34, 2, 1, 54, 23, 11, 21, 33, 23, 32, 33};
        int n = arr.length;

        System.out.println("排序前的数组为:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        int[] res = sortArray(arr);

        System.out.println("\n排序后的数组为:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}

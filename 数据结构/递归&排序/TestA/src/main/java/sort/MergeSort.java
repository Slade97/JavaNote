package sort;

import java.util.Arrays;

public class MergeSort {

    /**
     * 归并排序
     * 其实就是递归，思想是把输入的数组分成两个，
     * 将这两个数组合成一个并排好序
     * 然后递归直到返回目标数组
     * 把长度为n的输入序列分成两个长度为n/2的子序列；
     * 对这两个子序列分别采用归并排序；
     * 将两个排序好的子序列合并成一个最终的排序序列。
     * 最佳情况：T(n) = O(n)
     * 最差情况：T(n) = O(nlogn)
     * 平均情况：T(n) = O(nlogn)
     * 稳定
     * @param array
     * @return
     */

    public static int[] result;
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
}

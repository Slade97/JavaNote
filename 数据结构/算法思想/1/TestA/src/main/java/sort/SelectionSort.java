package sort;

import java.util.Arrays;

public class SelectionSort {
    /**
     *选择排序(Selection-sort)是一种简单直观的排序算法。
     * 它的工作原理：首先在未排序序列中找到最小（大）元素，
     * 存放到排序序列的起始位置，然后，
     * 再从剩余未排序元素中继续寻找最小（大）元素，
     * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
     * */

    public static int[] selectionSort(int[]array){

        if(array.length==0) return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex=i;
            for (int j = i; j < array.length; j++) {
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            int temp=array[minIndex];
            array[minIndex]=array[i];
            array[i]=temp;
        }
        return array;
    }
    public static void main(String[] args) {
        int[]a=new int[]{1,3,12,4,5};
        System.out.println(Arrays.toString(selectionSort(a)));
    }
}

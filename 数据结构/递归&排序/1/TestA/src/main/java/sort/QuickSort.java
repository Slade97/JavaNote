package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {
    /**
     * 快速排序的基本思想：
     * 通过一趟排序将待排记录分隔成独立的两部分，
     * 其中一部分记录的关键字均比另一部分的关键字小，
     * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     * 这里基准数是很重要的，默认取左侧第一个，
     * 但是如果取到的基准数太大，每次都会移动元素，所以优化这个算法
     * 可以从取基准数入手，取到中间数的效率会比较高
     *最佳情况：T(n) = O(nlogn)
     * 最差情况：T(n) = O(n2)
     * 平均情况：T(n) = O(nlogn)
     * */

    private static void quickSort(int[]array,int left,int right){
        if(left>right) return ;
        int i=left;
        int j= right;
        int temp=array[left];//基准值
        while (i<j){
            //右指针的数大于基准值，移动右指针
            while (temp<=array[j]&&j>i){
                j--;
            }
            //左指针的数小于基准值，移动左指针
            while (temp>=array[i]&&i<j){
                i++;
            }
            //处理其他情况，右小于基准，左大于基准，交换位置
            if(i<j){
                int t=array[j];
                array[j]=array[i];
                array[i]=t;
            }
        }
        //把基准数放在两个指针相遇的地方
        array[left]=array[i];
        array[i]=temp;
        //对基准数两边的两个串继续进行快排
        quickSort(array,left,j-1);
        quickSort(array,j+1,right);
    }

    public static void main(String[] args) {
        int[] arr = {2,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

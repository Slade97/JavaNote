package sort;

import java.util.Arrays;

public class BubbleSort {
    /**
     *比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     * */

    public static int[] bubbleSort(int[]array){
        if(array.length==0)return array;
        //一个优化，当没有冒泡操作的时候，
        // 说明数组已经有序了，直接跳出，
        //这样复杂度就会变成o[n]
        boolean flag=false;
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j+1]<array[j]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    flag=true;
                }
            }
            if(!flag) break;
        }
        return array;
    }

    public static void main(String[] args) {
        int[]a=new int[]{1,3,12,4,5};
        System.out.println(Arrays.toString(bubbleSort(a)));
    }
}

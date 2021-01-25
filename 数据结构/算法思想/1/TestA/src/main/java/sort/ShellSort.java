package sort;

public class ShellSort {
    /**
     * 选择通用的希尔增量序列，即数组长度的一半
     * 希尔排序的思路就是用插入排序，但是预处理，会让复杂度降低很多
     * 先分为n=length/2个数组，
     * 每次对这些数组进行插入排序，
     * 然后再分为n=n/2个数组重复上一步，
     * 直到最后n=1,对整个数组进行插入排序，
     * 经过预处理以后的数组进行插入排序的效率会高很多
     * 最佳情况：T(n) = O(nlog2 n)
     * 最坏情况：T(n) = O(nlog2 n)
     * 平均情况：T(n) =O(nlog2n)　
     * 不稳定
     * */

    public static int[] shellSort(int []array){
        if(array.length==0) return array;

        int len= array.length;
        int temp,gap=len/2;
        while (gap>0){
            for (int i = gap; i <len ; i++) {
                temp=array[i];
                int preIndex=i-gap;
                while (preIndex>=0&&array[preIndex]>temp){
                    array[preIndex+gap]=array[preIndex];
                    preIndex-=gap;
                }
                array[preIndex+gap]=temp;
            }
            gap/=2;
        }
        return array;
    }
}

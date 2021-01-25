package sort;

public class InsertSort {
    /**
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     *最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     * */
    public static int[] insertSort(int[]array){
        if(array.length==0) return array;
        int current;
        for (int i = 0; i < array.length-1 ; i++) {
            current=array[i+1];
            int preIndex=i;
            //如果前一个大于当前数，就把前一个元素放在当前位置，并把指针后移
            while (preIndex>=0&&current<array[preIndex]){
                array[preIndex+1]=array[preIndex];
                preIndex--;
            }
            //这里说明前一个元素小于当前元素了，即前一个元素小于当前元素，把当前元素放在排好的序列后面
            //当然，根据while循环前面的代码，如果没有走while，这行操作不会改变顺序
            array[preIndex+1]=current;
        }
        return array;
    }
}

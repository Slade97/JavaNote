package digui;

public class guibing {


    /**
     * 因为子数组已经排好序了
     * 我们需要先划分这两个子数组
     * 比较两个数组中的元素，小的放进新数组，并移位
     * 如果有剩余，则逐步添加进新数组
     * */
    static int[] merge(int[]arr){
        int mid=arr.length/2;
        int[]temp=new int[arr.length];

        /**
         * 三个指针
         * 第一个指向第一个子数组的头部 i
         * 第二个指向第二个子数组的头部 j
         * 第三个指向新数组的头部 k
         * */
        int i=0;
        int j=mid+1;
        int k=0;
        while (i<=mid&&j<arr.length){
            if(arr[i]<=arr[j]){
                temp[k]=arr[i];
                i++;
                k++;
            }else {
                temp[k]=arr[j];
                j++;
                k++;
            }
        }
        /**
         * 剩余的子数组元素，逐个添加
         * */
        while (i<=mid) temp[k++]=arr[i++];
        while (j<arr.length) temp[k++]=arr[j++];

        return temp;

    }
}

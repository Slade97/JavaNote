public class HeapSort {

    public static void maxHeap(int data[],int start,int end){
        int parent=start;
        int son=parent*2+1;//下标是从0开始的就要加1，从1就不用
        while (son<end){
            int temp=son;
            //比较左右节点大小
            if(son+1<end&&data[son]<data[son+1]){
                temp=son+1;//如果右节点大，就要换到右节点
            }
            if(data[parent]>data[temp]){
                return;//不用换
            }else {
                int t=data[parent];
                data[parent]=data[temp];
                data[temp]=t;
                parent=temp;
                son=parent*2-1;
            }
        }
        return;
    }

    public static void heapSort(int data[]){
        int len=data.length;
        for (int i = len/2-1; i >=0; i--) {
            maxHeap(data,i,len);
        }
        for (int i = len-1; i >0 ; i--) {
            if(data[0]>data[i]){
                int temp=data[0];
                data[0]=data[i];
                data[i]=temp;
                maxHeap(data,0,i);
            }
        }
    }

}

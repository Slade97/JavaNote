import java.util.Arrays;

public class ArrayQueue {
    private Object data[];
    private int head=0;
    private int tail=0;
    private int n=0;//数组大小

    public ArrayQueue(int cap){
        data=new Object[cap];
        n=cap;
    }

    public void push(Object item){//o[1]
        //判断我们的队列是不是满了

        if(isFull())return;
        data[tail]=item;
        tail++;
    }
    public Object pop(){//o[1],空间会浪费
        if(isEmpty())return null;
        Object m=data[head];
        head++;
        return m;

    }
    public boolean isFull(){
        //在这里去回收没用到的空间
        if(tail==n)reSize();
        return tail==n;
    }
    public boolean isEmpty(){
        return tail==head;
    }

    //我在这写了扩容和移位的处理，扩容还没应用
    public void reSize(){
        if(tail>=n){//下标超出
            //判断元素个数是否超出
            int newSize=0;
            if(tail-head>n){
                newSize=2*n;
            }else {
                newSize=n;
            }
            Object[]newData=new Object[newSize];
            for (int i = head,j=0; i <=tail-1 ; i++,j++) {
                newData[j]=data[i];
            }
            data=newData;
            tail=tail-head;
            head=0;
        }
    }

    @Override
    public String toString() {

        return Arrays.toString(data);
    }
}

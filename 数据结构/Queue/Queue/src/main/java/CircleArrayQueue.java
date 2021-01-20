public class CircleArrayQueue {
    private Object data[];
    private int head=0;
    private int tail=0;
    private int n=0;//最大空间
    private int size;//当前大小
    public CircleArrayQueue(int cap){
        data=new Object[cap];
        n=cap;
    }

    public void push(int item){
        if((tail+1)%n==head){
            return;
        }
        data[tail]=item;
        // tail++;
        tail=(tail+1)%n;//循环队列这么写，tail=7 8越界 （7+1）%n=0
        size++;
    }
    public Object pop(){
        if(tail==head) return null;
        Object res=data[head];
        head++;
        size--;
        return res;
    }

}

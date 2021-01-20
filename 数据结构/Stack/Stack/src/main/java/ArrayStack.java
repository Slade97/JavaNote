public class ArrayStack<Item> implements MyStack{
    private Item[]a=(Item[])new Object[1];
    private int n=0;//大小初始的元素个数

    //最好是自己提前设置大小
    public ArrayStack(int cap){
        a=(Item[])new Object[cap];
    }

    private void judgeSize(){
        if(n>=a.length){//元素个数大于长度
            resize(2*a.length);
        }else if(n>0&&n<=a.length/2){//元素个数小于长度的一半
            /*
            * 相当于防止额外的空间浪费，垃圾回收 手动GC
            * */
            resize(a.length/2);
        }
    }

    private void resize(int size){
        Item[]temp=(Item[])new Object[size];
        for (int i = 0; i < n; i++) {
            temp[i]=a[i];
        }
        a=temp;
    }

    public MyStack<Item> push(Object item) {
        judgeSize();
        /*
        * 先将数组中的n位置赋值，然后n这个空位指针++
        * */
        a[n++]= (Item) item;
        return null;
    }

    public Item pop() {
        if(isEmpty()) return null;
        /*
        * 这里n相当于 一个空位指针，指向最后一个元素的下一个空位，同时他也代表了元素个数
        * 这里用--n，先减再用，即把空位指针指向n，然后释放掉减后n的空间
        * */
        Item item=a[--n];
        a[n]=null;//释放空间
        return item;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n==0;
    }
}

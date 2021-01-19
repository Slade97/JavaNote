public class ArrayTest {
    /**
     * 自己实现一下数组
     *
     * */
    private int size;
    private int data[];
    private int index;

    public ArrayTest(int size) {
        this.size = size;
        data=new int[size];
        index=0;
    }
    public void print(){
        System.out.println("index:"+index);
        for (int i = 0; i <index ; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
    public void insert(int loc,int n){
        if(index++<size){
            for (int i = size-1; i >loc ; i--) {
                data[i]=data[i-1];
            }
            data[loc]=n;
        }else {//扩容
            size=size*2;
            int[]data1=new int[size];
            for (int i = 0; i <data.length ; i++) {
                data1[i]=data[i];
            }
            data=data1;
            insert(loc, n);
        }
    }

    public void delete(int loc){
        for (int i = loc; i <size ; i++) {
            if(i!=size-1){
                data[i]=data[i+1];
            }else {
                data[i]=-1;
            }
        }
        index--;
    }
    public void update(int loc,int n){
        data[loc]=n;
    }
    public int get(int loc){
        return data[loc];
    }

    public static void main(String[] args) {

        String s1="ja";
        String s2="va";
        String s3="java";
        String s4=s1+s2;
        System.out.println(s3==s4);
        System.out.println(s3.equals(s4));


    }
}

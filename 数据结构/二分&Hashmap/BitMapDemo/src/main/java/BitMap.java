public class BitMap {
    byte[]bits;
    int max;

    public BitMap(int max){
        this.max=max;
        bits=new byte[(max>>3)+1];
    }
    public void add(int n){
        int bitsIndex=n>>3;//在哪个byte
        int loc=n%8;//这个可以用&运算

        //下面我们把bit数组里面的bitsIndex这个下标的byte里面的第loc个bit位置为1
        bits[bitsIndex] |=1<<loc;
    }
    public boolean find(int n){
        int bitsIndex=n>>3;//在哪个byte
        int loc=n%8;//这个可以用&运算

        int flag=bits[bitsIndex]&(1<<loc);
        if(flag==0) return false;
        return true;
    }

    public static void main(String[] args) {
        BitMap bitmap=new BitMap(100);
        bitmap.add(2);
        bitmap.add(3);
        bitmap.add(65);
        bitmap.add(66);

        System.out.println(bitmap.find(3));
        System.out.println(bitmap.find(64));
    }
}

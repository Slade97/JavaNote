public class test {
    public static void main(String[] args) {
        ArrayQueue a=new ArrayQueue(3);
        a.push(2);
        a.push(3);
        a.push(4);
        System.out.println(a.toString());
        a.pop();
        System.out.println(a.toString());
        a.push(5);
        System.out.println(a.toString());
        a.pop();
        a.pop();
        a.pop();
        a.push(1);
        a.push(2);
        a.push(3);
        System.out.println(a.toString());
        a.push(4);
        System.out.println(a.toString());


    }
}

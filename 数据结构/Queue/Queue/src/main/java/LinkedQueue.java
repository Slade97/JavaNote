import utils.MyLinkedList;

/**
 * 我用了两个值为0的节点当head和tail，
 * 打印的时候也避开了这两个节点
 * 主要关注了一下边界问题
 * */
public class LinkedQueue {
    private MyLinkedList list;
    private ListNode head;
    private ListNode tail;
    private int n=0;//数组大小
/**
 * 初始化
 * */
    public LinkedQueue() {
        list=new MyLinkedList();
        head=new ListNode(0);
        tail=new ListNode(0);
        head.next=tail;
    }

    public void push(int item){
        ListNode newNode=new ListNode(item);
        newNode.next=head.next;
        head.next=newNode;
        n++;
    }
    /**
     * 链表实现不用管大小，所以push没判断大小，
     * 但是pop的话，因为head和tail是两个边界
     * 用户数据插在这两个节点之间，
     * 如果head.next=tail则说明他们之间没用别的数据了为空
     * */
    public int pop(){
        int res=-1;
        if(head.next==tail)return res;
        ListNode cur=head;
        for (int i = 1; i < n; i++) {
            cur=cur.next;
        }
        cur.next=tail;
        n--;
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        ListNode cur=head.next;//这里处理了一下边界，直接从第一个数据节点开始遍历
        while (cur.next!=null){//这个条件可以判断当前节点是不是tail
            sb.append(cur.val);
            cur=cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedQueue list=new LinkedQueue();
        list.push(1);
        System.out.println(list.toString());

        list.push(2);
        System.out.println(list.toString());

        list.push(3);
        System.out.println(list.toString());

        list.pop();
        System.out.println(list.toString());
        list.pop();
        System.out.println(list.toString());
        list.pop();
        System.out.println(list.toString());


    }
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
}

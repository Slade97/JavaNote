package utils;

public class MyLinkedList {
    private ListNode head;
    private int size=0;
    public void insertHead(int data){
        ListNode newNode=new ListNode(data);
        //如果原来就有数据
        newNode.next=head;
        head=newNode;
    }

    public ListNode getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void insertNth(int data, int position){
        if(position==0){
            insertHead(data);
            size++;
        }else {
            ListNode cur=head;
            for (int i = 1; i <position ; i++) {
                cur=cur.next;
            }
            ListNode newNode=new ListNode(data);
            newNode.next=cur.next;
            cur.next=newNode;
            size++;
        }
    }

    public int getVal(int position){
        int res=-1;
        if(position==0){
            res=head.val;
        }else {
            ListNode cur=head;
            for (int i = 1; i <=position ; i++) {
                cur=cur.next;
            }
            res=cur.val;
        }
        return res;
    }

    public void deleteHead(){
        head=head.next;
    }

    public void deleteNth(int position){
        if(position==0){
            deleteHead();
        }else {
            ListNode cur=head;
            for (int i = 1; i <position ; i++) {
                cur=cur.next;
            }
            cur.next=cur.next.next;//cur.next表示的是删除的节点
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode cur=head;
        for (int i = 0; i <size ; i++) {
            sb.append(cur.val);
            cur=cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        list.insertNth(0,0);
        list.insertNth(1,1);
        System.out.println(list.getVal(1));
    }

    class ListNode{ //
        int val;
        ListNode next; //
        ListNode(int x){ //
            val = x;
            next = null;
        }
    }
}

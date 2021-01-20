public class MyLinkedList {
    private ListNode head;
    private int size=0;
    public void insertHead(int data){
        ListNode newNode=new ListNode(data);
        //如果原来就有数据
        newNode.next=head;
        head=newNode;
    }

    public void insertNth(int data,int position){
        if(position==0){
            insertHead(data);
        }else {
            ListNode cur=head;
            for (int i = 1; i <position ; i++) {
                cur=cur.next;
            }
            ListNode newNode=new ListNode(data);
            newNode.next=cur.next;
            cur.next=newNode;
        }
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

     class ListNode{ //
        int val;
        ListNode next; //
        ListNode(int x){ //
            val = x;
            next = null;
        }
    }
}

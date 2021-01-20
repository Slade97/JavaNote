public class DoubleLinkedList {
    private DNode head;
    private DNode tail;

    DoubleLinkedList(){
        head=null;
        tail=null;
    }

    public void insertHead(int data){
        DNode dNode = new DNode(data);
        if(head==null){
            tail=dNode;
            head=dNode;
        }else {
            head.prev=dNode;
            dNode.next=head;
        }
    }
    public void insertNth(int data,int position){
        if (position==0){
            insertHead(data);
        }else {
            DNode cur=head;
            for (int i = 1; i <position ; i++) {
                cur=cur.next;
            }
            DNode newNode = new DNode(data);
            newNode.prev=cur;//新节点的prev给前节点
            newNode.next=cur.next;//新节点的next为前节点的next
            cur.next.prev=newNode;//后节点的prev为新节点
            cur.next=newNode;//前节点的后节点为新节点
        }
    }

    public void deleteHead(){
        DNode temNode=head.next;
        temNode.prev=null;
        head=temNode;
    }
/**
 *  思路： 假设有ABC节点要删除B节点
 *         1 将 A 节点的后续节点指向 C节点
 *         2 将C节点前驱节点指向A节点
 * */
    public void deleteNth(int position){
        if(position==0){
            deleteHead();
        }else {
            DNode cur=head;
            for (int i = 1; i <position ; i++) {
                cur=cur.next;
            }

            cur.next=cur.next.next;//cur.next表示的是删除的节点
            cur.next.prev=cur;
        }
    }


    class DNode{
        int value;
        DNode next;
        DNode prev;
        DNode(int value){
            this.value=value;
            this.next=null;
            this.prev=null;
        }
    }
}

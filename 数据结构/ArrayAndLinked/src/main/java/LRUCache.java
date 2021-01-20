public class LRUCache {
    private MyLinkedList list;
    private int size;


    public LRUCache(int size){
        this.size=size;
        list=new MyLinkedList();
    }

    private void checkItem(int item){
        MyLinkedList.ListNode cur=list.getHead();
        for (int i = 0; i < list.getSize(); i++) {
            if(cur.val==item){
                list.deleteNth(i);
                list.insertHead(item);
                return;
            }else {
                cur=cur.next;
            }
        }
        if(list.getSize()==size){
            list.deleteNth(size-1);
        }
        list.insertHead(item);
    }

    private void addItem(int item){
        if(list.getSize()<size){
            list.insertNth(item,list.getSize());
        }else {
            System.out.println("full!");
        }
    }
    @Override
    public String toString(){

        return list.toString();
    }

    public static void main(String[] args) {
        LRUCache l=new LRUCache(3);
        l.addItem(3);
        l.addItem(6);
        l.addItem(9);
        l.checkItem(6);
        System.out.println(l.toString());
        l.checkItem(8);
        System.out.println(l.toString());
    }
}

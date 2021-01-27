public class BinarySearchTree {
    int data;
    BinarySearchTree left;
    BinarySearchTree right;

    public BinarySearchTree(int data) {
        this.data = data;
        this.left=null;
        this.right=null;
    }
    //插入的时候每次和根节点比较，一直找到它应该插入的位置
    //肯定会插入到叶子节点，那么其实插入就是查找
    public void insert(BinarySearchTree root,int data){
        if(root.data<data){
            if(root.right==null){
                root.right=new BinarySearchTree(data);
            }else {
                insert(root.right,data);
            }
        }else {
            if(root.left==null){
                root.left=new BinarySearchTree(data);
            }else {
                insert(root.left,data);
            }
        }
    }
    public void find(BinarySearchTree root,int data){
        if(root!=null){
            if(root.data<data){
                find(root.right,data);
            }else if(root.data>data){
                find(root.left,data);
            }else {
                System.out.println("got it ");
                System.out.println("root.data");
                return;
            }
        }
    }
}

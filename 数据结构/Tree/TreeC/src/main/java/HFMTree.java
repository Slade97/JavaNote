import java.util.*;

public class HFMTree {
    class HfmNode implements Comparable<HfmNode>{//优先队列，小的把优先级调高，TOP K
        String chars;
        int fre;//权值，也就是这个值出现的频率
        HfmNode left;
        HfmNode right;
        HfmNode parent;

        public int compareTo(HfmNode hfmNode) {
            return this.fre-hfmNode.fre;
        }
    }

    HfmNode root;
    List<HfmNode> leafs;
    Map<Character,Integer> weights;

    public HFMTree(Map<Character, Integer> weights) {
        this.weights = weights;
        leafs=new ArrayList<HfmNode>();
    }

    public Map<Character,String> code(){
        Map<Character,String>map=new HashMap<Character, String>();
        for (HfmNode node : leafs) {
            String code="";
            Character c= node.chars.charAt(0);
            HfmNode current=node;
            do{
                if(current.parent!=null&&current==current.parent.left){//说明当前点是左边
                    //因为我们算哈夫曼编码是用root开始的，这样遍历是反过来的
                    //所以我们加在前面
                    code="0"+code;
                }else {
                    code="1"+code;
                }
            }while (current.parent!=null);
            map.put(c,code);
        }
        return map;
    }
    public String enCode(String str){
        StringBuilder sb=new StringBuilder();
        char[]chars=str.toCharArray();
        for (char c : chars) {
            for (HfmNode node : leafs) {
                if(c==node.chars.charAt(0)){
                    String code="";
                    HfmNode current=node;
                    do{
                        if(current.parent!=null&&current==current.parent.left){//说明当前点是左边

                            code="0"+code;
                        }else {
                            code="1"+code;
                        }
                    }while (current.parent!=null);
                    sb.append(code);
                    break;
                }
            }
        }
        return sb.toString();
    }
    //密文-》原始字符串
    public String deCode(String str){return null;}
    public void createTree(){
        Character keys[]=weights.keySet().toArray(new Character[0]);//拿出所有的点
        PriorityQueue<HfmNode> priorityQueue=new PriorityQueue<HfmNode>();//jdk底层的优先队列
        for(Character c:keys){
            HfmNode hfmNode = new HfmNode();
            hfmNode.chars=c.toString();
            hfmNode.fre=weights.get(c);
            priorityQueue.add(hfmNode);
            leafs.add(hfmNode);
        }
        int len=priorityQueue.size();
        for(int i=1;i<len-1;i++){
            HfmNode n1=priorityQueue.poll();//出队
            HfmNode n2=priorityQueue.poll();

            HfmNode newNode=new HfmNode();
            newNode.chars=n1.chars+n2.chars;
            newNode.fre=n1.fre+n2.fre;
            //维护这个树的结构
            newNode.left=n1;
            newNode.right=n2;
            n1.parent=newNode;
            n2.parent=newNode;

            priorityQueue.add(newNode);
        }
        root=priorityQueue.poll();//最后这个点是我们的根节点
    }
}

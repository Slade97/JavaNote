给定N个权值为N个叶子节点，构造一个二叉树，若该树的带权路径长度达到最小，称这样的二叉树为最优二叉树，也叫哈夫曼树

**权值越大，离root越近**

实现思路：

```
每次取数值最小的两个节点，将之组成为一颗子树（小的放左边）
移除原来的两个点
然后将组成的子树放入原来的序列中
重复执行1 2 3直到只剩最后一个点
```

eg:

```
3 4 6 12 20 24 34
6 7 12 20 24 34
12 13 20 24 34
....

        103
   44             59
20d   24b       25      e34
            12g    13  
                 6c  7
                   3a 4f
然后，每个节点的左子树树枝为0，右子树树枝为1，这样，从root到这个节点的路径就是这个数值的哈夫曼编码 
```

实现代码：

```java
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
```


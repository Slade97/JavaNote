package Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class GraphTraversal {
    ListGraph graph;
    boolean[] visited;
    public GraphTraversal(ListGraph listGraph){
        this.graph=listGraph;
        visited=new boolean[listGraph.graphs.size()];
    }

    public void DFS(){
        for (int i = 0; i <graph.graphs.size() ; i++) {
            if(!visited[i]){
                DFSTraversal(i);
            }
        }
    }
    public void DFSTraversal(int v){
        if(visited[v]) return;
        visited[v]=true;
        System.out.print(v+"->");
        Iterator<Integer>neighbors=graph.graphs.get(v).listIterator();
        while (neighbors.hasNext()){
            int nextNode=neighbors.next();
            if(!visited[nextNode]){
                DFSTraversal(nextNode);
            }
        }
    }

    public void BFS(){
        for (int i = 0; i <graph.graphs.size() ; i++) {
            if(!visited[i]){
                BFSTraversal(i);
            }
        }
    }

    private void BFSTraversal(int v) {
        Deque<Integer>queue=new ArrayDeque<>();
        visited[v]=true;
        queue.offerFirst(v);
        while (queue.size()!=0){
            Integer cur=queue.pollFirst();
            System.out.print(cur+"->");
            Iterator<Integer>neighbors=graph.graphs.get(cur).listIterator();
            while (neighbors.hasNext()){
                int nextNode=neighbors.next();
                if(!visited[nextNode]){
                    queue.offerLast(nextNode);
                    visited[nextNode]=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        ListGraph lg=new ListGraph(7);
        lg.addEdge(0,1);
        lg.addEdge(0,2);
        lg.addEdge(1,3);
        lg.addEdge(1,4);
        lg.addEdge(2,5);
        lg.addEdge(2,6);
        GraphTraversal gt = new GraphTraversal(lg);
        gt.BFS();

    }
}

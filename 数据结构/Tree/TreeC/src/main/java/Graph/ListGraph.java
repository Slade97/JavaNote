package Graph;

import java.util.ArrayList;

public class ListGraph {
    ArrayList<ArrayList<Integer>> graphs;
    public ListGraph(int v){
        graphs=new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            graphs.add(new ArrayList<>());
        }
    }
    public void addEdge(int start,int end){
        graphs.get(start).add(end);
    }
    public void removeEdge(int start,int end){
        graphs.get(start).remove((Integer)end);
    }
}

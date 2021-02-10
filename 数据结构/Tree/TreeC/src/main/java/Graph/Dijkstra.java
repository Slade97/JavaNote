package Graph;

import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) {
        int n,m,x;//n为点数，m为边数，x表示我们要的起点
        Scanner cin=new Scanner(System.in);
        n=cin.nextInt();
        m=cin.nextInt();
        x=cin.nextInt();

        int value[][]=new int[n+1][n+1];//表示点到点的邻接矩阵
        int dis[]=new int[n+1];//存最短路径
        for (int i = 1; i <=n ; i++) {
            dis[i]=Integer.MAX_VALUE;
            for (int j = 1; j <=n ; j++) {
                //初始化我们的地图
                value[i][j]=-1;//表示没有路
                if(i==j){
                    value[i][j]=0;
                }
            }
        }
        for (int i = 0; i <m ; i++) {
            int xx= cin.nextInt();
            int yy=cin.nextInt();
            int v=cin.nextInt();
            value[xx][yy]=v;
            //dis其实在第一个点时候可以在这里计算
            if(xx==x){
                dis[yy]=v;
            }
            search(x,dis,value,n);
        }
    }
    public static void search(int x,int dis[],int value[][],int n){
        boolean mark[] =new boolean[n+1];
        mark[x]=true;
        dis[x]=0;
        int count=1;
        while (count<=n){
            int loc=0; //表示新加的点
            int min=Integer.MAX_VALUE;
            for (int i = 1; i <=n ; i++) {
                if(!mark[i]&&dis[i]<min){
                    min=dis[i];
                    loc=i;
                }
            }
            if(loc==0) break;//表示没有可以加的点

            for (int i = 1; i <=n ; i++) {
                //min(dis[3]+data[3][4],dis[4])
                if(value[loc][i]!=-1&&(dis[loc]+value[loc][i]<dis[i])){
                    dis[i]=dis[loc]+value[loc][i];
                }
            }
            count++;
        }
        for (int i = 1; i <=n ; i++) {
            System.out.println(x+"到"+i+"的最短路径为:"+dis[i]);
        }
    }


}

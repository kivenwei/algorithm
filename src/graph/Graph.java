package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	final static int MAX = 65535;  //两个定点之间没有路径时的长度
	int verticts; //顶点数
	int sides;      //顶点为verticts的连通图的边数值
	int[][] arc;//存储图的二维数组
	String[] vex;
	Graph(int verticts){
		this.verticts = verticts;
		this.sides = 0;
		for(int i = verticts-1;i>0;i--){
			this.sides +=i;     //获得连通图的边数值
		}
		this.arc = new int[verticts][verticts];
		this.vex = new String[verticts];
		//初始化一个有向图，所有边设为最大权值（即不可能达到的值）
		for(int i = 0; i < verticts;i++){
			for(int j = 0; j < verticts;j++){
				if(i!=j){
					this.arc[i][j] = MAX;
				}else {
					this.arc[i][j]=0;
				}
			}
		}
	}
	public void addGraph(){
		this.vex[0] = "beijing";
		this.vex[1] = "shanghai";
		this.vex[2] = "tianjing";
		this.vex[3] = "chengdu";
		this.vex[4] = "changsha";
		this.vex[5] = "chongqing";
		for(int i = 1; i < verticts;i++){
			for(int j = 0; j < i;j++){
				int n = (int)(Math.random()*100);    //随机生成权值
				if(n > 0){
					this.arc[i][j]=this.arc[j][i] = n;
				}else if(n == 0){
					this.arc[i][j]=this.arc[j][i] = MAX;
				}
			}
		}
	}
	
	public void printGraph(){
		for(int i = 0; i < verticts;i++){
			if(i == 0){
				System.out.print("*           ");
				for(int x=0;x<verticts;x++){
					System.out.print(this.vex[x]+"  ");
				}
				System.out.println();
				System.out.println("===============================");
			}
				System.out.print(this.vex[i]+"        ");
				for(int j = 0; j < verticts;j++){
					System.out.print(this.arc[i][j]+"        ");
				}
				System.out.println();
				System.out.println();
			}
	}
	public void DFSTraverse(Graph  G){
		boolean[] visited = new boolean[G.verticts];
		for(int i = 0;i < G.verticts;i++){
			visited[i] = false;         //初始状态所有顶点都是未访问过的状态
		}
		for(int i = 0;i < G.verticts;i++){
			if(!visited[i]) {
				DFS(G,i,visited);
			}
		}
	}
	public void DFS(Graph G,int i,boolean[] visited){
		int j;
		visited[i] = true;
		System.out.print(G.vex[i]+"  ");   //打印顶点的值
		for(j = 0;j < G.verticts;j++){
			if(G.arc[i][j]>0 && !visited[j]){
				DFS(G,j,visited);       //对访问的邻接顶点递归调用
			}
		}
	}
	public void BFS(Graph G){
		int i, j;
		Queue<Integer> Q = new LinkedList<Integer>();
		boolean[] visited = new boolean[G.verticts];
		for(i = 0;i < G.verticts;i++){
			visited[i] = false;
		}
		for(i = 0; i < G.verticts;i++){       //对每一个顶点都进行循环
			if(!visited[i]){
				visited[i] = true;
				System.out.print("##"+G.vex[i]+"  ");
				Q.offer(i);
				while(Q != null){
					if(Q.peek() != null){
						i = Q.poll(); //将队首元素赋值给i  然后出队列
					}
					else
					{
						return ;
					}
					for(j = 0;j < G.verticts;j++){
						if(G.arc[i][j] > 0 && !visited[j]){
							visited[j] = true;
							System.out.print("##"+G.vex[j]+"  ");
							Q.offer(j);
						}
					}
				}
			}
		}
	}
	
	public void MiniSpanTree_Prim(Graph G){
		int min, i, j, k;
		int [] adjvex = new int[G.verticts];
		int [] lowcost = new int[G.verticts];
		lowcost[0] = 0;  
		adjvex[0] = 0; 
		for(i = 1;i < G.verticts;i++){
			lowcost[i] = G.arc[0][i];
			adjvex[i] = 0;   
		}
		for(i = 1;i < G.verticts;i++){
			min =  MAX;
			j = 1;
			k = 0;
			while(j < G.verticts){
				if(lowcost[j] != 0 && lowcost[j] < min){
					min = lowcost[j];
					k = j;
				}
				j++;
			}
			System.out.println("("+k+", "+adjvex[k]+")"+"   权长："+G.arc[adjvex[k]][k]);
			lowcost[k] = 0;  
			for(j = 1;j < G.verticts;j++){
				if(lowcost[j] != 0 && G.arc[k][j] < lowcost[j]){
					lowcost[j] = G.arc[k][j]; 
					adjvex[j] = k;  
				}
			}
		}
	}
	
	public void MiniSpanTree_Kruskal(Graph G){
		Edge edge = new Edge();
		edge.Edge_1(G);
		int i, n, m;
		int num = 0;  //记录找到了多少条边
		int parent[] = new int[G.verticts];
		for( i = 0;i < G.verticts;i++){
			parent[i] = 0; 
		}
		for(i = 0;i < G.sides;i++){  
			n = Find(parent,edge.edge[i].begin);
			m = Find(parent,edge.edge[i].end);
			if(n != m ){ 
				parent[n] = m;
				System.out.println("("+edge.edge[i].begin+","+edge.edge[i].end+")"+"  权长："+edge.edge[i].weight);
				num++;
			}
			if(num >= G.verticts)  break;
		}
	}
	public int Find(int[] parent,int f){
		while(parent[f] > 0){
			f = parent[f];
		}
		return f;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(6);  //创建一个顶点个数为6的图
		graph.addGraph();
		System.out.println("将图以二维矩阵的方式输出");
		graph.printGraph(); 
		System.out.println("深度优先搜索结果");
		graph.DFSTraverse(graph); 
		System.out.println();
		System.out.println("广度优先搜索结果");
		graph.BFS(graph);
		System.out.println("最小生成树之普利姆算法Prim  ");
		graph.MiniSpanTree_Prim(graph);
		System.out.println("最小生成树之克鲁斯卡尔算法Kruskal   ");
		graph.MiniSpanTree_Kruskal(graph);
	}
	

}

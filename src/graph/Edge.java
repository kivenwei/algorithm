package graph;

public class Edge {
	public int begin;           //这两个顶点的开始顶点
	public int end;             //这两个顶点的结束顶点
	public int weight;          //两个顶点之间的权值
	Edge edge[] = new Edge[15]; //edge数组  图的边数没有传入，计算最大值
	Edge(){}
	public void Edge_1(Graph G){
		DFSTraverse_1(G);       //得到edge数组
		sortEdge();             //对dege进行排序
	}
	
	public void SetEdge(int begin,int end,int weight){
		this.begin = begin;
		this.end = end;
		this.weight = weight;
	}
	int k=0;        //用于数组赋值是计数
	public void  DFS_1(Graph G,int i,boolean[] visited){
		int j;
		visited[i] = true;
		for(j = 0;j < G.verticts;j++){
			if(G.arc[i][j]>0 && !visited[j]){
				DFS_1(G,j,visited);       //对访问的邻接顶点递归调用
			}
			if(G.arc[i][j] > 0  && i > j){
				this.edge[this.k] = new Edge();
				edge[this.k].SetEdge(j,i,G.arc[i][j]);
				this.k++;
			}
		}
	}
	public void DFSTraverse_1(Graph  G){
		boolean[] visited = new boolean[G.verticts];
		for(int i = 0;i < G.verticts;i++){
			visited[i] = false;         //初始状态所有顶点都是未访问过的状态
		}
		for(int i = 0;i < G.verticts;i++){
			if(!visited[i])
				DFS_1(G,i,visited);       //对未访问过的顶点调用DFS  如果是连通图，则只会执行一次
		}
	}
	public void sortEdge(){
		Edge newEdge = new Edge();
		newEdge.edge[0] = new  Edge();
		for(int i = 0;i < this.edge.length;i++){
			for(int j =  i;j < this.edge.length;j++){
				if(this.edge[i].weight > this.edge[j].weight){
					newEdge.edge[0] = this.edge[i];
					this.edge[i] = this.edge[j];
					this.edge[j] = newEdge.edge[0];
				}
			}
		}
	}
	public void PrintEdge(){
		for(int i = 0; i < this.edge.length;i++){
			System.out.println("数组"+i+":    "+this.edge[i].begin+"  "+this.edge[i].end+"  "+this.edge[i].weight);
		}
	}

}

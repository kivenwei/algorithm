package algorithm;


public class TestGraph {
	
	private char[] vertexs;
	private int[][] medges;
	
	private int getPos(char ch){
		for(int i = 0; i < vertexs.length; i++){
			if(vertexs[i] == ch){
				return i;
			}			
		}
		return -1;
	}
	
	public TestGraph(char[] vers, char[][] edges){
		int vdot = vers.length;
		int vedge = edges.length;
		
		vertexs = new char[vdot];
		for(int i = 0; i < vertexs.length; i++){
			vertexs[i] = vers[i];
		}
		medges = new int[vdot][vdot];
		for(int i = 0; i < vedge; i++){
			int p1 = getPos(edges[i][0]);
            int p2 = getPos(edges[i][1]);
            medges[p1][p2] = 1;
            medges[p2][p1] = 1;
		}
		
	}
	
	private  int firstVertex(int v){
		if(v < 0 || v > (vertexs.length -1)){
			return -1;
		}
		for(int i = 0; i < vertexs.length; i++){
			if(medges[v][i] == 1){
				return i;
			}
		}
		return -1;
	}
	
	private int nextVertex(int v, int w){
		if(v < 0 || v > (vertexs.length -1) || w < 0 || w > (vertexs.length -1)){
			return -1;
		}
		for(int i = w + 1; i < vertexs.length; i++){
			if(medges[v][i] == 1){
				return i;
			}
			
		}
		return -1;
	}
	
	private void DFS(int i, boolean[] visited){
		visited[i] = true;
        System.out.printf("%c ", vertexs[i]);
        for (int w = firstVertex(i); w >= 0; w = nextVertex(i, w)) {
            if (!visited[w])
                DFS(w, visited);
        }
	}
	
	public void DFS(){
		boolean[] visited = new boolean[vertexs.length];  
		for (int i = 0; i < vertexs.length; i++)
            visited[i] = false;
		System.out.printf("DFS: ");
        for (int i = 0; i < vertexs.length; i++) {
            if (!visited[i])
                DFS(i, visited);
        }
        System.out.printf("\n");
	}
	
	public void print(){
		for(int i = 0; i < vertexs.length; i++){
			for(int j = 0; j < vertexs.length; j++){
				System.out.printf("%d ", medges[i][j]);
			}
			System.out.printf("\n");
		}
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
        char[] vexs = {'A','B','C','D','E','F','G'};
        char[][] edges = new char[][]{
        	{'A','C'},
        	{'A','D'},
        	{'A','F'},
        	{'B','C'},
        	{'C','D'},
        	{'E','G'},
        	{'F','G'}
        };
        TestGraph pG = new TestGraph(vexs,edges);
        pG.print();
        pG.DFS();
	}

}

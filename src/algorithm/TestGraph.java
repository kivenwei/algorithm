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
	}

}

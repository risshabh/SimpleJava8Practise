package nagarro;

public class RotateMatrix {

	static void rotateMatrix(int n,int mat[][]){
		for(int x=0;x<n/2;x++){
			for(int y=x;y<n-x-1;y++){
				int temp=mat[x][y];
				mat[x][y]=mat[y][n-1-x];
				mat[y][n-1-x]=mat[n-1-x][n-1-y];
				mat[n-1-x][n-1-y]=mat[n-1-y][x];
				mat[n-1-y][x]=temp;
			}
		}
	}

	public static void printMatrix(int n,int mat[][]){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(" "+ mat[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		int n=3;
		//int mat[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int mat[][]={{1,2,3},{5,6,7},{9,10,11},{13,14,15}};
		rotateMatrix(n, mat);
		printMatrix(n, mat);
	}

}

package extras;

public class Solution1 {


	private static int[][] buildMatrix() {

		int [][]tempMatrix = new int[4][5];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				tempMatrix[i][j] = 1;
			}
		}
		
		tempMatrix[0][2] = 0;
		tempMatrix[0][4] = 0;
		tempMatrix[1][0] = 0;
		tempMatrix[1][4] = 0;
		tempMatrix[2][4] = 0;
		tempMatrix[3][0] = 0;
		return tempMatrix;
	}
	
	
	
	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}
		
	}
	
	
	public static int maxRectangle(int[][] m) {
		int[][] cache = new int[m.length][m[0].length];
		int k=0;

		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[i].length; j++) {
				
				if(m[i][j] == 1) {
					int maxN = 0;
					
					if(m[i-1][j] > m[i-1][j-1]) {
						if(m[i-1][j] > m[i][j-1]) {
							maxN = m[i][j-1];
						}else {
							maxN = m[i-1][j];
						}
					}else {
						maxN = m[i-1][j-1];
					}
				}
				
				
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		
		int[][] matrix = buildMatrix();
		
		printMatrix(matrix);
		maxRectangle(matrix);
	}
	
	
}







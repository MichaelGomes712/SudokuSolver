import java.util.Scanner;

public class Program{

    public static void main(String[] args) {
        /*Inputting grid */
        int grid[][] = new int[9][9];
        Scanner in = new Scanner(System.in);
        for (int k=0;k<9;k++){
            String line = in.nextLine();
            String nums[] = line.split(" ");
            for (int i=0;i<9;i++){
                grid[k][i]= Integer.parseInt(nums[i]);
            }
        }

        /*Solving grid */
	Timer myTimer=new Timer();
	myTimer.start();
        boolean solve = solve(grid,grid.length);
	myTimer.stop();

        if(solve){
            print(grid);
        }else{
            System.out.println("No solution");
        }
	System.out.println("Time: " + String.valueOf(myTimer.getTime()));
    }

    public static boolean solve(int grid[][], int n){
        // int solved[][] = grid;
        int row = -1 , col = -1;
        boolean flag = true;
        for (int i = 0; i<n;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==0){
                    row = i;
                    col = j;
                    flag = false;
                    break;
                }
            }
            if (!flag){
                break;
            }
        }

        if(flag){
            return true;
        }else{
            for (int value = 1; value <= n; value++) { 
                if (validState(grid, row, col, value)) { 
                    grid[row][col] = value; 
                    if (solve(grid, n)) { 
                        return true; 
                    }else { 
                        grid[row][col] = 0; 
                    } 

                } 
            } 
        }
        return false; 
    }

    public static boolean validState(int[][] grid, int row, int col, int n){
        int len = grid.length;
        for (int i=0;i<len;i++){
            if (grid[row][i] == n || grid[i][col] == n){
                return false;
            }
        }

        int sqrtLen = (int)Math.sqrt(len); 
        int StartRow3x3 = row - row % sqrtLen; 
        int StartCol3x3 = col - col % sqrtLen; 
  
        for (int k = StartRow3x3; k < StartRow3x3 + sqrtLen; k++) { 
            for (int l = StartCol3x3;l < StartCol3x3 + sqrtLen;l++) { 
                if (grid[k][l] == n) { 
                    return false; 
                } 
            } 
        } 
  
        return true; 
    }


    public static void print(int[][]grid){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.io.FileWriter;
import java.util.Stack;
import java.lang.Math;
public class Program{
	void PrintGrid(char grid[][])
	{
		for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
	}

	boolean IsInValidState(char grid[][],int row,int col){
	    int r = row;
	    int c = col;
	    if(grid[r][c]=='0'){
		return false;
	    }
	    for (int m=0;m<9;++m){
		if (grid[r][m]==grid[r][c] && m!=c){
		    return false;
		}
	    
		else if (grid[m][c]==grid[r][c] && m!=r){
		    return false;
		}
	    }
		int k = 9;
		int X_0=(int) (r/3)*3;
	    int Y_0=(int) (c/3)*3;
		for (int i=0;i<3;++i){
	        for (int j=0;j<3;++j){
	            if (grid[X_0+i][Y_0+j]==grid[r][c] &&!(X_0+i == r && Y_0+j == c)){
	                return false;
	            }
	        }
	    }
	    return true;
	}
  

	void solveSudoku(char grid[][]){
		Timer myTimer=new Timer();
		myTimer.start();
		Stack<Integer> sRow = new Stack<Integer>();
		Stack<Integer> sCol = new Stack<Integer>();
		Stack<Character> sValue = new Stack<Character>();
		int row = 0;
		int col = 0;
        int val = 0;
       	int shape = 9;
		char cShape = (char) ('0' + (char) shape);
		boolean Print=true;
       	boolean bFinished=false;
		for (int r = 0; r < 9; r++)
		{
			for (int c = 0; c < 9; c++)
			{
			    if (grid[r][c] == '0')
			    {
				bFinished = true;
				row = r;
				col = c;
				break;
			    }
			}
			if (bFinished == true){
                break;
            }
		}
        
        while (bFinished==true ){
          	while (IsInValidState(grid,row,col)==false && grid[row][col]!=cShape){
				char tmp=grid[row][col];
				int itmp=tmp-48;
				itmp=itmp+1;
				tmp=(char) ('0' + (char) itmp);
				grid[row][col]=tmp;
			}
			if (IsInValidState(grid,row,col)){
				sRow.push(row);
				sCol.push(col);
				sValue.push(grid[row][col]);
				bFinished=false;
				for (int r = 0; r < 9; r++)
				{
					for (int c = 0; c < 9; c++)
					{
					    if (grid[r][c] == '0')
					    {
							bFinished = true;
							row = r;
							col = c;
				    		break;
			    		}
					}
					if (bFinished == true){
                		break;
            		}
				}	       
			}
			else if (sValue.empty()){	
				System.out.println("No Solution");
				Print=false;
				bFinished=false;
			}
			else{
				grid[row][col]='0';
				row=sRow.peek();
				col=sCol.peek();
				val=sValue.peek();
				sRow.pop();
				sCol.pop();
				sValue.pop();    
				while (grid[row][col]==cShape){
					grid[row][col]='0';
			        row=sRow.peek();
			        col=sCol.peek();
			        val=sValue.peek();
			        sRow.pop();
			        sCol.pop();
			        sValue.pop(); 
				}
				char tmp=grid[row][col];
		        int itmp=tmp-48;
		        itmp=itmp+1;     
		        tmp=(char) ('0' + (char) itmp);
		        grid[row][col]=tmp;
			}			    
		}
		myTimer.stop();
		if (Print==true){
		    PrintGrid(grid);
		    System.out.println("Time: " + String.valueOf(myTimer.getTime()));
		}
	}
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		//read in data

		char [][] grid = new char[9][9];
		for (int k=0;k<9;k++){
            String line = scanner.nextLine();
            String nums[] = line.split(" ");
            for (int i=0;i<9;i++){
                grid[k][i]= nums[i].charAt(0);
            }
        }

		Program ob = new Program();
		ob.solveSudoku(grid);
	}	
}

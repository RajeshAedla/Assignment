package package1;

import java.util.Random;
import java.util.Scanner;

public class Assignment1 
{
	    public static void main(String[] args)
	    {
	    	Scanner sc=new Scanner(System.in);
	    	//for grid Size
	    	System.out.println("Enter the Grid in M X N format ");
	    	System.out.println("Enter M(Number of Rows)");
	    	int M = sc.nextInt();
	    	System.out.println("Enter N(Number of Columns");
	    	int N = sc.nextInt();
	        
	        int grid[][] = new int[M][N];
	        
	        Random rand = new Random();
	        int z = 0;
	        int x = 0;
	        for(int i=0; i < grid.length ; i++)
	        {
	        	for(int j = 1 ; j < grid[i].length ; j++ )
	        	{
	        		grid[i][j] = rand.nextInt(2);

	                if (grid[i][j] == 0) {
	                    z++;
	                }
	                if (grid[i][j] == 1) {
	                    x++;
	                }
	        	}
	        }
	        // Displaying the grid
	        System.out.println("Original Generation");
	        for (int i = 0; i < M; i++)
	        {
	            for (int j = 0; j < N; j++)
	            {
	                if (grid[i][j] == 0)
	                    System.out.print("-");
	                else
	                    System.out.print("#");
	            }
	            System.out.println();
	        }
	        System.out.println();
	        nextGeneration(grid, M, N);
	    }
	  
	    // Function to print next generation
	    static void nextGeneration(int grid[][], int M, int N)
	    {
	        int[][] future = new int[M][N];
	  
	        // Loop through every cell
	        for (int l = 1; l < M - 1; l++)
	        {
	            for (int m = 1; m < N - 1; m++)
	            {
	                // finding no Of Neighbours that are alive
	                int aliveNeighbours = 0;
	                for (int i = -1; i <= 1; i++)
	                    for (int j = -1; j <= 1; j++)
	                        aliveNeighbours += grid[l + i][m + j];
	  
	                // The cell needs to be subtracted from
	                // its neighbours as it was counted before
	                aliveNeighbours -= grid[l][m];
	  
	                // Implementing the Rules of Life
	  
	                // Cell is lonely and dies
	                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
	                    future[l][m] = 0;
	  
	                // Cell dies due to over population
	                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
	                    future[l][m] = 0;
	  
	                // A new cell is born
	                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
	                    future[l][m] = 1;
	  
	                // Remains the same
	                else
	                    future[l][m] = grid[l][m];
	            }
	        }
	  
	        System.out.println("Next Generation");
	        for (int i = 0; i < M; i++)
	        {
	            for (int j = 0; j < N; j++)
	            {
	                if (future[i][j] == 0)
	                    System.out.print("-");
	                else
	                    System.out.print("#");
	            }
	            System.out.println();
	        }
	    }
}

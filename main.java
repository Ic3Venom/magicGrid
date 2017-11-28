package magic_numbers;

import java.util.*;

public class main
{
    public static void main(String[] args)
    {
        System.out.println("Testing");
        int[][] grid = new int[3][3];
        
        for(int i = 0; i < 1000000; i++)
        {
            grid = generateGrid(3);
            
            if(isMagic(grid) == true)
            {
                System.out.printf("Found magic grid after %d iterations", i);
                printGrid(grid);
                
                System.exit(0);
            }
        }
        System.out.println("Could not find magic grid");
    
    }

    public static int[][] generateGrid(int len)
    {
        Random rand = new Random(System.currentTimeMillis());
        ArrayList<Integer> choices = new ArrayList<Integer>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        
        int[][] grid = new int[len][len];
        
        for(int i = 0; i < len; i++)
        {
            for(int j = 0; j < len; j++)
            {
                int index = (int)(rand.nextDouble() * choices.size())
                grid[i][j] = choices.get(index);
                choices.remove(index);
                choices.trimToSize();
            }
        }
        
        return grid;
    }

    public static boolean isMagic(int[][] grid)
    {
    
        int test = 0;
        int base = 0;

        for(int i = 0; i < grid[0].length; i++)
        {
            base += grid[0][i];
        }
        
        // Horizontal
        for(int i = 0; i < grid.length; i++)
        {
            test = 0;
            
            for(int j = 0; j < grid[i].length; j++)
            {
                test += grid[i][j];
            }
            
            if( test != base )
            {
                return false;
            }
        }
        
        // Vertical
        for(int i = 0; i < grid.length; i++)
        {
            test = 0;
            
            for(int j = 0; j < grid[i].length; j++)
            {
                test += grid[j][i];
            }
            
            if( test != base )
            {
                return false;
            }
        }
        
        // Diagional
        for(int i = 0; i < grid.length; i++)
        {
            test = 0;
            
            for(int j = grid.length -1; j >= 0; j--)
            {
                test += grid[i][j];
            }
      
            if( test != base )
            {
                return false;
            }
        }
        
        for(int i = 0; i < grid.length; i++)
        {
            test += grid[i][i];
            
            if( test == base )
            {
                return false;
            }
        }
        
        return true;
    }
    
    public static void printGrid(int[][] grid)
    {
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

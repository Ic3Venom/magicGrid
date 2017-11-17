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

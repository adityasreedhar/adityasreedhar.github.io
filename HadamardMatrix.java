public class HadamardMatrix {
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        boolean[][] mat = new boolean[n][n];

        mat[0][0] = true;
        for (int index = 1; index < n; index += index)
        {
            
            for (int i = 0; i < index; i++)
            {
               
                for (int j = 0; j < index; j++)
                {
                   
         mat[i+index][j]   =  mat[i][j];
          mat[i][j+index]   =  mat[i][j];
         mat[i+index][j+index] = !mat[i][j];
                }
            }
        }
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (mat[i][j])
                    System.out.print("T ");
                else
                    System.out.print("F ");
            }
            System.out.println();
        }
    }

}

public class Ordered {

	public static void main (String[] args) {

		int w = Integer.parseInt(args[0]);
        int x = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        int z = Integer.parseInt(args[3]);

      boolean a = true; 
      a = (w < x && w < y && w < z);
      boolean c = true; 
      c = (w > x && w > y && w > z);

      boolean result;

      result = a || c ;

      System.out.println(result);
      

     
     





	
	
		}


	}
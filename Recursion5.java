public class Recursion5{

	public static void main (String[] args) {

		StdOut.print("How many numbers");
	    int a = StdIn.readInt();

	    float [] array = new float[a];
	    float sum = 0;  

    for (int i=0; i<a ;i++){
    	StdOut.print("Enter your numbers");
        float b = StdIn.readFloat();

        array[i]=b;
        sum+=array[i];

    }

    	System.out.println("average= "sum/a);


    





	}






}
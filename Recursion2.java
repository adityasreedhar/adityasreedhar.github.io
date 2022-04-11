public class Recursion2 {

	public static int getTriangular(int number){

		System.out.println("Method " + number);

		if(number==1){

			System.out.println("Retuned 1 ");

			return 1;

		}

		else{

			int result = number + getTriangular(number-1);
			System.out.print("Returned " + result);
			System.out.println(":" + number+" +getTN( " + number );

			return result;
		}


	}

	public static void main (String[] args) {

		

		System.out.println(getTriangular(6));



		}

}
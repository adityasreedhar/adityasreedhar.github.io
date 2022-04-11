public class Recursion3 {

public static void main (String[] args) {

System.out.println(Fibonacci(3));

	}


public static int Fibonacci(int number){
	if (number==1){

		return 1;

	}
	else{

		int result = number+Fibonacci(number-1);
		return result;



	}



}
}


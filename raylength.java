public class raylength {


public static boolean eq(int[]a, int[]b){
	if(a.length==b.length){
		for(int i=0;i<a.length;i++){
			if (b[i]!= a[i]){
				return false;
			}

		}
		
	} else {
		return false;
	}
	return true;



}

public static void main (String[] args) {

	int a[]={1,2,3,4};
	int b[]={1,2,3,4,5};
	System.out.println(eq(a,b));



	}

}
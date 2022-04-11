public class TwoSmallest {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Error");


        } else {
            double min1 = Double.parseDouble(args[0]);
            double min2 = Double.parseDouble(args[1]);
            double num;
            double sum;


           

            for (int a = 2; a < args.length; a++) {
                num = Double.parseDouble(args[a]);
                if (num < min1) {
                    min2 = min1;
                    min1 = num;
                } else if (num < min2) {
                    min2 = num;
                }

            }



            System.out.println(min1);
            System.out.println(min2);
        }
    }
}
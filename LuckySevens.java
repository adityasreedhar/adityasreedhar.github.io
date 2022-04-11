public class LuckySevens {

    public static void main(String[] args) {
        if (args.length > 0) {

            int counter = 0;
            int number = Integer.parseInt(args[0]);



            while (number > 0) {
                if ((number % 10) == 7) {
                    ++counter;
                }

                number /= 10;

            }
            System.out.print(counter);
        }
    }
}

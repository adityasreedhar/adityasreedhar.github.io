
public class TrainTicket
{
   public static void main(String[] args) {
      
       if(args.length==2)
       {
           int age;
           boolean area;

           age=Integer.parseInt(args[0]); 
           area=Boolean.parseBoolean(args[1]); 
           if(age<0 || age>120)
           {
                System.out.println("Illegal Input");
                System.exit(1);
           }
           if(age<7)
           {
                System.out.println("free");
           }
           else if(area)
           {
                if(age>=65)
                {
                    System.out.println("7.50");
                }
                else
                {
                    System.out.println("13.20");
                }
           }
           else
           {
                if(age>=65)
                {
                    System.out.println(7.50+7.50*0.20);
                }
                else
                {
                    System.out.println(13.20+13.20*0.20);
                }
              
           }
       }
       else
       {
            System.out.println("Error");
       }
   }
}
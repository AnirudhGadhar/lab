import java.util.Scanner;

public class knapsack{
    
        public static void main (String args[])
        {
            int i,j=0,max_qty,m,n;
            float sum=0,max=0;
            int array[][] = new int[2][20];
            Scanner sc = new Scanner(System.in);
            System.out.println("enter the no of the elements");
             n = sc.nextInt();
            System.out.println("enter the weight of each item");
            for( i=0; i<n; i++)
            array[0][i] = sc.nextInt();
            System.out.println("enter the profit of each time");
            for( i=0; i<n; i++)
             array[1][i] = sc.nextInt();
             System.out.println("enter the volume of the knapsack");
             max_qty = sc.nextInt();

             m=max_qty;

             while(m>=0)
             { 
                 max=0;
                for(i=0; i<n; i++)
                 {
                    if(((float)array[1][i])/((float)array[0][i])>max)
                          {
                    max=(float)array[1][i]/(float)array[0][i];
                    j=i;
                          }

                    }
                  if(array[0][j]>m)
                 {
                    System.out.println("quantity of item number is" + (j+1) + " added is " + m);
                    sum+=m*max;
                    m=-1;

                 }

                  else
                  {
                    System.out.println("quantity of item number is" + (j+1) + " added is " + array[0][j]);
                    m-=array[0][j];
                    sum+=(float)array[1][j];
                    array[1][j]=0;

                  }

             } 
             System.out.println("the total profit is " + sum);
             sc.close();
        }
    
}
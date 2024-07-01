import java.util.Scanner;
import java.util.Random;

public class merge{
                       static int max=30000;
                       void merge(int array[],int low, int mid, int high)
                       {
                        int i=low;
                        int j = mid+1;
                        int k=low;
                        int resarray[]= new int[max];

                        while(i<=mid && j<=high)
                        {
                            if(array[i]<array[j])
                            {
                                resarray[k]=array[i];
                                i++;
                                k++;
               
                            }

                            else
                            {
                                resarray[k]=array[j];
                                j++;
                                k++;
                            }
                        }
                        while(i<=mid)
                         resarray[k++]=array[i++];
                         while(j<=high)
                          resarray[k++]=array[j++];
                          for(int m=low; m<=high; m++)
                          array[m]=resarray[m];
                       }

                       void sort(int array[],int low, int high)
                       {
                           if(low<high)
                        {
                            int mid=(low+high)/2;
                            sort(array,low,mid);
                            sort(array,mid+1,high);
                            merge(array,low,mid,high);

                        }
                       }








    public static void main(String args[])
    {
         int array[]=new int[max];
         
        System.out.println("enter the size of array");
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         Random r = new Random();
         for(int i=0; i<n; i++)
         array[i]=r.nextInt(20);
         System.out.println("array before sorting");
         for(int i=0; i<n; i++)
          System.out.println(array[i] + " ");
          long starttime = System.nanoTime();
          merge m =new merge();
          m.sort(array,0,n-1);
          long stopttime= System.nanoTime();
          System.out.println("array after sorting");
          for(int i=0; i<n; i++)
           System.out.println(array[i] + " ");
           long elapsetime= (stopttime-starttime);

            System.out.println("time taken for exceution is " + elapsetime + "nanoseconds");
    }
}
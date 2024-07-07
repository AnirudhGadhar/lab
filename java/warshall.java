import java.util.Scanner;

public class warshall
{
    void warshall(int w[][], int n)
    {
        int i,j,k;
        for(k=1; k<=n; k++)
        for(i=1; i<=n; i++)
        for(j=1; j<=n; j++)
        if(w[i][k]==1 && w[k][j]==1)
        w[i][j]=1;
        else
        w[i][j]=w[i][j];

    }
    public static void main(String [] args)
    {
        int i,j,k;
        Scanner sc=new Scanner(System.in);
        int a[][]=new int[10][10];

        System.out.println("enter the number of elements");
        int n = sc.nextInt();
        System.out.println("enter the adjajnancey matrix");
         for(i=1; i<=n; i++)
        for(j=1; j<=n; j++)
        a[i][j]=sc.nextInt();
        warshall f= new warshall();
        f.warshall(a,n);
        System.out.println("the transtive closure of diagraph is");
        for(i=1; i<=n; i++)
        {
             for(j=1; j<=n; j++)
             {
                System.out.print(a[i][j] + "");

             }
             System.out.println();
        }
    }
}
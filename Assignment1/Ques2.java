import java.util.*;
public class Ques2 {
    public static void unique(HashMap<Integer,Integer>h,int[] a,int n)
    {
        for(int i=0;i<n;i++)
        {
                h.put(a[i],1);
        }
        for(Map.Entry<Integer,Integer>e:h.entrySet())
        {
                System.out.print(e.getKey()+" ");
        }
 
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HashMap<Integer,Integer>h=new HashMap<>();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        sc.close();
        unique(h,a,n);
       
    }
}

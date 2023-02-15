import java.util.*;
public class Ques1 {
    public static List<Integer>Missing(int n,int mx,int[] a,int[] present,List<Integer>l)
    {
        for(int i=0;i<n;i++)
        present[a[i]-1]=1;
        for(int i=0;i<mx;i++)
            {
                if(present[i]==0)
                    l.add(i+1);
            }  
            return l;   
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Integer>l=new ArrayList<Integer>();
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int mx=a[0];   
        for(int i=1;i<n;i++)
        {
            if(mx<a[i]);
                mx=a[i];
        }    
        int present[]=new int[mx];
        System.out.println(Missing(n,mx,a,present,l));
       
    }    
}

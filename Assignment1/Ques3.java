import java.util.*;
public class Ques3 {
    static Scanner sc=new Scanner(System.in);
    public static void get_product(HashMap<String,List<Object>>product,int n,List<Object> l)
    {
        System.out.println("Enter details of "+n+" products details");
        for(int i=0;i<n;i++)
        {
        String id=sc.next();
        String name=sc.next();
        int cost=sc.nextInt();
        int count=sc.nextInt();
        l.add(name);
        l.add(cost);
        l.add(count);
      
        product.put(id,new ArrayList<Object>(l));
      
        l.clear();
        }
    }
    public static void Viewproducts(HashMap<String,List<Object>>product,int n)
    {
        System.out.println("List of the products are ");
        for(Map.Entry<String,List<Object>>e:product.entrySet())
        {
        System.out.print(e.getValue().get(0)+" ");
        }
       System.out.println();
       System.out.println("********************************");
    }
    public static void product_count(HashMap<String,List<Object>>product,String s)
    {
       
            System.out.println("product_Id\tProduct\t\tcount");
            System.out.println(s+"\t\t"+product.get(s).get(0)+"\t\t"+product.get(s).get(2));
           
        
    }
    public static void product_details(HashMap<String,List<Object>>product,String s)
    {
       
        for(Map.Entry<String,List<Object>>e:product.entrySet())
        {
            
            if(s.equals(e.getKey()))
            {
            System.out.println(e.getKey()+"\t\t"+e.getValue().get(0)+"\t\t"+e.getValue().get(1)+"\t"+e.getValue().get(2));
            break;
            }    
        } 
    }
    public static void Edit_details(HashMap<String,List<Object>>product,List<Object> l)
    {
        
        System.out.println("Enter the respective product Id");
        String s=sc.next(); 
        editcost(product, s, l);
        System.out.println(s+" "+product.get(s).get(0)+" "+product.get(s).get(1)+" "+product.get(s).get(2));
        System.out.println("*******************************************");
       
    }
    public static void editcost(HashMap<String,List<Object>>product,String s,List<Object> l) 
    {
        System.out.println("Enter the new cost of "+s+"");
        int new_cost=sc.nextInt();
        l=product.get(s);
        l.set(1,new_cost);
        product.put(s,l);

    }
    public static void add_count(HashMap<String,List<Object>>product,String s, List<Object> l)
    {
        System.out.println("Enter the  count to be added "+s+"");
        int new_count=sc.nextInt();
        
        l=product.get(s);
         new_count+=(int)l.get(1);
        l.set(2,new_count);
        product.put(s,l);
    }
    public static void delete_count(HashMap<String,List<Object>>product,String s, List<Object> l)
    {
        System.out.println("Enter the  Quantity to be removed "+s+"");
        int new_count=sc.nextInt();
        
        l=product.get(s);
         new_count=(int)l.get(1)-new_count;
        l.set(2,new_count);
        product.put(s,l);
    }
    public static void update(HashMap<String,List<Object>>product,String s,List<Object> l)
    {
       
        while(true)
        {
            System.out.println("Choose an option:\n1.Add count\n2.Delete count\n3.Exit");
            int c=sc.nextInt();
            switch(c)
            {
            case 1:add_count(product,s,l);
                    break;
            case 2:delete_count(product,s,l);
                    break;
            case 3: break;        
            default:System.out.println("Please select a valid choice");                
            }

        if(c==3)
            break;
        }
        System.out.println("*********Updated List**********");
        System.out.println("product Id\tproduct name\t cost\t count");
        for(Map.Entry<String,List<Object>>e:product.entrySet())
            {
            System.out.println(e.getKey()+"\t\t"+e.getValue().get(0)+"\t\t"+e.getValue().get(1)+"\t"+e.getValue().get(2));
            } 

    }

    public static void main(String[] args) {
        
        HashMap<String,List<Object>>product=new HashMap<>();
        List<Object> l=new ArrayList<Object>();
        System.out.println("Enter the Number of products");
        int n=sc.nextInt();
        String s;
        get_product(product,n,l);
        while(true){
        System.out.println("Choose an option:\n 1Product List.\n2.Product count\n3.Product details\n4.Edit Product\n5.Update Inventory\n6.Exit");
        int ch=sc.nextInt();
        switch(ch)
        {
        case 1:Viewproducts(product,n);
                break;
        case 2:  System.out.println("Enter the product id ");
                s=sc.next();
                product_count(product,s);
                break;
        case 3: 
                System.out.println("Enter the product id :");
                 s=sc.next();
                 System.out.println("**********Product details**************");
                 System.out.println("product Id\tproduct name\tcost\tcount");
                product_details(product,s);
                
                break;
        case 4:
                
                Edit_details(product,l);
                break;

        case 5:System.out.println("Enter the product id :");
                s=sc.next();
               update(product,s,l);
                break;
        case 6:
                break;
        default:System.out.println("Enter a valid choice");

        }
        if(ch==6)
            break;
        }
    }
}

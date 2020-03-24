package producentmulti;

import java.util.*;
import java.util.concurrent.*;
 

public class Producer implements Runnable {
    private Product msg;
    private int clients;
    ArrayList<Product> products;
   
    public Producer(int clients, ArrayList<Product> products) {
		this.clients = clients;
                this.products = products;
	}
    
    @Override
    public void run()
    {
        
            for(int i=0;i<clients;i++){
                
                    try {
                        produce(new Product("Product",i));
                    } catch (Exception e) { 
                       e.printStackTrace(); }
            }
    }

     public void produce(Product e) throws InterruptedException
{
    synchronized(products)
    {   
        Random r = new Random();
        System.out.println("Produced :"+ e.getId());
        products.add(e);
        products.notifyAll();
        
        Thread.sleep( r.nextInt(1000) );
    }
}
}
            
        
    
   
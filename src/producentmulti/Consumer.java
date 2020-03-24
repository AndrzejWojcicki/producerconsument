
package producentmulti;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable {

    
    ArrayList<Product> products;
    private int id;
    public Consumer(ArrayList<Product> products , int id) { 
        this.products = products; 
        this.id = id;
    }
    @Override
    public void run()
    {
        String name = Thread.currentThread().getName();
        System.out.println( name+" oczekiwanie na produkt");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
           ex.printStackTrace();
        }
        
            try {
                consume(products,id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
    }
    public void consume(ArrayList<Product> products,int id) throws InterruptedException
    {
        synchronized(products)
    {   boolean pass = false;
        Product product;
        while(pass == false){
            for(Iterator<Product>it = products.iterator();it.hasNext();){
                product = it.next();
                if(id == product.getId()){
                    it.remove();
                    pass=true;
                    System.out.println("Consumed :"+id);
                    try{
                        products.notifyAll(); 
                        
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
            
        }  
    }    
    }
}

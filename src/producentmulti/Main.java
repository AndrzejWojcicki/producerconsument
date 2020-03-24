/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producentmulti;

import java.util.ArrayList;

/**
 *
 * @author ANDRZEJ
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
         ArrayList<Product> products = new ArrayList<Product>();
         int consumers = 0;
         Thread producer = new Thread(new Producer(10,products) , "Producer");
        
       
         for (int i=0;i<10;i++){
           Thread consumer = new Thread(new Consumer(products,i) , "Consumer: "+i);  
           consumer.start(); 
           
           consumers++;
          
         }
         producer.start(); 
        
        
        
    }
            

        

    }
    


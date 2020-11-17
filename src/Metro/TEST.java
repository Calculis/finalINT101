/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metro;

/**
 *
 * @author phunon
 */
public class TEST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Customer c1 = new Customer(500);
        c1.register("Phunon");
        
        System.out.println(c1);
        
        c1.addMoneytoCard(200);
        c1.Go();
        System.out.println(c1);
        c1.Go();
        
        System.out.println(c1);
 
    }
    
}

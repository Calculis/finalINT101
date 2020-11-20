/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metro;
import java.util.Arrays;
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
        ticketMachine tm=new ticketMachine(1);
        tm.mainMenu();
        System.out.println(Arrays.toString(memberDatabase.getMemberList()));
    

       
    }
    
}

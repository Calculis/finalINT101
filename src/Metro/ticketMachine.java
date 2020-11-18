/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metro;

import java.util.Scanner;

/**
 *
 * @author phunon
 */
public class ticketMachine {

    private final Scanner scan = new Scanner(System.in);
    private final station currentStation;
    private double remainingMoney = 10000;
    private Membercard Mcard;

    public ticketMachine(int noStation) {
        this.currentStation = station.values()[noStation];
    }

    public void mainMenu() {
        boolean status = true;
        while (status) {
            System.out.println("------Welcome to "+currentStation+" Station------");
            System.out.println("[Press 1 to purchase]");
            System.out.println("[Press 2 to Membercard]");
//            System.out.println("Press 0 to shutdown");
            System.out.print("Your choice:");
            switch (scan.nextInt()) {
                
                case 1:
                    priceCalculated pc = new priceCalculated(); // รวมเป็นอีก method
                    pc.allDestination();
                    int choose = pc.chooseStation();
                    if (choose < 0 || choose==getCurrentStationIndex()) {
                        System.out.println("Error!");
                        break;
                    } else {
                        System.out.println("How many ticket do you want to buy?");
                        int noTicket = scan.nextInt();
                        noTicket=noTicket>0? noTicket:1;
                         double price=pc.calculatePrice(this.getCurrentStationIndex(), choose)*noTicket;
                        System.out.println("Total price:"+price+" Please choose your payment method");
                        System.out.println("[Press 1 to pay with card]");
                        System.out.println("[Press 2 to pay with cash]");
                        System.out.println("[Press 3 to cancel]");
                        int choice = scan.nextInt();
                       
                        switch (choice) {
                            case 1:
                                System.out.println("Please insert cardId");
                                String cardId= scan.next();;      
                                payCard(cardId,price);
                                break;
                            case 2:
                                payCash(price);
                                break;
                            case 3: mainMenu();
                                break;
                            default:
                                System.out.println("Something went wrong");
                                
                        }
                    }

                  
                    
                case 2:
                    System.out.println("[Press 1 to register]");
                    System.out.println("[Press 2 to add money]");
                    System.out.println("[Press 3 to check balance]");
                    System.out.println("[Press 0 to go back]");
                    switch(scan.nextInt()){
                        case 1: 
                            System.out.println("Please input your name");
                            String name=scan.next();
                            Membercard mc1=new Membercard(name);
                            System.out.println(mc1);
                            break;
                        case 2:
                            System.out.println("Please insert your IDcard:");
                            String id=scan.next();
                            if(Membercard.isExist(id)){
                             System.out.println("Welcome"+ Membercard.getCardById(id).getCardHolder() );
                              System.out.println("Please insert money");
                              int cash=scan.nextInt();
                              Membercard.getCardById(id).addMoney(cash);
                              this.remainingMoney+=cash;
                            }else{
                                System.out.println("This ID is not exist");
                            }
                            break;
                        case 3:
                              System.out.println("Please insert your IDcard:");
                                id=scan.next();
                            if(Membercard.isExist(id)){
                                System.out.println("Your balance "+ Membercard.getCardById(id).toString());
                            }
                            break;
                        case 0:
                            mainMenu();
                            break;
                        default: System.out.println("out of order");
                    }
                    break;
                case 101: status=false; //shutdown
                break;
                case 10: System.out.println(this); //check remainmoney
                break;
                             
            
                   
                        
                
                default:
                    System.out.println("Something went wrong");
            }
        }
    }

    public void payCard(String cardId, double price) {
        
        for (Membercard listCard : Membercard.getListCard()) {

            if (listCard.getIdCard().equals(cardId)) {
                listCard.purchaseTicket(price);

                return;
            }

        }
        System.out.println("Card not found");
        mainMenu();
    }
    public void payCash(double price){
        this.remainingMoney+=price;
        System.out.println("Purchase successfully");
    }
    public station getCurrentStation() {
        return currentStation;
    }

    public int getCurrentStationIndex() {
        for (int i = 0; i < station.values().length; i++) {
            if (this.currentStation == station.values()[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Station:" + this.currentStation + " Remaining money:" + this.remainingMoney;

    }

}

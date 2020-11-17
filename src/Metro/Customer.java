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
public class Customer {

    private double pocketMoney;
    private Membercard card;
    private station currentStation = station.values()[0];
    private ticketMachine ticketMac = new ticketMachine();
    
    public Customer(double pocketMoney) {
        this.pocketMoney = pocketMoney;
        
    }
    
    public Customer(double pocketMoney, Membercard card) {
        this.pocketMoney = pocketMoney;
        this.card = card;
    }
    
    public void register(String name) {
        if (card == null) {
            card = new Membercard(name);
            System.out.println("Register Successfully");
        } else {
            System.out.println("You already have card!");
        }
    }

    public void addMoneytoCard(double cash) {
        if (card != null && pocketMoney >= cash) {
            card.addMoney(cash);
            pocketMoney -= cash;
        } else {
            System.out.println("Add money failed: Something went wrong!");
        }
    }
    

 
     public Membercard getCard() {
        return card;
    }
    public double getPocketMoney() {
        return pocketMoney;
    }
    
    public void addPocketMoney(double pocketMoney) {
        this.pocketMoney += pocketMoney;
    }
    
    public station getCurrentStation() {
        return currentStation;
    }
    
    public void setCurrentStation(int stationNum) {
        this.currentStation = station.values()[stationNum];
    }

    public int getCurrentStationIndex() {
        for (int i = 0; i < station.values().length; i++) {
            if (this.currentStation == station.values()[i]) {
                return i;
            }
        }
        return -1;
    }

    public ticketMachine getTicketMac() {
        return ticketMac;
    }

    public void Go() {
        ticketMac.chooseDestination(this);
    }
    public void showAllStation(){
        ticketMac.allDestination();
    }
       @Override
    public String toString() {        
        return "Customer >> Pocket money:" + pocketMoney + " Baht \n" + card + "\n"
                + "สถานีปัจจุบัน " + currentStation;
    }

    public void setPocketMoney(double pocketMoney) {
        this.pocketMoney = pocketMoney;
    }
    
}

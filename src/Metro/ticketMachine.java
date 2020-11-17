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

    public void chooseDestination(Customer person) {
        allDestination();

        int choose = scan.nextInt();
        if(choose==person.getCurrentStationIndex()){
            System.out.println("You are already in this station");
            return;
        }
        if (choose >= station.values().length || choose < 0) {
            System.out.println("Out of range!");
            return;
        }
        System.out.println("Type 1 : pay with card\nType 2 : pay with cash");
        int choice = scan.nextInt();

        if (choice == 2) {
            byCash(person, choose);
        } else if (choice == 1) {
            byCard(person, choose);
        } else {
            System.out.println("Buying reject:Something went wrong");
        }

    }

    private double calculatePrice(int from, int to) {
     
            int number = Math.abs(from - to);
            return 4 * number + 7;
        
    }

    public void allDestination() {
        for (int i = 0; i < station.values().length; i++) {
            System.out.println("กด " + i + " ไป " + station.values()[i]);
        }
    }

    private void byCash(Customer person, int choose) {
        double price = calculatePrice(person.getCurrentStationIndex(), choose);
        if (person.getPocketMoney() > price) {

            System.out.println("-----You got temporary ticket to go to " + station.values()[choose] + "-----");
            person.setPocketMoney(person.getPocketMoney() - price);
            System.out.println("total_price:" + price + " Baht");
            person.setCurrentStation(choose);

        } else {
            System.out.println("Something went wrong!");
        }
    }

    private void byCard(Customer person, int choose) {
        if (person.getCard() == null) {
            System.out.println("You don't have membercard!");
            return;
        }
        double price = calculatePrice(person.getCurrentStationIndex(), choose);
        if (person.getCard().getRemainMoney() >= price) {
            System.out.println("-----Access complete you can go to " + station.values()[choose] + "-----");
            person.getCard().purchaseTicket(price);
            System.out.println("total_price:" + price + " Baht");
            person.setCurrentStation(choose);
        } else {
            System.out.println("Something went wrong");
        }

    }

}

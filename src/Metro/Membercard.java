package Metro;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author phunon
 */
public class Membercard {

    private final String CardHolder;
    private static int noOfCard = 0;
    private final String idCard;
    private double remainMoney;

    public Membercard(String CardHolder) { // สมัครทำบัตร
        noOfCard++;

        this.CardHolder = CardHolder;
        this.idCard = "0000" + String.valueOf(noOfCard);
        this.remainMoney = 0;
        memberDatabase.addAccount(this);
    }

    public void addMoney(double cash) { //เติมเงิน
        remainMoney += cash;
        System.out.println("Add money success");
    }

    public void purchaseTicket(double cash) { // หักเงินจากการซื้อตั๋ว
        if (remainMoney < cash) {
            System.out.println("Purchase failed: No enough money!");
        } else {
            remainMoney -= cash;
            System.out.println("Purchase successfully");
        }
    }

    @Override
    public String toString() {
        return "Cardholder-Name:" + CardHolder + " CardNo:" + idCard + " Money:" + remainMoney + " Baht";
    }

    public double getRemainMoney() {
        return remainMoney;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getCardHolder() {
        return CardHolder;
    }

    public static int getNoOfCard() {
        return noOfCard;
    }

}

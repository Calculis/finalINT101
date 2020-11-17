package Metro;

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

    private String CardHolder;
    private static int noOfCard;
    private String idCard;
    private double remainMoney;

    public Membercard(String CardHolder) { // สมัครทำบัตร
        noOfCard++;
        this.CardHolder = CardHolder;
        this.idCard = "0000" + String.valueOf(noOfCard);
        this.remainMoney = 0;
    }

    public void addMoney(double cash) { //เติมเงิน
        remainMoney += cash;
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
        return "CardholderName:" + CardHolder + " CardNo:" + idCard + " Money:" + remainMoney + " Baht";
    }

    public double getRemainMoney() {
        return remainMoney;
    }

}

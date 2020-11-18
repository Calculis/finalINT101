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

    private String CardHolder;
    private static int noOfCard=0;
    private String idCard;
    private double remainMoney;
    private static Membercard[] listCard=new Membercard[0];

    public  Membercard(String CardHolder) { // สมัครทำบัตร
        noOfCard++;
       
        this.CardHolder = CardHolder;
        this.idCard = "0000" + String.valueOf(noOfCard);
        this.remainMoney = 0;
       //method สร้างarray ใหม่ ขนาด+1 และกำหนดค่า จาก 0- n-1
        listCard= addAccount();
        listCard[noOfCard-1]=this;
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
    
   public static Membercard[] getListCard(){
       return listCard;
   }

    public String getIdCard() {
        return idCard;
    }
   private  Membercard[] addAccount(){

     Membercard[] temp=new Membercard[noOfCard];
     for(int i=0;i<listCard.length;i++){
         temp[i]=listCard[i];
     }
       return temp;
    
   }
   public static boolean isExist(String check){       
       for(int i=0;i<listCard.length;i++){
           if(check.equals(listCard[i].getIdCard())){
               return true;
           }
       }
       return false;
   }
   public static Membercard getCardById(String id){
       for(int i=0;i<listCard.length;i++){
           if(id.equals(listCard[i].idCard)){
               return listCard[i];
           }
       }
       return null;
   }

    public String getCardHolder() {
        return CardHolder;
    }
    
   

}

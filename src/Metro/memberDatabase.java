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
public class memberDatabase {

    private static Membercard memberList[] = new Membercard[0];

    public static void addAccount(Membercard lastMember) {
        Membercard[] temp = new Membercard[Membercard.getNoOfCard()];
        for (int i = 0; i < memberList.length; i++) {
            temp[i] = memberList[i];
        }
        memberList = temp;
        memberList[Membercard.getNoOfCard() - 1] = lastMember;
    }

    public static boolean isExist(String idCard) {
        for (int i = 0; i < memberList.length; i++) {
            if (memberList[i].getIdCard().equals(idCard)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static Membercard getById(String id) {
        for (int i = 0; i < memberList.length; i++) {
            if (memberList[i].getIdCard().equals(id)) {
                return memberList[i];
            } else {
                return null;
            }
        }
        return null;
    }

    public static Membercard[] getMemberList() {
        return memberList;
    }

}

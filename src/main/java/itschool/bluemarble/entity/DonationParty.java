package itschool.bluemarble.entity;

import itschool.bluemarble.entity.ifs.Payable;

public class DonationParty implements Payable {
    private int curMoney;

    public void pay(Payable receiver, int amount){
        receiver.income(curMoney);
        curMoney = 0;
    }

    //수입
    @Override
    public void income(int amount){
        curMoney += amount;
    }
}
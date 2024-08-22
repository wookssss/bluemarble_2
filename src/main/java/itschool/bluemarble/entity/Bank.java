package itschool.bluemarble.entity;

import itschool.bluemarble.entity.ifs.Payable;

public class Bank implements Payable {
    private int curMoney;

    public void pay(Payable receiver, int amount){
        if(curMoney >= amount){
            curMoney -= amount;
            receiver.income(amount);
        }
    }

    //수입
    @Override
    public void income(int amount){
        curMoney += amount;
    }
}

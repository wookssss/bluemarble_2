package itschool.bluemarble.entity;

import itschool.bluemarble.entity.ifs.Payable;
import itschool.bluemarble.factory.GoldenKeyTile;

public class Bank implements Payable {
    // 싱글톤 시작
    final private static Bank instance = new Bank();
    public static Bank getInstance() {
        return instance;
    }
    private Bank() {}
    // 싱글톤 끝


    private int curMoney = 100_000_000;

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

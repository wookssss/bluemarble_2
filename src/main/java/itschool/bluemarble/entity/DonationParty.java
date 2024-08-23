package itschool.bluemarble.entity;

import itschool.bluemarble.entity.ifs.Payable;

public class DonationParty implements Payable {
    private int curMoney;

    // 싱글톤 시작
    final private static DonationParty instance = new DonationParty();
    public static DonationParty getInstance() {
        return instance;
    }
    private DonationParty() { this.curMoney = 0; }
    // 싱글톤 끝

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
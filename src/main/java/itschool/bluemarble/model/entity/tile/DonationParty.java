package itschool.bluemarble.model.entity.tile;

import itschool.bluemarble.model.entity.ifs.Payable;

public class DonationParty extends Tile implements Payable {
    private int curMoney;

    // 싱글톤 시작
    final private static DonationParty instance = new DonationParty();

    public static DonationParty getInstance() {
        return instance;
    }

    private DonationParty() {
        super("사회복지기금 접수처");
        this.curMoney = 0;
    }
    // 싱글톤 끝

    @Override
    public void pay(Payable receiver, int amount) {
        receiver.income(curMoney);
        curMoney = 0;
    }

    //수입
    @Override
    public void income(int amount) {
        curMoney += amount;

    }
}

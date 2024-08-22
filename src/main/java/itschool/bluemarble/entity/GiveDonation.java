package itschool.bluemarble.entity;

import itschool.bluemarble.entity.abs.SpecialTile;
import itschool.bluemarble.entity.ifs.SpecialFunction;

public class GiveDonation extends SpecialTile {
    DonationParty donationParty;

    public GiveDonation(DonationParty donationParty){
        super("사회복지기금 접수처", new SpecialFunction() {
            @Override
            public void execute(Player player) {
                player.pay(donationParty,150000);
                System.out.println("사회복지기금이 접수되었습니다.");
                player.lookMoney();
            }
        });
    }
}

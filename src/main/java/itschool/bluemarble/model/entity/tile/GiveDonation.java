package itschool.bluemarble.model.entity.tile;

import itschool.bluemarble.model.entity.Player;
import itschool.bluemarble.model.entity.tile.abs.SpecialTile;
import itschool.bluemarble.model.entity.tile.ifs.SpecialFunction;

public class GiveDonation extends SpecialTile {
    private static DonationParty donationParty = DonationParty.getInstance();

    public GiveDonation(){
        super("사회복지기금수령처", new SpecialFunction() {
            @Override
            public void execute(Player player) throws Exception{
                try {
                    // player.payAmountTo(donationParty, 150000);
                    System.out.println("사회복지기금이 접수되었습니다.");
                    player.showAmount();
                } catch(Exception e){
                    throw e;
                }
            }
        });
    }
}

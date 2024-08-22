package itschool.bluemarble.entity;

import itschool.bluemarble.entity.abs.SpecialTile;
import itschool.bluemarble.entity.ifs.SpecialFunction;

public class GiveDonation extends SpecialTile {
    public GiveDonation(){
        super("사회복지기금접수", new SpecialFunction() {
            @Override
            public void execute(Player player) {
                //player.pay(,150000);
                System.out.println("사회복지기금이 접수되었습니다.");
                player.lookMoney();
            }
        });
    }
}

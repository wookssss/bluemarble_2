package itschool.bluemarble.entity;

import itschool.bluemarble.entity.abs.SpecialTile;
import itschool.bluemarble.entity.ifs.SpecialFunction;

public class Island extends SpecialTile {
    public Island(){
        super("무인도", new SpecialFunction() {
            @Override
            public void execute(Player player) {
                System.out.println(player+"님이 무인도에 갇히셨습니다.");
            }
        });
    }
}

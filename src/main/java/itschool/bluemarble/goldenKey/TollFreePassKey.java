package itschool.bluemarble.goldenKey;

import itschool.bluemarble.entity.Player;
import itschool.bluemarble.goldenKey.ifs.HoldableFunction;

public class TollFreePassKey implements HoldableFunction {
    @Override
    public void use(Player player) {
        StringBuilder sb = new StringBuilder();
        sb.append("플레이어 ").append(player.getPlayerName()).append("님이 무료통행권을 사용하셨습니다.");
        System.out.println(sb);
    }
}

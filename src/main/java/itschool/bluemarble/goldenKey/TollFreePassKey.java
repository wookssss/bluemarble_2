package itschool.bluemarble.goldenKey;

import itschool.bluemarble.entity.Player;
import itschool.bluemarble.goldenKey.ifs.HoldableKey;

public class TollFreePassKey implements HoldableKey {
    @Override
    public void use(Player player) {
        StringBuilder sb = new StringBuilder();
        sb.append("플레이어 ").append(player.getPlayerName()).append("님이 무료통행권을 사용하셨습니다.");
        System.out.println(sb);
    }
}

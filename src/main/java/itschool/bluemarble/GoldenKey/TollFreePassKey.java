package itschool.bluemarble.GoldenKey;

import itschool.bluemarble.entity.Player;
import itschool.bluemarble.ifs.HoldableKey;

public class TollFreePassKey implements HoldableKey {
    @Override
    public void use(Player player) {
        StringBuilder sb = new StringBuilder();
        sb.append("플레이어 ");
        sb.append(player/*.getName()*/);
        sb.append("님이 무료통행권을 사용하셨습니다.");
        System.out.println(sb);
    }
}

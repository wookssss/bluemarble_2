package itschool.bluemarble.model.entity.goldenKey;

import itschool.bluemarble.model.entity.Player;
import itschool.bluemarble.model.entity.goldenKey.ifs.Function;
import itschool.bluemarble.model.entity.goldenKey.ifs.HoldableFunction;

public class TollFreePassKey extends GoldenKey  {
    public TollFreePassKey(String title, String description) {
        super(title, description, new HoldableFunction() {
            @Override
            public void use(Player player) {
                StringBuilder sb = new StringBuilder();
                sb.append("플레이어 ").append(player.getName()).append("님이 무료통행권을 사용하셨습니다.");
                System.out.println(sb);
            }
        });
    }
}

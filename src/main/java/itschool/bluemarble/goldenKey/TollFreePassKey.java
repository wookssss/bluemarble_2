package itschool.bluemarble.goldenKey;

import itschool.bluemarble.entity.Player;
import itschool.bluemarble.goldenKey.ifs.Function;
import itschool.bluemarble.goldenKey.ifs.HoldableFunction;

public class TollFreePassKey extends GoldenKey  {
   public TollFreePassKey(){
       super("무료통행권", "무료통행권입니다.", new HoldableFunction() {
           @Override
           public void use(Player player) {
               StringBuilder sb = new StringBuilder();
               sb.append("플레이어 ").append(player.getPlayerName()).append("님이 무료통행권을 사용하셨습니다.");
               System.out.println(sb);
           }
       });



   }



}

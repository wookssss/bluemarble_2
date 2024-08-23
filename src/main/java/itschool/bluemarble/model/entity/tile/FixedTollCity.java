package itschool.bluemarble.model.entity.tile;

import itschool.bluemarble.model.entity.tile.abs.PurchasableTile;

public class FixedTollCity extends PurchasableTile {

    public FixedTollCity(String name) {
        super(name);
    }

    {
        // 통행료 고정
        switch (name) {
            case "제주도":
                toll = 300_000;
                break;
            case "콩코드여객기":
                toll = 300_000;
                break;
            case "부산":
                toll = 600_000;
                break;
            case "퀸엘리자베스호":
                toll = 250_000;
                break;
            case "컬럼비아호":
                toll = 400_000;
                break;
            case "서울":
                toll = 2_000_000;
                break;
        }
    }

    @Override
    public int getToll() throws Exception {
        if(!isPurchasable()) {
            return toll;
        } else {
            throw new Exception("현재 주인이 없으므로 통행료 지불 의무가 없습니다.");
        }
    }
}

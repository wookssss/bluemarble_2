package itschool.bluemarble.model.entity.tile.abs;

import itschool.bluemarble.exception.violation.PlayerHasNoMoneyViolation;
import itschool.bluemarble.model.entity.Player;
import itschool.bluemarble.model.entity.tile.Tile;
import itschool.bluemarble.progress.Game;
import itschool.bluemarble.progress.GameByConsole;
import lombok.Getter;

@Getter
public abstract class PurchasableTile extends Tile {
    protected Player owner;
    protected int price;
    protected int toll;

    public PurchasableTile(String name) {
        super(name);
    }

    {
        // 가격 정의
        switch (name) {
            case "타이베이":
                price = 50_000;
                break;
            case "베이징":
            case "마닐라":
                price = 80_000;
                break;
            case "제주도":
                price = 200_000;
                break;
            case "싱가포르":
            case "카이로":
                price = 100_000;
                break;
            case "이스탄불":
                price = 120_000;
                break;
            case "아테네":
                price = 140_000;
                break;
            case "코펜하겐":
            case "스톡홀름":
                price = 160_000;
                break;
            case "콩코드여객기":
                price = 200_000;
                break;
            case "베른":
            case "베를린":
                price = 180_000;
                break;
            case "오타와":
                price = 200_000;
                break;
            case "부에노스아이레스":
                price = 220_000;
                break;
            case "상파울루":
            case "시드니":
                price = 240_000;
                break;
            case "부산":
                price = 500_000;
                break;
            case "하와이":
            case "리스본":
                price = 260_000;
                break;
            case "퀸엘리자베스호":
                price = 300_000;
                break;
            case "마드리드":
                price = 280_000;
                break;
            case "도쿄":
                price = 300_000;
                break;
            case "컬럼비아호":
                price = 450_000;
                break;
            case "파리":
            case "로마":
                price = 320_000;
                break;
            case "런던":
            case "뉴욕":
                price = 350_000;
                break;
            case "서울":
                price = 1_000_000;
                break;
        }
    }

    public boolean isPurchasable(){
        return (owner == null)? true:false;
    }

    // 도시 구매 (주인이 없는 지 체크 먼저)
    public void purchaseTile(Player player) throws PlayerHasNoMoneyViolation {
        if(isPurchasable()) {
            player.payAmountToBank(price);
            player.plusAsset(price);
            this.owner = player;
        } else {
            throw new RuntimeException("이미 주인이 있는 땅입니다.");
        }
    }

    // 통행료가 얼마인지 반환
    public abstract int getToll() throws RuntimeException;

    public boolean shouldPay(Player player) {
        if(player.equals(owner) || null == owner) { // 땅의 주인이거나 땅에 주인이 없거나
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return name + '(' + GameByConsole.formatWithCommas(price) + "," + GameByConsole.formatWithCommas(toll) + ')';
    }
}
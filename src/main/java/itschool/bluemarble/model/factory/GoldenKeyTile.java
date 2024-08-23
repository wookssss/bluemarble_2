//담당자: 이승종, 이승환

//황금 열쇠 추상화
//황금 열쇠 이동
//draw로 뽑은 카드 제거
//suffle로 카드 섞는 기능 추가
//카드가 전부 떨어졌을 때 다시 배치 및 셔플
//프리 패스 키, 수입 기능 추가

package itschool.bluemarble.model.factory;

import itschool.bluemarble.model.entity.Bank;
import itschool.bluemarble.model.entity.Player;
import itschool.bluemarble.model.entity.goldenKey.GoldenKey;
import itschool.bluemarble.model.entity.tile.Tile;
import itschool.bluemarble.model.entity.goldenKey.TollFreePassKey;
import itschool.bluemarble.model.entity.goldenKey.ifs.InstantFunction;

import java.util.*;

public class GoldenKeyTile extends Tile {
    // 싱글톤 시작
    final private static GoldenKeyTile instance = new GoldenKeyTile();


    public static GoldenKeyTile getInstance() {
        return instance;
    }

    private GoldenKeyTile() {
        super("황금열쇠");
        initializeGoldenKeys();
        shuffle();
    }
    // 싱글톤 끝

    private ArrayList<GoldenKey> goldenKeyList = new ArrayList<>();

    // 초기화 메서드
    private void initializeGoldenKeys(){
        goldenKeyList.addAll(Arrays.asList(
                new GoldenKey("뒤로 2칸 이동", "뒤로 두 칸 이동합니다.",(InstantFunction) ((player) -> player.moveByRelativeValue(-2))), // 뒤로 2칸 이동
                new GoldenKey("뒤로 3칸 이동","뒤로 세 칸 이동합니다." ,(InstantFunction) ((player) -> player.moveByRelativeValue(-3))), // 뒤로 3칸 이동
                new GoldenKey("서울로 이동", "서울로 이동합니다.",(InstantFunction) ((player) -> player.moveByAbsoluteValue(39))), // 서울로 이동
                new GoldenKey("무인도로 이동", "무인도로 이동합니다.",(InstantFunction) ((player) -> player.moveByAbsoluteValue(10))), // 무인도로 이동
                new GoldenKey("우주여행으로 이동", "우주여행으로 이동합니다.",(InstantFunction) ((player) -> player.moveByAbsoluteValue(30))), // 우주여행으로 이동
                new GoldenKey("제주도로 이동", "제주도로 이동합니다.",(InstantFunction) ((player) -> player.moveByAbsoluteValue(5))), // 제주도로 이동
                new GoldenKey("부산으로 이동", "부산으로 이동합니다.",(InstantFunction) ((player) -> player.moveByAbsoluteValue(25))), // 부산으로 이동
                new GoldenKey("사회복지기금으로 이동", "사회복지기금으로 이동합니다.",(InstantFunction) ((player) -> player.moveByAbsoluteValue(20))), // 사회복지기금으로 이동
                new GoldenKey("출발지로 이동", "출발지로 이동합니다.",(InstantFunction) ((player) -> player.moveByAbsoluteValue(0))), // 출발지로 이동
                new GoldenKey("노벨평화상 수상", "30만원을 받습니다.",(InstantFunction) ((player) -> player.plusAmount(300000))),
                new GoldenKey("복권 당첨", "20만원을 받습니다.",(InstantFunction) ((player) -> player.plusAmount(200000))),
                new GoldenKey("경주 우승", "10만원을 받습니다.",(InstantFunction) ((player) -> player.plusAmount(100000))),
                new GoldenKey("장학금 혜택", "10만원을 받습니다.",(InstantFunction) ((player) -> player.plusAmount(100000))),
                new GoldenKey("연금 혜택", "5만원을 받습니다.",(InstantFunction) ((player) -> player.plusAmount(50000))),
                new GoldenKey("해외 유학", "해외 유학비로 10만원을 은행에 냅니다.",(InstantFunction) ((player) ->  player.minusAmount(50000))),


                new TollFreePassKey()
        ));
        /*(InstantKey) ((player) -> player.moveByRelativeValue(-3)), // 뒤로 3칸 이동
                (InstantKey) ((player) -> player.moveByAbsoluteValue(39)), // 서울로 이동 황금열쇠
                // (HoldableKey) // 뭐가 있을까?
                new TollFreePassKey() // 통행료 면제*/
    }



    public GoldenKey draw(){
        if (goldenKeyList.size() == 0){
            initializeGoldenKeys();
            shuffle();
        }
            return goldenKeyList.remove(0);


    }
    private void shuffle(){
        Collections.shuffle(goldenKeyList);

    }
}
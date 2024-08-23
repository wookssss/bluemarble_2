package itschool.bluemarble.entity;

import itschool.bluemarble.entity.ifs.Payable;
import itschool.bluemarble.entity.ifs.PurchasableTile;
import itschool.bluemarble.factory.GoldenKeyTile;
import itschool.bluemarble.goldenKey.GoldenKey;
import itschool.bluemarble.goldenKey.ifs.HoldableFunction;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Player implements Payable {

    private String playerName; // 플레이어 이름
    private int curPos = 0; // 현재 위치 : 타일 번호 0 ~ 39
    private int curMoney;   // 현재 보유 현금
    private int loanMoney = 0; // 현재 대출금
    private int asset = 0; // 총 자산
    private int islandCount = 0; // 무인도 체류 횟수
    private List<GoldenKey> goldenkeyList = new ArrayList<>(); //보유하고 있는 황금열쇠
    private List<PurchasableTile> myLandList = new ArrayList<>(); //보유하고 있는 땅


    public Player(String name) {
        this.playerName = name;
    }


    // 절대적인 타일번호로 이동
    public int moveByAbsoluteValue(int abs) {
        if(abs < curPos){
            getPaid();
        }
        curPos = abs;
        return curPos;
    }

    // 상대값으로 플레이어 이동
    public int moveByRelativeValue(int rel) {
        curPos += rel;
        if(curPos > 39) {
            curPos -= 39;
            if(curPos < 0){
                curPos = 40 + curPos;
            }
            getPaid(); // 월급 받기
            return curPos;
        }
        return curPos;
    }

    //지불
    @Override
    public void pay(Payable receiver, int amount) throws Exception {
        if(curMoney >= amount){
            curMoney -= amount;
            receiver.income(amount);
        } else {
            throw new Exception("지불할 돈이 부족합니다.");
            // Game에 있는 대출 or 파산 or 땅팔기 선택 호출
        }
    }

    //수입
    @Override
    public void income(int amount){
        curMoney += amount;
    }

    public void getPaid(){
        income(20);
        System.out.println(playerName + "님이 월급 20만원을 받았습니다.");
    }


    
    // 대출금 default 100으로 하기로 함
    public void loan(){
        curMoney += 100;
        loanMoney += 100;
        
    }

    // 플레이어의 현재 현금 보유액, 대출금 보유액 보여줌
    public void lookMoney(){
        System.out.println(playerName +"님의 현재 보유 자산 - 1.현금 : " + curMoney + " 2. 대출금 : " + loanMoney );
    }

    public GoldenKey drawGoldenKey(GoldenKeyTile goldenKeyTile){
        GoldenKey goldenKey = goldenKeyTile.draw();

        if(goldenKey.getFunction() instanceof HoldableFunction){
            goldenkeyList.add(goldenKey);
        }
        return goldenKey;
    }

    //무인도 카운트
    public void islandStatus(){
        islandCount++;
        if (islandCount == 4)
            islandCount = 0;
    }

    public void buyLand(PurchasableTile tile) throws Exception {
        try {
            tile.purchaseTile(this);
            myLandList.add(tile);
        } catch (Exception e){
            throw e;
        }

    }

    private void sellLand(PurchasableTile tile) {
        tile.purchaseTile(this);
        myLandList.remove(tile);
    }

    public void sellAtHalfPrice(){

        PurchasableTile mostExpensive;
        int max = Integer.MIN_VALUE;
        //  제일 비싼 땅 (현재 땅값 기준 이후 수정필요)
        if(myLandList.size() == 0){
            // 팔 땅이 없음
        } else {
            for(PurchasableTile myland : myLandList){
                int price =  myland.getPrice();
                if(max < price) {
                    max = price;
                    mostExpensive = myland;
                }
            }
        }

        sellLand(mostExpensive);
    }



    /* 대출금 갚는 부분 보류 (우선 마지막 자산 계산 때 loanMoney - 계산
    public void loanRepay(int amount){
        curMoney -= amount;
        loanMoney = 0;
    } */

}

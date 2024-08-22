package itschool.bluemarble.entity;

import itschool.bluemarble.factory.GoldenKeyTile;
import itschool.bluemarble.goldenKey.GoldenKey;
import itschool.bluemarble.goldenKey.ifs.HoldableFunction;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Player {

    private String playerName; // 플레이어 이름
    private int curPos = 0; // 현재 위치 : 타일 번호 0 ~ 39
    private int curMoney;   // 현재 보유 현금
    private int loanMoney = 0; // 현재 대출금
    private int asset = 0; // 총 자산
    private int islandCount = 0; // 무인도 체류 횟수
    private ArrayList<GoldenKey> goldenkeyList = new ArrayList<>(); //보유하고 있는 황금열쇠


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
    public void pay(String receiver, int amount){
        if(curMoney >= amount){
            curMoney -= amount;
            // receiver의 curMoney에는 +를 해줘야함 receiver를 어떻게 찾아야 하나?
        } else {
            System.out.println("지불할 돈이 부족합니다.");
            // Game에 있는 대출 or 파산 or 땅팔기 선택 호출
        }
    }

    //수입
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

    /* 대출금 갚는 부분 보류 (우선 마지막 자산 계산 때 loanMoney - 계산
    public void loanRepay(int amount){
        curMoney -= amount;
        loanMoney = 0;
    } */

}

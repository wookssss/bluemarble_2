package itschool.bluemarble.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Player {
    // 현재 위치 : 타일 번호 0 ~ 39
    private String playerName;
    private int curPos = 0;
    private int curMoney;
    private int loanMoney = 0;

    public Player(String name) {
        this.playerName = name;
    }


    // 절대적인 타일번호로 이동
    public void moveByAbsoluteValue(int abs) {
        curPos = abs;
    }

    // 상대값으로 플레이어 이동
    public void moveByRelativeValue(int rel) {
        switch (rel) {
            case 0 :
                // Dice.roll() 재실행
                break;
            case 1 :
                // curPos = (무인도타일번호); 무인도로 이동
            default :
                curPos += rel;
                if(curPos > 39) {
                    curPos -= 39;
                }
        }
    }

    public void buy(int cityCode, String land, String villa, String building, String hotel, int amount){

    }

    public void sell(int cityCode, int amount){

    }
    public void pay(String receiver, int amount){
        if(curMoney >= amount){
            curMoney -= amount;
            // receiver의 curMoney에는 +를 해줘야함 receiver를 어떻게 찾아야 하나?
        } else {
            System.out.println("지불할 돈이 부족합니다.");
            // 대출 or 파산 선택
        }
    }

    public void loan(int amount){
        curMoney += amount;
        loanMoney += amount;
    }

    public void loanRepay(int amount){
        curMoney -= amount;
        loanMoney = 0;
    }

    public void playerOut(){

    }
}

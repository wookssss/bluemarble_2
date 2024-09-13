// 백지혜 Player
// Payable 상속 : payAmountTo() plusAmount() minusAmount()
// 플레이어 이동, 지불, 수입, 대출, 현재 자산 보여주기
// 무인도체류 카운트, 땅 사기, 땅 팔기, 제일 비싼 땅 반값팔기(황금열쇠)


package itschool.bluemarble.model.entity;

import itschool.bluemarble.exception.violation.BankruptPlayerViolation;
import itschool.bluemarble.exception.violation.PlayerHasNoLandViolation;
import itschool.bluemarble.exception.violation.PlayerHasNoMoneyViolation;
import itschool.bluemarble.model.entity.goldenKey.GoldenKeyTile;
import itschool.bluemarble.model.entity.goldenKey.TollFreePassKey;
import itschool.bluemarble.model.entity.ifs.Payable;
import itschool.bluemarble.model.entity.tile.abs.PurchasableTile;
import itschool.bluemarble.model.entity.goldenKey.GoldenKey;
import itschool.bluemarble.model.entity.goldenKey.ifs.HoldableFunction;
import itschool.bluemarble.model.factory.TileFactory;
import itschool.bluemarble.progress.GameByConsole;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Player extends Payable {

    private String name; // 플레이어 이름
    private int location = 0; // 현재 위치 : 타일 번호 0 ~ 39
    private int debt = 0; // 현재 대출금
    private int asset = 0; // 현재 자산
    private int islandCount = 0; // 무인도 체류 횟수
    private List<GoldenKey> goldenkeyList = new ArrayList<>(); //보유하고 있는 황금열쇠
    private List<PurchasableTile> myLandList = new ArrayList<>(); //보유하고 있는 땅
    private Bank bank = Bank.getInstance();

    // 생성자 - 이름, 초기자금, 플레이어생명 셋팅
    public Player(String name, int amount) {
        this.name = name;
        this.cash = amount;
    }

    public int myAllAsset(){ // 총 자산 + 현금
        return asset + cash;
    }

    // 절대적인 타일번호로 이동
    public int moveByAbsoluteValue(int abs) {
        if(abs < location){
            getPaid();
        }
        location = abs;
        return location;
    }

    // 상대값으로 플레이어 이동
    public int moveByRelativeValue(int rel) {
        location += rel;
        if(location > 39) {
            location -= 39 + 1;
            getPaid(); // 월급 받기
            return location;
        }
        if(location < 0){ // 황금열쇠 뒤로가기 나와서 location이 -값 되었을 경우
            location = 40 + location;
        }
        return location;
    }


    //은행에 지불
    public void payAmountToBank(int amount) throws PlayerHasNoMoneyViolation {
        minusAmount(amount);
    }

    // 다른 플레이어에게 지불
    @Override
    public boolean payAmountTo(Player receiver, int amount) throws PlayerHasNoMoneyViolation {
        if(super.payAmountTo(receiver, amount)) {
            return true;
        } else {
            throw new PlayerHasNoMoneyViolation(this.name);
        }
    }

    //전재산 지불
    public void payAllAssetsTo(Player receiver) throws BankruptPlayerViolation {
        receiver.payAmountTo(receiver, this.asset);
        asset = 0;
        cash = 0;
        throw new BankruptPlayerViolation(this.name);
    }

    //월급받기
    public void getPaid(){
        plusAmount(200_000);
        System.out.println(name + "님이 월급 20만원을 받았습니다.");
    }


    // 대출금 default 100만원
    public void loan(){
        cash += 1_000_000;
        debt += 1_000_000;
        
    }

    public void plusAsset(int amount) {
        asset += amount;
    }

    public void minusAsset(int amount) {
        asset -= amount;
    }

    //무인도 도착시 무인도 카운트 3으로 설정
    public void arriveIsland(){
        islandCount = 3;
    }
    //무인도 카운트-- 0이되면 탈출
    public void stayIsland(Boolean Double){
        islandCount--;
        if (Double) islandCount = 0;
    }
    //무인도 확인
    public boolean checkIsland(){
        if(islandCount!=0){
            return true; // 체류해야 되는 조건의 사람
        }
        return false; // 탈출할 차례인 사람
    }

    // 땅 사기
    public void buyLand(PurchasableTile tile) throws PlayerHasNoMoneyViolation {
        tile.purchaseTile(this);
        myLandList.add(tile);
    }

    // 땅 팔기
    private void sellLand(PurchasableTile tile) {
        tile.purchaseTile(this);
        myLandList.remove(tile);
    }

    // 황금열쇠 뽑기
    public GoldenKey drawGoldenKey(GoldenKeyTile goldenKeyTile) {
        GoldenKey goldenKey = goldenKeyTile.draw();

        if(goldenKey.getFunction() instanceof HoldableFunction){
            goldenkeyList.add(goldenKey);
        }
        return goldenKey;
    }

    //황금열쇠 : 가장 비싼 땅 팔기
    public void sellAtHalfPrice() throws PlayerHasNoLandViolation {

        PurchasableTile mostExpensive = null;
        int max = Integer.MIN_VALUE;
        //  제일 비싼 땅 (현재 땅값 기준 이후 수정필요)
        if(myLandList.size() == 0){
            throw new PlayerHasNoLandViolation(this.name);
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

    // 황금열쇠 프리패스키
    public boolean hasTollFreePassKey(Player player) {
        for(GoldenKey key : goldenkeyList) {
            if(key instanceof TollFreePassKey)
                return true;
        }
        return false;
    }


    // 황금열쇠 프리패스키 찾기
    public GoldenKey findTollFreePassKey() throws RuntimeException {
        if(hasTollFreePassKey(this)) {
            for(GoldenKey goldenKey : goldenkeyList) {
                if(goldenKey instanceof TollFreePassKey)
                    return goldenKey;
            }
        }
        throw new RuntimeException("해당 황금열쇠가 존재하지 않습니다.");
    }

    // 황금열쇠 사용
    public GoldenKey useGoldenKey(GoldenKey needUseKey) throws RuntimeException {
        for (int i = 0; i < goldenkeyList.size(); i++) {
            if(goldenkeyList.get(i).equals(needUseKey))
                return goldenkeyList.remove(i);
        }

        throw new RuntimeException("해당 황금열쇠가 존재하지 않습니다.");
    }


    @Override
    public String toString() {
        if(islandCount!=0){ //무인도에 체류하고 있는 player는 무인도 체류 횟수 포함해서 출력
            return "============================================================================================\n\n" +
                    "플레이어명 : " + name + "\n" +
                    "현재 위치 = " + TileFactory.getTiles().get(location).getName() + "[" + location + "]\n" +
                    "남은 무인도 체류 횟수" + islandCount + "회" + '\n' +
                    "보유 현금 = " + GameByConsole.formatWithCommas(cash) + "원" + '\n' +
                    "빚 = " + GameByConsole.formatWithCommas(debt) + "원" + '\n' +
                    "자산 = " + GameByConsole.formatWithCommas(asset) + "원" + '\n' +
                    "보유 열쇠 = " + goldenkeyList + '\n' +
                    "부동산 = " + myLandList + '\n' +
                    "\n============================================================================================";

        } else {
            return "============================================================================================\n\n" +
                    "플레이어명 : " + name + "\n" +
                    "현재 위치 = " + TileFactory.getTiles().get(location).getName() + "[" + location + "]\n" +
                    "보유 현금 = " + GameByConsole.formatWithCommas(cash) + "원" + '\n' +
                    "빚 = " + GameByConsole.formatWithCommas(debt) + "원" + '\n' +
                    "자산 = " + GameByConsole.formatWithCommas(asset) + "원" + '\n' +
                    "보유 열쇠 = " + goldenkeyList + '\n' +
                    "부동산 = " + myLandList + '\n' +
                    "\n============================================================================================";

        }

       }

    /* 대출금 갚는 부분 보류 (우선 마지막 자산 계산 때 loanMoney - 계산
    public void loanRepay(int amount){
        cash -= amount;
        loanMoney = 0;
    } */


}

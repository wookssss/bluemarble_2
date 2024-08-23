// 백지혜
// 싱글톤, 지불, 수입 기능 완료

package itschool.bluemarble.model.entity;

import itschool.bluemarble.model.entity.ifs.Payable;

public class Bank implements Payable {
    // 싱글톤 시작
    final private static Bank instance = new Bank();
    public static Bank getInstance() {
        return instance;
    }
    private Bank() {}
    // 싱글톤 끝


    private int curMoney = 100_000_000;

    // 지불
    public void pay(Payable receiver, int amount){
        if(curMoney >= amount){
            curMoney -= amount;
            receiver.income(amount);
        }
    }

    //수입
    @Override
    public void income(int amount){
        curMoney += amount;
    }
}

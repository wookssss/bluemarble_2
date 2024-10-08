// 백지혜
// payAmountTo, plusAmount 추상클래스

package itschool.bluemarble.model.entity.ifs;


import itschool.bluemarble.exception.violation.PlayerHasNoMoneyViolation;
import itschool.bluemarble.model.entity.Player;

public abstract class Payable {
    public int cash; // 보유 현금
    public abstract void payAllAssetsTo(Player receiver) throws Exception;

    public boolean payAmountTo(Player receiver, int amount) throws PlayerHasNoMoneyViolation {
        if(this.cash >= amount){
            minusAmount(amount);
            receiver.plusAmount(amount);
            return true;
        } else {
            return false;
        }
    }

    public void plusAmount(int amount){
        this.cash += amount;
    }
    public void minusAmount (int amount){
        this.cash -= amount;
    }

    public int getAmount() {
        return cash;
    }
}

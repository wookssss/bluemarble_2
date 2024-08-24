// 백지혜
// payAmountTo, plusAmount 추상클래스

package itschool.bluemarble.model.entity.ifs;


import itschool.bluemarble.exception.violation.PlayerHasNoMoneyViolation;

public abstract class Payable {
    public int amount;
    public abstract void payAllAssetsTo(Payable receiver) throws Exception;

    public boolean payAmountTo(Payable receiver, int amount) throws PlayerHasNoMoneyViolation {
        if(this.amount >= amount){
            minusAmount(amount);
            receiver.plusAmount(amount);
            return true;
        } else {
            return false;
        }
    }

    public void plusAmount(int amount){
        this.amount += amount;
    }
    public void minusAmount (int amount){
        this.amount -= amount;
    }

    public int getAmount() {
        return amount;
    }
}

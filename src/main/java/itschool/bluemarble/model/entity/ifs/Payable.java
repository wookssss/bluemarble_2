// 백지혜
// payAmountTo, plusAmount 인스턴스

package itschool.bluemarble.model.entity.ifs;

public abstract class Payable {
    public int amount;
    public abstract void payAllAssetsTo(Payable receiver) throws Exception;

    public void payAmountTo(Payable receiver, int amount) throws Exception {
        if(this.amount >= amount){
            minusAmount(amount);
            receiver.plusAmount(amount);
        } else {
            throw new Exception("지불할 돈이 부족합니다.");
            // Game에 있는 대출 or 파산 or 땅팔기 선택 호출
        }
    }

    public void plusAmount(int amount){
        this.amount += amount;
    }
    void minusAmount (int amount){
        this.amount -= amount;
    }

}

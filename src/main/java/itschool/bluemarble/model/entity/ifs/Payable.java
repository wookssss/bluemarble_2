// 백지혜
// pay, income 인스턴스

package itschool.bluemarble.model.entity.ifs;

public interface Payable {
    void pay(Payable receiver, int amount) throws Exception;

    void income(int amount);
}

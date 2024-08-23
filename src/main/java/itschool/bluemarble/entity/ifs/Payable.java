package itschool.bluemarble.entity.ifs;

public interface Payable {
    void pay(Payable receiver, int amount) throws Exception;

    void income(int amount);
}

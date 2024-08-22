package itschool.bluemarble.entity.ifs;

public interface Payable {
    void pay(Payable receiver, int amount);

    void income(int amount);
}

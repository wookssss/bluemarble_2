// 백지혜
// 싱글톤, 지불, 수입 기능 완료

package itschool.bluemarble.model.entity;

import itschool.bluemarble.model.entity.ifs.Payable;

public class Bank extends Payable {
    // 싱글톤 시작
    final private static Bank instance = new Bank();
    public static Bank getInstance() {
        return instance;
    }
    private Bank() {}

    @Override
    public void payAllAssetsTo(Player receiver) throws Exception {
        throw new Exception("은행은 사용하지 않습니다.");
    }
    // 싱글톤 끝


}



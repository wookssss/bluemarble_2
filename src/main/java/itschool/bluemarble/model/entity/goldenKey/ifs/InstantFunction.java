package itschool.bluemarble.model.entity.goldenKey.ifs;

import itschool.bluemarble.exception.violation.BankruptPlayerViolation;
import itschool.bluemarble.exception.violation.PlayerHasNoLandViolation;
import itschool.bluemarble.exception.violation.PlayerHasNoMoneyViolation;
import itschool.bluemarble.model.entity.Player;

@FunctionalInterface
public interface InstantFunction extends Function {
    void execute(Player player) throws PlayerHasNoLandViolation, PlayerHasNoMoneyViolation, BankruptPlayerViolation;
}

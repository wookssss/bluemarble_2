package itschool.bluemarble.entity.ifs;

import itschool.bluemarble.entity.Player;

public interface SpecialFunction extends TileFunction{
    void giveDonation(Player player);
    void takeDonation(Player player);
    void spaceTourism(Player player);
}

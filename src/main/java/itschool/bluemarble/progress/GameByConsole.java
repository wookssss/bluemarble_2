package itschool.bluemarble.progress;

import itschool.bluemarble.progress.abs.Game;

// 상속받아 추상메서드를 구현하며 콘솔 출력을 담당
public class GameScreen extends Game {
    private GameScreen(int numberOfPlayer) {
        super(numberOfPlayer);
    }

    public static GameByConsole createGame(int numberOfPlayer) {
        return new GameByConsole(numberOfPlayer);
    }

    @Override
    public void showMapByConsole() {
        // showHeaderOrFooterTiles(true);

        // showMiddleTiles();

        // showHeaderOrFooterTiles(false);
    }

    /*
    public void showHeaderOrFooterTiles(boolean isHeader) {

        // ┌ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┬ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┬ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┬ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┬ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┬ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┬ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┬ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┬ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┬ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┬ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┐
        System.out.print(isHeader?"┌":"├");
        for (int i = 0; i <= 10; i++) {
            if (i== 0 || i == 9) {
                System.out.print(isHeader?"ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┬":"ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼");
            } else if(i == 10) {
                System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            } else {
                System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┬");
            }
        }
        System.out.println(isHeader?"┐":"┤");


        // │  사회복지기금접수  │  부에노스아이레스  │      황금열쇠      │      상파울루      │       시드니       │        부산        │       하와이       │       리스본       │   퀸엘리자베스호   │      마드리드      │      우주여행      │
        System.out.print("│");
        if(isHeader) {
            for (int i = 20; i <= 30; i++) {

                showTileName(TILES.get(i));

                if(i != 30) {
                    System.out.print("│");
                }
            }
        } else {
            for (int i = 10; i >= 0; i--) {

                showTileName(TILES.get(i));

                if(i != 0) {
                    System.out.print("│");
                }
            }
        }
        System.out.println("│");


        // ├ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼                  ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼                  ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┤
        // ├ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┤
        System.out.print("│");
        if(isHeader) {
            for (int i = 20; i <= 30; i++) {
                if(TILES.get(i) instanceof City) {
                    if(i == 30) {
                        System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
                    } else {
                        System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ│");
                    }
                } else {
                    if(i == 30) {
                        System.out.print("                  ");
                    } else {
                        System.out.print("                  │");
                    }
                }
            }
        } else {
            for (int i = 10; i >= 0; i--) {
                if(TILES.get(i) instanceof City) {
                    if(i == 0) {
                        System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
                    } else {
                        System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ│");
                    }
                } else {
                    if(i == 0) {
                        System.out.print("                  ");
                    } else {
                        System.out.print("                  │");
                    }
                }
            }
        }
        System.out.println("│");

        System.out.print("│");
        if(isHeader) {
            for (int i = 20; i <= 30; i++) {
                if(TILES.get(i) instanceof City) {
                    if(((City) TILES.get(i)).getVilla() != null) System.out.print(" 별장│");
                    else System.out.print("     │");

                    if(((City) TILES.get(i)).getBuilding() != null) System.out.print(" 빌딩│");
                    else System.out.print("     │");

                    if(((City) TILES.get(i)).getHotel() != null) System.out.print(" 호텔 ");
                    else System.out.print("      ");

                    if(i != 30) System.out.print("│");
                } else {
                    System.out.print("                  ");
                    if(i != 30) System.out.print("│");
                }
            }
        } else {
            for (int i = 10; i >= 0; i--) {
                if(TILES.get(i) instanceof City) {
                    if(((City) TILES.get(i)).getVilla() != null) System.out.print(" 별장│");
                    else System.out.print("     │");

                    if(((City) TILES.get(i)).getBuilding() != null) System.out.print(" 빌딩│");
                    else System.out.print("     │");

                    if(((City) TILES.get(i)).getHotel() != null) System.out.print(" 호텔 ");
                    else System.out.print("      ");

                    if(i != 0) System.out.print("│");
                } else {
                    System.out.print("                  ");
                    if(i != 0) System.out.print("│");
                }
            }
        }
        System.out.println("│");


        //
        // ├ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┤
        System.out.print("├");
        for (int i = 0; i <= 10; i++) {
            if(i == 10) {
                System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            } else {
                System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼");
            }
        }
        System.out.println("┤");



        // │     플레이어1      │
        // │     플레이어2      │
        // │     플레이어3      │
        // │     플레이어4      │
        for (int i = 0; i < PLAYERS.size(); i++) {
            System.out.print("│");
            if(isHeader) {
                for (int j = 20; j <= 30; j++) {
                    showPlayerLocation(PLAYERS.get(i), j);
                    if(j != 30) {
                        System.out.print("│");
                    }
                }
            } else {
                for (int k = 10; k >= 0; k--) {
                    showPlayerLocation(PLAYERS.get(i), k);

                    if(k != 0) {
                        System.out.print("│");
                    }
                }
            }
            System.out.println("│");
        }


        // └ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┴ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┴ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┴ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┴ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┴ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┴ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┴ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┴ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┴ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┴ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┘
        System.out.print(isHeader?"├":"└");
        for (int i = 0; i <= 10; i++) {
            if (i== 0 || i == 9) {
                System.out.print(isHeader?"ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┼":"ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┴");
            } else if(i == 10) {
                System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            } else {
                System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┴");
            }
        }
        System.out.println(isHeader?"┤":"┘");
    }

    private void showMiddleTiles() {
        int leftIndex = 19; // --
        int rightIndex = 31; // ++

        while (leftIndex > 10) {
            // │  사회복지기금접수  │  부에노스아이레스  │      황금열쇠      │      상파울루      │       시드니       │        부산        │       하와이       │       리스본       │   퀸엘리자베스호   │      마드리드      │      우주여행      │
            System.out.print("│");
            showTileName(TILES.get(leftIndex));
            System.out.print("│");
            for (int i = 0; i < 9; i++) {
                System.out.print(i!=8?"                   ":"                  │");
            }
            showTileName(TILES.get(rightIndex));
            System.out.println("│");




            System.out.print("│");
            System.out.print(TILES.get(leftIndex) instanceof City? "ㅡㅡㅡㅡㅡㅡㅡㅡㅡ":"                  ");
            System.out.print("│");

            for (int i = 0; i < 9; i++) {
                System.out.print(i!=8?"                   ":"                  │");
            }

            System.out.print(TILES.get(rightIndex) instanceof City?"ㅡㅡㅡㅡㅡㅡㅡㅡㅡ":"                  ");
            System.out.println("│");





            System.out.print("│");
            if(TILES.get(leftIndex) instanceof City) {
                if (((City) TILES.get(leftIndex)).getVilla() != null) System.out.print(" 별장│");
                else System.out.print("     │");

                if (((City) TILES.get(leftIndex)).getBuilding() != null) System.out.print(" 빌딩│");
                else System.out.print("     │");

                if (((City) TILES.get(leftIndex)).getHotel() != null) System.out.print(" 호텔 ");
                else System.out.print("      ");
            } else {
                System.out.print("                  ");
            }
            System.out.print("│");

            for (int i = 0; i < 9; i++) {
                System.out.print(i!=8?"                   ":"                  │");
            }

            if(TILES.get(rightIndex) instanceof City) {
                if (((City) TILES.get(rightIndex)).getVilla() != null) System.out.print(" 별장│");
                else System.out.print("     │");

                if (((City) TILES.get(rightIndex)).getBuilding() != null) System.out.print(" 빌딩│");
                else System.out.print("     │");

                if (((City) TILES.get(rightIndex)).getHotel() != null) System.out.print(" 호텔 ");
                else System.out.print("      ");
            } else {
                System.out.print("                  ");
            }
            System.out.println("│");

            for (int i = 0; i <= 10; i++) {
                if(i == 0 || i == 10) {
                    System.out.print(i == 0?"├ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┤":"├ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┤\n");
                } else {
                    System.out.print(i==9?"                  ":"                   ");
                }
            }

            for (int i = 0; i < PLAYERS.size(); i++) {
                System.out.print("│");
                showPlayerLocation(PLAYERS.get(i), leftIndex);
                System.out.print("│");

                for (int j = 0; j < 9; j++) {
                    System.out.print(j!=8?"                   ":"                  │");
                }

                showPlayerLocation(PLAYERS.get(i), rightIndex);
                System.out.println("│");
            }





            if (leftIndex >11) {
                for (int i = 0; i <= 10; i++) {
                    if(i == 0 || i == 10) {
                        System.out.print(i == 0?"├ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┤":"├ㅡㅡㅡㅡㅡㅡㅡㅡㅡ┤\n");
                    } else {
                        System.out.print(i==9?"                  ":"                   ");
                    }
                }
            }

            leftIndex--;
            rightIndex++;
        }

    }

    public void showTileName(Tile tile) {

        int prefix = (tileWidth - tile.getName().length());
        int suffix = prefix;

        for (int i = 0; i < prefix; i++) {
            System.out.print(" ");
        }

        System.out.printf("%s", tile.getName());

        for (int i = 0; i < suffix; i++) {
            System.out.print(" ");
        }

    }

    public void showPlayerLocation(Player player, int index) {

        if(index == player.getLocation()) {
            int prefix = (tileWidth - player.getName().length());
            int suffix = prefix;

            for (int j = 0; j < prefix; j++) {
                System.out.print(" ");
            }

            System.out.printf("%s", player.getName());

            for (int k = 0; k < suffix; k++) {
                System.out.print(" ");
            }
            System.out.print(" ");
        } else {
            for (int j = 0; j < tileWidth; j++) {
                System.out.print(" ");
                System.out.print(" ");
            }
        }
    }*/
}
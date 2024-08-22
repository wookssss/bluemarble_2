package itschool.bluemarble.progress;

import itschool.bluemarble.entity.City;
import itschool.bluemarble.entity.Player;
import itschool.bluemarble.entity.ifs.Tile;
import itschool.bluemarble.progress.abs.Game;

import java.util.Scanner;

// 상속받아 추상메서드를 구현하며 콘솔 출력을 담당
public class GameByConsole extends Game {
    private final int TILE_WIDTH = 9; // 콘솔에 타일 폭 확인

    public final static Scanner SCANNER = new Scanner(System.in);

    public static Scanner getScanner() {
        return SCANNER;
    }

    private GameByConsole(int numberOfPlayer) {
        super(numberOfPlayer);
        setPlayer(numberOfPlayer);
    }

    public void setPlayer(int numberOfPlayer) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("플레이어명은 한글 5자, 영문 또는 숫자 10자 이내로 입력이 가능합니다.");
        System.out.println("----------------------------------------------------------------");

        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.print("플레이어" + (i+1) + " 이름 입력 : ");
            String playerName = SCANNER.next();

            if(checkPlayerNameLength(playerName) > 10) {
                System.out.println("글자 제한을 초과하셨습니다. 다시 입력해주세요");
                i--;
            } else {
                PLAYERS.add(new Player(playerName)); // name을 세팅할 생성자 필요
            }
        }
    }

    public static GameByConsole createGameByConsole(int numberOfPlayer) {
        return new GameByConsole(numberOfPlayer);
    }

    @Override
    public void showMapByConsole() {
        showHeaderOrFooterTiles(true);

        showMiddleTiles();

        showHeaderOrFooterTiles(false);
    }

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

                showTileName((Tile) TILES.get(i));

                if(i != 30) {
                    System.out.print("│");
                }
            }
        } else {
            for (int i = 10; i >= 0; i--) {

                showTileName((Tile) TILES.get(i));

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
                    /*if(((City) TILES.get(i)).getVilla() != null) System.out.print(" 별장│");
                    else*/
                    System.out.print("     │");

                    /*if(((City) TILES.get(i)).getBuilding() != null) System.out.print(" 빌딩│");
                    else*/
                    System.out.print("     │");

                    /*if(((City) TILES.get(i)).getHotel() != null) System.out.print(" 호텔 ");
                    else*/
                    System.out.print("      ");

                    if(i != 30) System.out.print("│");
                } else {
                    System.out.print("                  ");
                    if(i != 30) System.out.print("│");
                }
            }
        } else {
            for (int i = 10; i >= 0; i--) {
                if(TILES.get(i) instanceof City) {
                    /*if(((City) TILES.get(i)).getVilla() != null) System.out.print(" 별장│");
                    else*/
                    System.out.print("     │");

                    /*if(((City) TILES.get(i)).getBuilding() != null) System.out.print(" 빌딩│");
                    else*/
                    System.out.print("     │");

                    /*if(((City) TILES.get(i)).getHotel() != null) System.out.print(" 호텔 ");
                    else*/
                    System.out.print("      ");

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
            showTileName((Tile) TILES.get(leftIndex));
            System.out.print("│");
            for (int i = 0; i < 9; i++) {
                System.out.print(i!=8?"                   ":"                  │");
            }
            showTileName((Tile) TILES.get(rightIndex));
            System.out.println("│");




            System.out.print("│");
            System.out.print(TILES.get(leftIndex) instanceof City ? "ㅡㅡㅡㅡㅡㅡㅡㅡㅡ":"                  ");
            System.out.print("│");

            for (int i = 0; i < 9; i++) {
                System.out.print(i!=8?"                   ":"                  │");
            }

            System.out.print(TILES.get(rightIndex) instanceof City?"ㅡㅡㅡㅡㅡㅡㅡㅡㅡ":"                  ");
            System.out.println("│");





            System.out.print("│");
            if(TILES.get(leftIndex) instanceof City) {
                /*if (((City) TILES.get(leftIndex)).getVilla() != null) System.out.print(" 별장│");
                else*/
                    System.out.print("     │");

                /*if (((City) TILES.get(leftIndex)).getBuilding() != null) System.out.print(" 빌딩│");
                else*/
                    System.out.print("     │");

                /*if (((City) TILES.get(leftIndex)).getHotel() != null) System.out.print(" 호텔 ");
                else*/
                    System.out.print("      ");
            } else {
                System.out.print("                  ");
            }
            System.out.print("│");

            for (int i = 0; i < 9; i++) {
                System.out.print(i!=8?"                   ":"                  │");
            }

            if(TILES.get(rightIndex) instanceof City) {
                /*if (((City) TILES.get(rightIndex)).getVilla() != null) System.out.print(" 별장│");
                else*/
                System.out.print("     │");

                /*if (((City) TILES.get(rightIndex)).getBuilding() != null) System.out.print(" 빌딩│");
                else*/
                System.out.print("     │");

                /*if (((City) TILES.get(rightIndex)).getHotel() != null) System.out.print(" 호텔 ");
                else*/
                System.out.print("      ");
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

        int prefix = (TILE_WIDTH - tile.getName().length());
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

        if(index == player.getCurPos()) {
            int prefix = (TILE_WIDTH * 2 - checkPlayerNameLength(player.getPlayerName()))/2;
            int suffix = prefix;
            suffix += (checkPlayerNameLength(player.getPlayerName()) % 2 == 1)? 1: 0;

            for (int j = 0; j < prefix; j++) {
                System.out.print(" ");
            }

            System.out.printf("%s", player.getPlayerName());

            for (int k = 0; k < suffix; k++) {
                System.out.print(" ");
            }
            // System.out.print(" ");
        } else {
            for (int j = 0; j < TILE_WIDTH; j++) {
                System.out.print(" ");
                System.out.print(" ");
            }
        }
    }

    // 영문자와 한글간의 칸수 설정을 위한 메소드
    public int checkPlayerNameLength(String playerName) {
        int length = 0;

        for (int i = 0; i < playerName.length(); i++) {
            if (playerName.charAt(i) >= 'a' && playerName.charAt(i) <= 'z'
                || playerName.charAt(i) >= 'A' && playerName.charAt(i) <= 'Z'
                || playerName.charAt(i) >= '1' && playerName.charAt(i) <= '9')
                length++;
            else
                length += 2;
        }

        return length;
    }
}
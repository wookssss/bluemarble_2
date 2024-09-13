package itschool.bluemarble.progress;

import itschool.bluemarble.exception.event.HoldableKeyEvent;
import itschool.bluemarble.exception.violation.PlayerHasNoMoneyViolation;
import itschool.bluemarble.model.entity.Dice;
import itschool.bluemarble.model.entity.goldenKey.GoldenKey;
import itschool.bluemarble.model.entity.Player;
import itschool.bluemarble.model.entity.tile.Tile;
import itschool.bluemarble.model.entity.tile.abs.City;
import itschool.bluemarble.model.entity.tile.abs.PurchasableTile;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

// 상속받아 추상메서드를 구현하며 콘솔 출력을 담당
public class GameByConsole extends Game {
    private static final Scanner sc = new Scanner(System.in);

    final private int TILE_WIDTH = 9; // 콘솔에 타일 폭 확인
    final private int MORE_PLAYER_START_MONEY = 2_880_000;
    final private int TWO_PLAYER_START_MONEY = MORE_PLAYER_START_MONEY * 2;


    private GameByConsole(int numberOfPlayer) {
        super(numberOfPlayer);
        setPlayer(numberOfPlayer);
    }

    private void setPlayer(int numberOfPlayer) {

        System.out.println("============================================================================================");
        System.out.println("플레이어명은 한글 1~5자, 영문 또는 숫자 1~10자로 입력이 가능합니다.");
        System.out.println("============================================================================================");

        for(int i = 0; PLAYERS.size() < numberOfPlayer; i++) {
            System.out.print("플레이어" + (i+1) + " 이름 입력 : ");

            String playerName = sc.nextLine().trim();

            int nameLength = checkPlayerNameLength(playerName);

            if(nameLength > 10 || nameLength < 1) {
                System.out.println("글자 제한을 초과하셨습니다. 다시 입력해주세요.");
                i--;
            } else if(isExistsDuplicateName(playerName)) {
                System.out.println("이미 입력한 플레이어 이름입니다. 다시 입력해주세요.");
                i--;
            } else {
                if(numberOfPlayer == 2) {
                    PLAYERS.add(new Player(playerName, TWO_PLAYER_START_MONEY)); // name을 세팅할 생성자 필요
                } else PLAYERS.add(new Player(playerName, MORE_PLAYER_START_MONEY)); // name을 세팅할 생성자 필요
            }
        }
        System.out.println("============================================================================================\n");
    }

    public static GameByConsole createGameByConsole(int numberOfPlayer) {
        return new GameByConsole(numberOfPlayer);
    }

    @Override
    public void showMap() {
        showHeaderOrFooterTiles(true);

        showMiddleTiles();

        showHeaderOrFooterTiles(false);

        System.out.println();
        System.out.println();
    }

    private void showHeaderOrFooterTiles(boolean isHeader) {

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

    private void showTileName(Tile tile) {

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

    private void showPlayerLocation(Player player, int index) {

        if(index == player.getLocation()) {
            int check = checkPlayerNameLength(player.getName()+'*');
            int prefix = (TILE_WIDTH * 2 - check)/2;
            int suffix = prefix;
            suffix += (check % 2 == 1)? 1: 0;

            for (int j = 0; j < prefix; j++) {
                System.out.print(" ");
            }

            System.out.printf("%s", player.getName()+'*');

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
    private int checkPlayerNameLength(String playerName) {
        int length = 0;

        for (int i = 0; i < playerName.length(); i++) {
            if (playerName.charAt(i) >= '!' && playerName.charAt(i) <= '~')
                length++;
            else
                length += 2;
        }

        return length;
    }

    // 영문자와 한글간의 칸수 설정을 위한 메소드
    private boolean isExistsDuplicateName (String playerName) {
        for (int i = 0; i < PLAYERS.size(); i++) {
            if(PLAYERS.get(i).getName().equals(playerName))
                return true;
        }
        return false;
    }

    @Override
    public boolean confirm(String message) {
        while(true) {
            System.out.print(message + " (y/n)\n> ");
            String input = sc.nextLine().trim();

            if("n".equalsIgnoreCase(input))
                return false;
            else if ("y".equalsIgnoreCase(input))
                return true;
            else
                return false;
        }
    }

    @Override
    public void confirmToUseGoldenKey(Player player, GoldenKey goldenKey) throws HoldableKeyEvent {
        if(confirm(player.getName() + "님 " + goldenKey.getTitle() + "을 사용하시겠습니까?")) {
            try {
                GoldenKey needUse = player.useGoldenKey(goldenKey);
                throw new HoldableKeyEvent(needUse.getTitle());
            } catch (RuntimeException e) { // 황금열쇠가 존재하지 않음
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public boolean confirmToBuyPurchasableTile(Player player, PurchasableTile tile) throws PlayerHasNoMoneyViolation {
        boolean needBuy = confirm(player.getName() + "님 " + tile.getName() + "(" + formatWithCommas(tile.getPrice()) + "원)을/를 구입하시겠습니까?");
        // System.out.println(player.getName() + "님이 " + tile.getName() + "의 구입을 진행합니다.");
        // System.out.println(player.getName() + "님이 " + tile.getName() + "의 구입 의사가 없습니다.");
        // 수정 중
        if(needBuy) {
            System.out.println(player.getName() + "님이 " + tile.getName() + "의 구입을 진행합니다.");
            player.buyLand(tile);
            Collections.sort(player.getMyLandList(), ((o1, o2) -> {
                return TILES.indexOf(o1) - TILES.indexOf(o2);
            }));
        } else {
            System.out.println(player.getName() + "님이 " + tile.getName() + "의 구입 의사가 없습니다.");
        }

        return needBuy;
    }

    @Override
    public void confirmToBuyConstruction(Player player, City city) throws PlayerHasNoMoneyViolation {
        if(city.getConstructionType() == null) {
            boolean needBuy = confirm("내 땅에 도착했습니다!! 건물을 구매하시겠습니까?");
            if(needBuy) {
                while(true) {
                    System.out.println("빌라 가격 : " + formatWithCommas(city.getColor().getVillaPrice()));
                    System.out.println("빌딩 가격 : " + formatWithCommas(city.getColor().getBuildingPrice()));
                    System.out.println("호텔 가격 : " + formatWithCommas(city.getColor().getHotelPrice()));
                    System.out.println("건설한 건물을 선택하세요. (빌라 : v | 빌딩 : b | 호텔 : h)");
                    String str = sc.next();
                    switch (str) {
                        case "V": case "v":
                            city.buyVilla(player);
                            System.out.println(player.getName() + "님이 "+ city.getName() + "에 빌라를 구입하셨습니다.");
                            return;
                        case "B": case "b":
                            city.buyBuilding(player);
                            System.out.println(player.getName() + "님이 "+ city.getName() + "에 빌딩을 구입하셨습니다.");
                            return;
                        case "H": case "h":
                            city.buyHotel(player);
                            System.out.println(player.getName() + "님이 "+ city.getName() + "에 호텔을 구입하셨습니다.");
                            return;
                    }
                }
            }
        }
    }

    public static int requestTileIndex(Player player) {
        int tileIndex = -1;

        do {
            try {
                System.out.print(player.getName() + "님, 이동할 타일번호를 입력하세요. (0 ~ 39) :");
                tileIndex = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("유효한 숫자를 입력해주세요.");
            } finally {
                sc.nextLine(); // 개행 버퍼 제거용
            }
        } while(tileIndex < 0 || tileIndex > 39);

        return tileIndex;
    }

    private void doThreadSleep(int sec, String message) {

        try {
            int totalMilliseconds = Math.max(sec * 1000, 1); // 최소 1 밀리초로 설정
            int elapsedMilliseconds = 0; // 경과된 시간
            int printInterval = 330; // 출력 주기 (밀리초)

            boolean needLineBreak = (sec != 0);

            // 메시지 출력
            message = (sec > 0) ? sec + message : message;
            if (needLineBreak) {
                System.out.println(message);
            } else {
                System.out.print(message);
            }

            if (sec > 0) {
                // sec가 0보다 클 때
                while (elapsedMilliseconds < totalMilliseconds) {
                    int remainingTime = (totalMilliseconds - elapsedMilliseconds) / 1000; // 남은 초

                    if (remainingTime > 0) {
                        System.out.print(remainingTime); // 남은 시간을 출력
                    }

                    // 지정된 시간 동안 대기
                    for (int j = 0; j < 3; j++) {
                        System.out.print(".");
                        Thread.sleep(printInterval);
                        elapsedMilliseconds += printInterval;
                        if (elapsedMilliseconds >= totalMilliseconds) {
                            break; // 전체 대기 시간을 초과하면 루프 종료
                        }
                    }

                    // 남은 시간이 있을 경우 줄 바꿈
                    if (remainingTime > 0) {
                        System.out.println();
                    }
                }
            } else {
                // sec가 0일 때
                for (int i = 0; i < 3; i++) {
                    System.out.print(".");
                    Thread.sleep(printInterval);
                }
                System.out.println();
            }

            System.out.println();

            throw new InterruptedException("출력 타이머 끝");

        } catch (InterruptedException e) {}
    }

    @Override
    public void printOutDiceResult(Player player, Dice dice) {
        System.out.println(dice.toString(player));
    }

    @Override
    public void printOutOfDrawedGoldenKey(Player player, GoldenKey goldenKey) {
        doThreadSleep(0, "황금열쇠 화면을 출력합니다.");
        System.out.println("\n===================================   황금열쇠 드로우    ===================================\n");
        System.out.println(player.getName() + "님이 황금 열쇠를 뽑습니다.");
        System.out.println(goldenKey);
        System.out.println();
        System.out.println("============================================================================================\n");
    }

    @Override
    public void printOutOfException(RuntimeException exception) {
        doThreadSleep(0, "이벤트가 발생했습니다.");
        System.out.println("\n=====================================     이벤트 발생     =====================================");
        System.out.println(exception.getMessage());
        System.out.println("============================================================================================\n");
    }
    @Override
    public void printOutOfMoving(Player player) {
        doThreadSleep(0, "도착지 정보를 찾고 있습니다.");

        System.out.println("=====================================     이동 페이즈     =====================================\n");
        System.out.println(TILES.get(player.getLocation()).getName() + "(으)로 이동합니다.\n");
        System.out.println("============================================================================================\n");

        doThreadSleep(0, "해당 타일로 이동합니다.");
    }

    @Override
    public void printOutOfPlayerInfo(Player player) {
        System.out.println("============================================================================================\n");
        doThreadSleep(0, "사용자 정보를 찾는 중입니다");

        System.out.println(player);
    }

    @Override
    public void choiceTile(Player player) {
        System.out.println("============================================================================================\n");
        doThreadSleep(0, "우주여행을 시작합니다.");

        // 우주여행 타일 선택 메소드
        int index = requestTileIndex(player);

        player.moveByAbsoluteValue(index);
    }

    // 숫자 출력시 3자리수 , 추가
    public static String formatWithCommas(int number){
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(number);
    }

    @Override
    public void printOutOfIslandCount(Player player) {

    }
}
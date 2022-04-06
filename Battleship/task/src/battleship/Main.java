package battleship;

import org.jetbrains.annotations.NotNull;
import java.util.*;
import static java.util.Collections.swap;

public class Main {

    public static void main(String[] args) {

        Players players = new Players();
        for (int i = 0; i < 2; i++) {
            System.out.println(players.getCurrentPlayerName() + ", place your ships to the game field\n");
            players.setTableToCurrentPlayer(getTableFromInput());
            players.switchPlayers();
        }

        System.out.println("The game starts!\n");
        boolean result = false;
        while(!result) {
            result = game(players.currentPlayer());
            players.switchPlayers();
        }
    }

    static boolean game(Players.@NotNull Player player){
        boolean error;
        List<String> input = null;

        FogOfWar fog = player.getFog();
        player.showField();
        System.out.println(player.getName() + ", it's your turn:\n");
        error = true;
        while (error) {
            input = getInput();
            error = isThereErrorShot(input);
            System.out.println();
        }
        fog.takeShot(input, player); // player for table output
        return fog.isGameEnd();
    }

    static @NotNull Table getTableFromInput(){
        Table table = new Table();
        Ships ships = new Ships();
        List<String> input = null;
        boolean error;

        table.showField();
        Ships.Ship ship = ships.nextShip();
        while (ship != null) {
            System.out.println("Enter the coordinates of the " + ship.getName() +
                    "(" + ship.getLength() + " cells):\n");
            error = true;
            while (error) {
                input = getInput();
                error = isThereErrorPlacing(ship, input, table);
                System.out.println();
            }
            table.placeShip(input);
            ship = ships.nextShip();
            table.showField();
        }
        return table;
    }


    // check shot input for errors. If OK returns FALSE
    static boolean isThereErrorShot(@NotNull List<String> input) {
        if (input.size() != 1 || input.get(0).length() < 2 || input.get(0).length() > 3) {
            System.out.println("\nError! Wrong Invalid input! Try again:");
            return true;
        }
        input.set(0, input.get(0).toUpperCase());
        input.add(input.get(0).toCharArray()[0] + "");
        input.set(0, new StringBuilder(input.get(0)).deleteCharAt(0).toString());
        swap(input, 0, 1);
        if (!Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10").contains(input.get(1)) ||
                !"ABCDEFGHIJ".contains(input.get(0))) {
            System.out.println("\nError! Wrong coordinates! Try again:");
            return true;
        }
        return false;
    }

    //if error occurs print message and returns true, takes non-formatted input
    static boolean isThereErrorPlacing(Ships.Ship ship, @NotNull List<String> input, Table table) {
        if (input.size() != 2 || input.get(0).length() < 2 || input.get(0).length() > 3 ||
                input.get(1).length() < 2 || input.get(1).length() > 3 ||
                !"ABCDEFGHIJ".contains(input.get(0).toUpperCase().toCharArray()[0] + "") ||
                !"ABCDEFGHIJ".contains(input.get(1).toUpperCase().toCharArray()[0] + "") ||
                !"123456789".contains(input.get(0).toUpperCase().toCharArray()[1] + "") ||
                !"123456789".contains(input.get(1).toUpperCase().toCharArray()[1] + "")) {
            System.out.println("\nError! Invalid input! Try again:");
            return true;
        }
        if (input.get(0).length() == 3 && input.get(0).toUpperCase().toCharArray()[2] != '0' && input.get(0).toUpperCase().toCharArray()[1] != '1' ||
                input.get(1).length() == 3 && input.get(1).toUpperCase().toCharArray()[2] != '0' && input.get(1).toUpperCase().toCharArray()[1] != '1') {
            System.out.println("\nError! Invalid input! Try again:");
            return true;
        }

        // formatting input for more convenience use (now elements at (0,1) and (2,3) indexes accordingly)
        input.set(0, input.get(0).toUpperCase());
        input.set(1, input.get(1).toUpperCase());
        input.add(input.get(0).toCharArray()[0] + "");
        input.add(input.get(1).toCharArray()[0] + "");
        input.set(0, new StringBuilder(input.get(0)).deleteCharAt(0).toString());
        input.set(1, new StringBuilder(input.get(1)).deleteCharAt(0).toString());
        swap(input, 2, 0);
        swap(input, 2, 1);
        swap(input, 2, 3);

        int length;
        if (input.get(0).equals(input.get(2))) {
            length = Math.abs(Integer.parseInt(input.get(1)) - Integer.parseInt(input.get(3))) + 1;
            input.remove(2);
        } else if (Integer.parseInt(input.get(1)) == Integer.parseInt(input.get(3))) {
            length = Math.abs(input.get(0).toCharArray()[0] - input.get(2).toCharArray()[0]) + 1;
            input.remove(3);
            swap(input, 0, 1);
        } else {
            System.out.println("\nError! Wrong ship location! Try again:");
            return true;
        }
        if ("ABCDEFGHIJ".contains(input.get(0)) && Integer.parseInt(input.get(1)) > Integer.parseInt(input.get(2)) ||
                !"ABCDEFGHIJ".contains(input.get(0)) && input.get(1).toCharArray()[0] > input.get(2).toCharArray()[0]) {
            swap(input, 1, 2);
        }
        if (length != ship.getLength()) {
            System.out.println("\nError! Wrong length of the " + ship.getName() + "! Try again:");
            return true;
        }
        // for that moment, input formatted such as the first element is the line in which ship is placed and 2 and 3 elements are coordinates
        if ("ABCDEFGHIJ".contains(input.get(0))) {
            int i = table.getIndexByLetter(input.get(0));
            for (int j = Integer.parseInt(input.get(1)); j <= Integer.parseInt(input.get(2)); j++) {
                if (!table.isPlaceable(i, j)) {
                    System.out.println("\nError! Can't place a ship here! Try again:");
                    return true;
                }
            }
        } else {
            int j = table.getIndexByNumber(input.get(0));
            for (int i = table.getIndexByLetter(input.get(1)); i <= table.getIndexByLetter(input.get(2)); i++) {
                if (!table.isPlaceable(i, j)) {
                    System.out.println("\nError! Can't place a ship here! Try again:");
                    return true;
                }
            }
        }
        return false;
    }

    // gets user input
    static @NotNull List<String> getInput() {
        Scanner scanner = new Scanner(System.in);

        List<String> input = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        if (input.get(0).equals("")) {
            input.remove(0);
        }
        return input;
    }
}

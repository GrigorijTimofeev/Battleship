package battleship;

import org.jetbrains.annotations.NotNull;

import java.util.*;

// wrapper for Table class
public class FogOfWar {

    private final Table table;
    private final List<List<String>> field;
    private boolean gameEnd = false;

    FogOfWar(Table table) {
        this.table = table;
        field = Arrays.asList(
                Arrays.asList(" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"),
                Arrays.asList("A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"),
                Arrays.asList("B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"),
                Arrays.asList("C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"),
                Arrays.asList("D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"),
                Arrays.asList("E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"),
                Arrays.asList("F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"),
                Arrays.asList("G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"),
                Arrays.asList("H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"),
                Arrays.asList("I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"),
                Arrays.asList("J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~")
        );
    }

    void showField() {
        for (List<String> line : field) {
            for (String str : line) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
//        System.out.println();
    }

    private boolean checkIfDestroyed(List<List<String>> copy, int i, int j) {
        if (i < 1 || j < 1 || i > 10 || j > 10)
            return true;
        if (copy.get(i).get(j).equals("O")) {
            return false;
        } else if (!copy.get(i).get(j).equals("X")) {
            return true;
        }
        copy.get(i).set(j, "-");
        return (checkIfDestroyed(copy,i + 1, j) && checkIfDestroyed(copy,i - 1, j) &&
                checkIfDestroyed(copy, i, j + 1) && checkIfDestroyed(copy, i, j - 1));
    }

    // also shows field (from player instance)
    void takeShot(@NotNull List<String> coordinates, Players.Player player) {
        int i = table.getIndexByLetter(coordinates.get(0));
        int j = table.getIndexByNumber(coordinates.get(1));

        if (table.get(i, j).equals("X")) {
            player.showField();
            System.out.println("You hit a ship!\n");
            return;
        }
        if (table.get(i, j).equals("M")) {
//            player.showField();
            System.out.println("You missed!");
            return;
        }

        boolean result = table.takeShot(coordinates);
        if (!result) {
            set("M", i, j);
//            player.showField();
            System.out.println("You missed!");
        } else {
            set("X", i, j);
            player.showField();
            List<List<String>> copy = new ArrayList<>(table.field.size());
            for ( int iii = 0; iii < table.field.size(); iii++ ) {
                copy.add(new ArrayList<>());
                for (String s : table.field.get(iii)) {
                    copy.get(iii).add(s);
                }
            }
            boolean check = checkIfDestroyed(copy, i, j);
            if (check) {
                table.reduceAmount();
            }
            if (check && isGameEnd()) {
                System.out.println("You sank the last ship. You won. Congratulations!\n");
            } else if (check){
                System.out.println("You sank a ship!");
            } else {
                System.out.println("You hit a ship!");
            }
        }
    }

    public boolean isGameEnd() {
        if (table.getAmount() == 0) {
            gameEnd = true;
        }
        return gameEnd;
    }

    void set(String str, int i, int j) {
        field.get(i).set(j, str);
    }
}

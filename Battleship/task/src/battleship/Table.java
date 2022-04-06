package battleship;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {

    private enum Letters {
        x, A, B, C, D, E, F, G, H, I, J
    }
    protected List<List<String>> field;
    private int amount = 0; // for check when a ship is destroyed

    Table() {
        field = new ArrayList<>();
        field.add(Arrays.asList(" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        for (int i = 1; i < Letters.values().length; i++) {
            field.add(new ArrayList<>(11));
            field.get(i).add(Letters.values()[i].toString());
            for (int j = 0; j < 10; j++) {
                field.get(i).add("~");
            }
        }
    }

    // done true if table should be filled

    Table(boolean done) {
        this();
        if (done) {
            amount = 5;
            field = Arrays.asList(
                    Arrays.asList(" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"),
                    Arrays.asList("A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"),
                    Arrays.asList("B", "~", "O", "~", "~", "~", "~", "~", "~", "~", "~"),
                    Arrays.asList("C", "~", "O", "~", "O", "~", "~", "~", "~", "~", "~"),
                    Arrays.asList("D", "~", "O", "~", "O", "~", "O", "~", "O", "~", "~"),
                    Arrays.asList("E", "~", "O", "~", "O", "~", "O", "~", "O", "~", "~"),
                    Arrays.asList("F", "~", "O", "~", "O", "~", "O", "~", "O", "~", "~"),
                    Arrays.asList("G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"),
                    Arrays.asList("H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"),
                    Arrays.asList("I", "~", "~", "~", "~", "~", "O", "O", "~", "~", "~"),
                    Arrays.asList("J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~")
            );
        }
    }

    // call this method when all ships are set on the board
    void showField() {
        for (List<String> line : field) {
            for (String str : line) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // THIS METHOD ISN'T CHECKING IF WE CAN PLACE SHIP OE NOT!!!
    // takes formatted input (List<String> { "A", "1", "3" } or equals meaning)
    void placeShip(@NotNull List<String> coordinates) {
        String line = coordinates.get(0);
        int begin;
        int end;

        if ("ABCDEFGHIJ".contains(line)) {
            begin = this.getIndexByNumber(coordinates.get(1));
            end = this.getIndexByNumber(coordinates.get(2));
            int i = this.getIndexByLetter(line);
            for (int j = begin; j <= end; j++) {
                this.set("O", i, j);
            }
        } else {
            begin = this.getIndexByLetter(coordinates.get(1));
            end = this.getIndexByLetter(coordinates.get(2));
            int j = this.getIndexByNumber(line);
            for (int i = begin; i <= end; i++) {
                this.set("O", i, j);
            }
        }
        amount++;
    }

    // returns true if there's '~' character on point
    boolean checkPoint(int i, int j) {
        if (!(i <= 0 || j <= 0 || i >= field.size() || j >= field.get(0).size()))
            return this.get(i, j).equals("~");
        return true;
    }

    // checks if you can put 1 ship block by that coordinate
    boolean isPlaceable(int i, int j) {
        return checkPoint(i, j) && checkPoint(i + 1, j) && checkPoint(i + 1, j - 1) &&
                checkPoint(i + 1, j + 1) && checkPoint(i, j - 1) && checkPoint(i, j + 1) &&
                checkPoint(i - 1, j) && checkPoint(i - 1, j - 1) && checkPoint(i - 1, j + 1);
    }

    //returns true if a shot is hit ship
    boolean takeShot(@NotNull List<String> coordinates) {
        boolean result = true;
        int i = getIndexByLetter(coordinates.get(0));
        int j = getIndexByNumber(coordinates.get(1));
        if (get(i, j).equals("~") || get(i, j).equals("M")) {
            set("M", i, j);
            result = false;
        } else {
            set("X", i, j);
        }
        return result;
    }
    String get(int i, int j) {
        return field.get(i).get(j);
    }

    void set(String str, int i, int j) {
        field.get(i).set(j, str);
    }

    int getIndexByLetter(String str) {
        return Letters.valueOf(str).ordinal();
    }

    int getIndexByNumber(String str) {
        return field.get(0).indexOf(str);
    }

    public int getAmount() {
        return amount;
    }

    public void reduceAmount() {
        if (amount != 0) {
            amount--;
        }
    }
}

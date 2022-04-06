package battleship;

import java.util.ArrayList;
import java.util.List;


public class Ships {

    static class Ship {
        private final String name;
        private final int length;
        boolean isPlaced = false;

        Ship(String name, int length) {
            this.name = name;
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public int getLength() {
            return length;
        }

    }

    List<Ship> ships;
    Ship previousShip = null;

    Ships(){
        ships = new ArrayList<Ship>();
        ships.add(new Ship("Aircraft Carrier", 5));
        ships.add(new Ship("Battleship", 4));
        ships.add(new Ship("Submarine", 3));
        ships.add(new Ship("Cruiser", 3));
        ships.add(new Ship("Destroyer", 2));
    }

    Ship nextShip(){
        if (previousShip != null) {
            previousShip.isPlaced = true;
        }
        for (Ship ship : this.ships) {
            if (!ship.isPlaced) {
                previousShip = ship;
                return ship;
            }
        }
        return null;
    }


}

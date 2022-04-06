package battleship;

import java.util.Scanner;

public class Players {

    static class Player {

        private final String name;
        private Table table = null;
        private FogOfWar fog = null;

        Player(String name){
            this.name = name;
        }

        FogOfWar getFog() {
            return fog;
        }

        public Table getTable() {
            return table;
        }

        public void setTable(Table table) {
            this.table = table;
        }

        public void setFog(Table table) {
            this.fog = new FogOfWar(table);
        }

        public String getName() {
            return name;
        }

        public void showField() {
            this.getFog().showField();
            System.out.println("---------------------");
            this.getTable().showField();
        }

    }

    private int currentPlayerId;
    private final Player player1;
    private final Player player2;

    Players() {
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
        currentPlayerId = 1;
    }

    String getCurrentPlayerName(){
        if (currentPlayerId == 1) {
            return player1.getName();
        } else {
            return player2.getName();
        }
    }

    Player currentPlayer(){
        if (currentPlayerId == 1){
            return player1;
        } else {
            return player2;
        }
    }

    void switchPlayers(){
        promptEnterKey();
        if (currentPlayerId == 1){
            currentPlayerId = 2;
        } else {
            currentPlayerId = 1;
        }
    }

    void setTableToCurrentPlayer(Table table){
        if (currentPlayerId == 1){
            player1.setTable(table);
            player2.setFog(table);
        } else {
            player2.setTable(table);
            player1.setFog(table);
        }
    }

    private void promptEnterKey() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press Enter and pass the move to another player");
        scanner.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}

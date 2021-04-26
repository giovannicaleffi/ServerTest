package org.example;

import java.util.ArrayList;

public class Game {
    private ArrayList<String> players = new ArrayList<>();


    public void addUsername(String username){
        players.add(username);
    }

    public ArrayList<String> getPlayers() {
        return players;
    }
}

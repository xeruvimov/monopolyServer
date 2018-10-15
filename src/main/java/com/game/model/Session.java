package com.game.model;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private Long id;
    private List<Player> listPlayers;
    private Integer playersCount;

    public Session(Long id) {
        this.listPlayers = new ArrayList<Player>();
        this.id = id;
        this.playersCount = 0;
    }

    public Session(Long id, List<Player> listPlayers) {
        this.id = id;
        this.listPlayers = listPlayers;
        this.playersCount = listPlayers.size();
    }

    public Long getId() {
        return id;
    }

    public List<Player> getListPlayers() {
        return listPlayers;
    }

    public Integer getPlayersCount() {
        return playersCount;
    }
}

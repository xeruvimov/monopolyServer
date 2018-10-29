package com.game.serviceiterface;

import com.game.model.Player;

import java.util.List;

public interface PlayerService {
    Player getById(Long id);

    List<Player> getAll();
}

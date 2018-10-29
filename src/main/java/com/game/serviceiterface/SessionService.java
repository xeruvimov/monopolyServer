package com.game.serviceiterface;

import com.game.model.Player;
import com.game.model.Session;

import java.util.List;

public interface SessionService {
    List getAllSession();

    Session addPlayerToSessionById(Long sessionId, Long playerId);

    Session save(Session session);

    Session findById(Long id);
}
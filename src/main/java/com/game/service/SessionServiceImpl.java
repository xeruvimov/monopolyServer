package com.game.service;


import com.game.model.Session;
import com.game.repository.SessionRepository;
import com.game.serviceiterface.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    SessionRepository sessionRepository;

    @Override
    public List getAllSession() {
        return sessionRepository.findAllWithPlayers();
    }

    @Override
    public Session addPlayerToSessionById(Long sessionId, Long playerId) {
        return sessionRepository.addPlayerToSessionById(sessionId, playerId);
    }

    @Override
    public Session save(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public Session findById(Long id) {
        return sessionRepository.findById(id);
    }
}

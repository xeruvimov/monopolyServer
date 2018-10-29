package com.game.repository;

import com.game.model.Player;
import com.game.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class SessionRepository {
    @PersistenceContext
    private EntityManager em;
    private final PlayerRepository playerRepository;

    @Autowired
    public SessionRepository(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Transactional(readOnly = true)
    public List<Session> findAll() {
        return em.createNamedQuery("Session.findAll", Session.class).getResultList();
    }

    public Session save(Session session) {
        if (session.getId() == null) {
            em.persist(session);
        } else {
            em.merge(session);
        }
        return session;
    }

    @Transactional(readOnly = true)
    public List<Session> findAllWithPlayers() {
        return em.createNamedQuery("Session.findAllWithPlayers", Session.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Session findById(Long id) {
        TypedQuery<Session> query = em.createNamedQuery("Session.findById", Session.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Transactional
    public Session addPlayerToSessionById(Long sessionId, Long playerId) {
        Session session = this.findById(sessionId);
        Player player = playerRepository.getOne(playerId);
        session.addPlayer(player);
        return this.save(session);
    }
}

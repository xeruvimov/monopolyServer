package com.game.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class GameStateRepository {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    public GameStateRepository() {
    }

    //TODO репозиторий до конца
}

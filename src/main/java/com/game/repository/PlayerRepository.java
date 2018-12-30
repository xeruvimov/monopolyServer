package com.game.repository;

import com.game.model.Player;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PlayerRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public Player findOne(Long id){
        return em.createNamedQuery("Player.findOne", Player.class).setParameter("id", id).getSingleResult();
    }

    @Transactional(readOnly = true)
    public List<Player> findAll(){
        return em.createNamedQuery("Player.findAll", Player.class).getResultList();
    }

    @Transactional
    public Player save(Player player){
        if (player.getId() == null){
            em.persist(player);
        } else {
            em.merge(player);
        }
        return player;
    }


}

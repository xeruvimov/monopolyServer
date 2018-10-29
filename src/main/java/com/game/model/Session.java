package com.game.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sessions")
@NamedQueries({
        @NamedQuery(name = "Session.findAll", query = "select c from Session c"),
        @NamedQuery(name = "Session.findById",
                query = "select distinct  c from Session c left join fetch c.listPlayers where c.id = :id"),
        @NamedQuery(name = "Session.findAllWithPlayers",
                query = "select distinct c from Session c left join fetch c.listPlayers")
})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {
    private Long id;
    private List<Player> listPlayers;
    private String sessionName;

    public Session() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "session")
    public List<Player> getListPlayers() {
        return listPlayers;
    }

    public void setListPlayers(List<Player> listPlayers) {
        this.listPlayers = listPlayers;
    }

    @Column(name = "name_session")
    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public boolean addPlayer(Player player){
        player.setSession(this);
        return this.listPlayers.add(player);
    }

    public boolean removePlayer(Player player){
        return this.listPlayers.remove(player);
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", listPlayers=" + listPlayers +
                ", sessionName='" + sessionName + '\'' +
                '}';
    }
}



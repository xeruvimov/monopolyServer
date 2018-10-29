package com.game.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "players")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Player {
    private static Random rnd = new Random();
    private Long id;
    private String userName;
    private Session session;

    public Player() {
    }

    public Player(String userName, Long id) {
        this.id = id;
        this.userName = userName;
    }

    public int rollDice() {
        return rnd.nextInt(6) + 1;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @ManyToOne
    @JoinColumn(name = "session_id")
    @JsonBackReference
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}

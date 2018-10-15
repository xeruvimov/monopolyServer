package com.game.model;


import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "players")
public class Player {
    private static Random rnd = new Random();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;

    public Player() {
    }

    public Player(String userName, Long id) {
        this.id = id;
        this.userName = userName;
    }

    public int rollDice() {
        return rnd.nextInt(6) + 1;
    }

    public String getUserName() {
        return userName;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}

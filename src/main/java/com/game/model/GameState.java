package com.game.model;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "game_state")
@NamedQueries({
        @NamedQuery(name = "State.findAll", query = "select s from GameState s"),
        @NamedQuery(name = "State.findById", query = "select distinct s from GameState s where s.id = :id")
})
public class GameState {
    private static Random rnd = new Random();
    private Long id;
    private Integer place;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "place")
    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }
}

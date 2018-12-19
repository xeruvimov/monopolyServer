package com.game.repository;

import com.game.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

//TODO переделать на нормальный репозиторий
public interface PlayerRepository extends JpaRepository<Player, Long> {
}

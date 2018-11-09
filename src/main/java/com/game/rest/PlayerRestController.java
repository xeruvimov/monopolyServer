package com.game.rest;

import com.game.model.Player;
import com.game.serviceiterface.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players/")
public class PlayerRestController {

    @Autowired
    PlayerService playerService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Player> getPlayer(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<Player>(HttpStatus.BAD_REQUEST);
        }
        Player player = playerService.getById(id);
        if (player == null) {
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Player>(player, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> result = this.playerService.getAll();
        if (result.isEmpty()) {
            return new ResponseEntity<List<Player>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Player>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        return new ResponseEntity<Player>(playerService.save(player), HttpStatus.OK);
    }
}

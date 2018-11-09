package com.game.rest.action;

import com.game.action.RollDice;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/action/")
public class ActionRestController {


    @RequestMapping(value = "rolldice/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RollDice> rollDice(@RequestBody RollDice rollDice){
        rollDice.rollDice();
        return new ResponseEntity<RollDice>(rollDice, HttpStatus.OK);
    }
}

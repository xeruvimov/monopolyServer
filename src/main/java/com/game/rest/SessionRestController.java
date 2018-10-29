package com.game.rest;

import com.game.model.Session;
import com.game.serviceiterface.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sessions/")
public class SessionRestController {

    private final SessionService sessionService;

    @Autowired
    public SessionRestController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Session> saveSession(@RequestBody @Valid Session session) {
        HttpHeaders headers = new HttpHeaders();

        if (session == null) {
            return new ResponseEntity<Session>(HttpStatus.BAD_REQUEST);
        }

        this.sessionService.save(session);
        return new ResponseEntity<Session>(session, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Session>> getAllSessions() {
        List customers = this.sessionService.getAllSession();

        if (customers.isEmpty()) {
            return new ResponseEntity<List<Session>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Session>>(customers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Session> getById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<Session>(HttpStatus.BAD_REQUEST);
        }

        Session result = this.sessionService.findById(id);

        if (result == null) {
            return new ResponseEntity<Session>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Session>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "{sessionId}/add/{playerId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Session> addPlayerToSessionById(@PathVariable("sessionId") Long sessionId,
                                                          @PathVariable("playerId") Long playerId) {
        if (sessionId == null || playerId == null) {
            return new ResponseEntity<Session>(HttpStatus.BAD_REQUEST);
        }

        Session result = this.sessionService.addPlayerToSessionById(sessionId, playerId);

        if (result == null) {
            return new ResponseEntity<Session>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Session>(result, HttpStatus.OK);
    }
}

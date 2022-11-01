package com.QuickPollAPI.QuickPollLab.controller;


import com.QuickPollAPI.QuickPollLab.polls.Poll;
import com.QuickPollAPI.QuickPollLab.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@RestController
public class PollController {

    @Autowired
    private PollRepository pollRepository;


    @GetMapping("/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls(){
        Iterable<Poll> allPolls = pollRepository.findAll();
        return new ResponseEntity<>(allPolls, HttpStatus.OK);
    }

    //@RequestMapping(value="/polls", method=RequestMethod.POST)
    @PostMapping("/polls")
    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {

        poll = pollRepository.save(poll);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
        //@RequestMapping(value="/polls/{pollId}", method=RequestMethod.GET)
        @GetMapping("/polls/{pollId}")
        public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
            Optional<Poll> p = pollRepository.findById(pollId);
            return new ResponseEntity<> (p, HttpStatus.OK);
        }
    //@RequestMapping(value="/polls/{pollId}", method=RequestMethod.PUT)
    @PutMapping("/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        // Save the entity
        Poll p = pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //@RequestMapping(value="/polls/{pollId}", method=RequestMethod.DELETE)
    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        pollRepository.deleteById(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


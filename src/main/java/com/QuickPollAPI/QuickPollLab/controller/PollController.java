package com.QuickPollAPI.QuickPollLab.controller;


import com.QuickPollAPI.QuickPollLab.polls.Poll;
import com.QuickPollAPI.QuickPollLab.repository.PollRepository;
import com.QuickPollAPI.QuickPollLab.services.PollServices;
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
    private PollServices pollServices;


    @GetMapping("/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        return pollServices.getAllPolls();
    }


    //@RequestMapping(value="/polls", method=RequestMethod.POST)
    @PostMapping("/polls")
    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
        return pollServices.createPoll(poll);
    }
        //@RequestMapping(value="/polls/{pollId}", method=RequestMethod.GET)
        @GetMapping("/polls/{pollId}")
        public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        pollServices.verifyPoll(pollId);
        return pollServices.getPoll(pollId);
        }

    //@RequestMapping(value="/polls/{pollId}", method=RequestMethod.PUT)
    @PutMapping("/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        pollServices.verifyPoll(pollId);
        pollServices.updatePoll(poll, pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //@RequestMapping(value="/polls/{pollId}", method=RequestMethod.DELETE)
    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        pollServices.verifyPoll(pollId);
        return pollServices.deletePoll(pollId);
    }
}


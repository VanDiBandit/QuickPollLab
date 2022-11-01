package com.QuickPollAPI.QuickPollLab.controller;

import com.QuickPollAPI.QuickPollLab.polls.Vote;
import com.QuickPollAPI.QuickPollLab.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class VoteController {
    @Autowired
    private VoteRepository voteRepository;

    //@RequestMapping(value="/polls/{pollId}/votes", method= RequestMethod.POST)
    @PostMapping("/polls/{pollId}/votes")
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote) {
            vote = voteRepository.save(vote);

            // Set the headers for the newly created resource
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setLocation(ServletUriComponentsBuilder.
                    fromCurrentRequest().path("/{id}").buildAndExpand(vote.getId()).toUri());

            return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
        }
    }

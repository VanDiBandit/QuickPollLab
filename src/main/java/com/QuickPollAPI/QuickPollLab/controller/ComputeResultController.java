package com.QuickPollAPI.QuickPollLab.controller;

import com.QuickPollAPI.QuickPollLab.count.OptionCount;
import com.QuickPollAPI.QuickPollLab.count.VoteResult;
import com.QuickPollAPI.QuickPollLab.polls.Vote;
import com.QuickPollAPI.QuickPollLab.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
    public class ComputeResultController {

        @Autowired
        private VoteRepository voteRepository;

    @GetMapping("/computeresult")
    public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteRepository.findByPoll(pollId);

        int totalVotes = 0;
        Map<Long, OptionCount> tempMap = new HashMap<Long, OptionCount>();

        for (Vote v : allVotes) {

            totalVotes++;

            OptionCount optionCount = tempMap.get(v.getOptions().getId());

            if (optionCount == null) {

                optionCount = new OptionCount();
                optionCount.setOptionId(v.getOptions().getId());
                tempMap.put(v.getOptions().getId(), optionCount);

            }
            optionCount.setCount(optionCount.getCount() + 1);
        }

        voteResult.setTotalVotes(totalVotes);
        voteResult.setResults(tempMap.values());

        return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);

    }
}


package com.QuickPollAPI.QuickPollLab.repository;

import com.QuickPollAPI.QuickPollLab.polls.Vote;
import org.springframework.data.repository.CrudRepository;


public interface VoteRepository extends CrudRepository<Vote, Long> {

}

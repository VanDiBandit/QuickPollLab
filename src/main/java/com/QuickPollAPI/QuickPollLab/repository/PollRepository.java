package com.QuickPollAPI.QuickPollLab.repository;

import com.QuickPollAPI.QuickPollLab.polls.Poll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PollRepository extends CrudRepository<Poll, Long> {
}

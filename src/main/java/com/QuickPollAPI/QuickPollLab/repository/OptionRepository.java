package com.QuickPollAPI.QuickPollLab.repository;

import com.QuickPollAPI.QuickPollLab.polls.Options;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends CrudRepository<Options, Long> {

}
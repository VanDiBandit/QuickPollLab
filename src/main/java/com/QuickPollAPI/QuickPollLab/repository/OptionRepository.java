package com.QuickPollAPI.QuickPollLab.repository;

import com.QuickPollAPI.QuickPollLab.polls.Options;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Options, Long> {

}
package com.QuickPollAPI.QuickPollLab.polls;


import javax.persistence.*;
@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="VOTE_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name="OPTION_ID")
    private Options options;

    public Vote() {
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Options getOptions() {

        return options;
    }

    public void setOptions(Options options) {

        this.options = options;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", options=" + options +
                '}';
    }
}
package com.QuickPollAPI.QuickPollLab.polls;

import javax.persistence.*;

@Entity
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "OPTIONS_ID")
    private Long id;

    @Column(name = "OPTIONS_VALUE")
    private String value;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }

    @Override
    public String toString() {
        return "Options{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
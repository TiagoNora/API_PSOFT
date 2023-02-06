package com.psoft.project.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class VoteDTO {
    private boolean vote;
    @JsonCreator
    public VoteDTO(@JsonProperty("vote") boolean vote) {
        this.vote = vote;
    }

    public boolean getVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }
}

package com.psoft.project.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ChangeStatus {
    private boolean approved;
    @JsonCreator
    public ChangeStatus(@JsonProperty("approved") boolean approved) {
        this.approved = approved;
    }

    public boolean getApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}

package com.psoft.project;

import com.psoft.project.model.Vote;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoteTests {
    @Test
    public void create_vote(){
        boolean status = true;
        Vote vote = new Vote(status);
        assertEquals(true, vote.isVote());

    }
}

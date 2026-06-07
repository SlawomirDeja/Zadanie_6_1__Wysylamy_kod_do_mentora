package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User user1 = new Millenials("user1");
        User user2 = new YGeneration("user2");
        User user3 = new ZGeneration("user3");
        //When
        //Then
        assertEquals("Facebook", user1.sharePost());
        assertEquals("Twitter", user2.sharePost());
        assertEquals("Snapchat", user3.sharePost());
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User user1 = new Millenials("user1");
        //When
        user1.setSharingStrategy(new TwitterPublisher());
        //Then
        assertEquals("Twitter", user1.sharePost());
    }
}

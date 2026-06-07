package com.kodilla.patterns.strategy.social;

public final class TwitterPublisher implements SocialPublisher {

    @Override
    public String share() {

        System.out.println("Twitter");
        return "Twitter";
    }
}

package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int uniqueUserIdentifier;
    private final String username;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int numberOfPostsPublished;

    public ForumUser(final int uniqueUserIdentifier, final String username, final char sex,
                     final LocalDate dateOfBirth, final int numberOfPostsPublished) {
        this.uniqueUserIdentifier = uniqueUserIdentifier;
        this.username = username;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.numberOfPostsPublished = numberOfPostsPublished;
    }

    public int getUniqueUserIdentifier() {
        return uniqueUserIdentifier;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfPostsPublished() {
        return numberOfPostsPublished;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "uniqueUserIdentifier=" + uniqueUserIdentifier +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfPostsPublished=" + numberOfPostsPublished +
                '}';
    }
}

package com.kodilla.testing.forum.statistics;

public class ForumStatisticsCalculator {

    private int numberOfUsers = 0;
    private int numberOfPosts = 0;
    private int numberOfComments = 0;
    private float averageNumberOfPostsPerUser = 0;
    private float averageNumberOfCommentsPerUser = 0;
    private float averageNumberOfCommentsPerPost = 0;

    private boolean numberOfUsersDivisionByZero;
    private boolean numberOfPostsDivisionByZero;

    public float getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public float getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    public float getAverageNumberOfCommentsPerPost() {
        return averageNumberOfCommentsPerPost;
    }

    public boolean isNumberOfUsersDivisionByZero() {
        return numberOfUsersDivisionByZero;
    }

    public boolean isNumberOfPostsDivisionByZero() {
        return numberOfPostsDivisionByZero;
    }

    public void calculateAdvStatistics(Statistics statistics) {

        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();

        if (numberOfUsers == 0) {
            numberOfUsersDivisionByZero = true;
        } else {
                numberOfUsersDivisionByZero = false;
                averageNumberOfPostsPerUser = (float) numberOfPosts / numberOfUsers;
                averageNumberOfCommentsPerUser = (float) numberOfComments / numberOfUsers;
        }

        if (numberOfPosts == 0) {
            numberOfPostsDivisionByZero = true;
        } else {
                numberOfPostsDivisionByZero = false;
                averageNumberOfCommentsPerPost = (float) numberOfComments / numberOfPosts;
        }

    }

}

package com.kodilla.exception.test;

public class ExceptionHandling {

    public void handle(double x, double y) {
        SecondChallenge secondChallenge = new SecondChallenge();
        String resultProbablyIWillThrowException = "";

        try {
            resultProbablyIWillThrowException = secondChallenge.probablyIWillThrowException(x, y);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (!resultProbablyIWillThrowException.isEmpty()) {
                System.out.println(resultProbablyIWillThrowException);
            }
        }
    }
}

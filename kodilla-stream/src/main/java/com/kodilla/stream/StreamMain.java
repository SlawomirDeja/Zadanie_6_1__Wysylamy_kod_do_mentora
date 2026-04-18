package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {

    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Beautiful string", string -> "ABC" + string);
        poemBeautifier.beautify("Google Chrome", string -> string + "ABC");
        poemBeautifier.beautify("Microsoft Store", string -> string.toUpperCase());
        poemBeautifier.beautify("File Explorer", string -> string.repeat(3));
        poemBeautifier.beautify("Windows Media Player", string -> {

            String resultString = "1 ";

            for (int i = 0; i < 5; i++)
                 resultString += string + " " + string.charAt(i) + " ";

            return resultString;
                                                                                                });

        poemBeautifier.beautify("Apple iPhone", string -> {

            String resultString = "2 ";

            resultString += string.replace('l', '1');
            resultString += " " + resultString.replace('e', '3');
            return resultString;
                                                                                                });

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}

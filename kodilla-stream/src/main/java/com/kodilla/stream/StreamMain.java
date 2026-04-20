package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;
import com.kodilla.stream.person.People;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

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


        // ------------------- Begin of task 7.1 ------------------------------

        System.out.println("\nBegin of task 7.1");

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
        System.out.println("End of task 7.1\n");

        // ------------------ End of task 7.1 -----------------------

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        People.getList().stream()
                .forEach(System.out::println);

        BookDirectory theBookDirectory = new BookDirectory();

        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));             // [1]

        System.out.println("# elements: " + theResultMapOfBooks.size());             // [2]
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())                   // [3]
                .forEach(System.out::println);

        String theResultStringOfBooks = theBookDirectory.getList().stream()  // [1]
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));                    // [2]

        System.out.println(theResultStringOfBooks);

        // ------------------- Begin of task 7.3 ------------------------------

        System.out.println("\nBegin of task 7.3");

        Forum forum = new Forum();

        Map<Integer, ForumUser> theResultMapOfForumUsers = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser ->
                        Period.between(forumUser.getDateOfBirth(), LocalDate.now()).getYears() >= 20)
                .filter(forumUser -> forumUser.getNumberOfPostsPublished() >= 1)
                .collect(Collectors.toMap(ForumUser::getUniqueUserIdentifier, forumUser -> forumUser));

        theResultMapOfForumUsers.entrySet().stream().map(entry -> entry.getKey() + " " +
                entry.getValue()).forEach(System.out::println);

        System.out.println("End of task 7.3\n");

        // ------------------- End of task 7.3 --------------------------------
    }
}

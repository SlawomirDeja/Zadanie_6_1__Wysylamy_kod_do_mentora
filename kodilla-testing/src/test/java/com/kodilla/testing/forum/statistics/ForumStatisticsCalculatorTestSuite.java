package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.library.Book;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsCalculatorTestSuite {

    private List<String> generateListOfNUserNames(int userNamesQuantity) {
        List<String> resultList = new ArrayList<>();
        for (int n = 1; n <= userNamesQuantity; n++)
            resultList.add("username" + n);
        return resultList;
    }

    @Mock
    private Statistics statisticsMock;


    private ForumStatisticsCalculator forumStatisticsCalculator;

    @BeforeEach
    void createForumStatisticsCalculator() {
        forumStatisticsCalculator = new ForumStatisticsCalculator();
    }

    @Test
    void testCalculateAdvStatisticsTheNumberOfPostsIs0() {
        //Given
        List<String> resultUsersNames = generateListOfNUserNames(3);
        when(statisticsMock.usersNames()).thenReturn(resultUsersNames);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(9);
        //When
        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatisticsCalculator.getAverageNumberOfPostsPerUser());
        assertEquals(3, forumStatisticsCalculator.getAverageNumberOfCommentsPerUser());
        assertTrue(forumStatisticsCalculator.isNumberOfPostsDivisionByZero());
    }

    @Test
    void testCalculateAdvStatisticsTheNumberOfPostsIs1000() {
        //Given
        List<String> resultUsersNames = generateListOfNUserNames(4);
        when(statisticsMock.usersNames()).thenReturn(resultUsersNames);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(40);
        //When
        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(250, forumStatisticsCalculator.getAverageNumberOfPostsPerUser());
        assertEquals(10, forumStatisticsCalculator.getAverageNumberOfCommentsPerUser());
        assertEquals((float) 40 / 1000, forumStatisticsCalculator.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsTheNumberOfCommentsIs0() {
        //Given
        List<String> resultUsersNames = generateListOfNUserNames(4);
        when(statisticsMock.usersNames()).thenReturn(resultUsersNames);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(250, forumStatisticsCalculator.getAverageNumberOfPostsPerUser());
        assertEquals(0, forumStatisticsCalculator.getAverageNumberOfCommentsPerUser());
        assertEquals(0, forumStatisticsCalculator.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsTheNumberOfCommentsIsLessThanTheNumberOfPosts() {
        //Given
        List<String> resultUsersNames = generateListOfNUserNames(4);
        when(statisticsMock.usersNames()).thenReturn(resultUsersNames);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);
        //When
        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(25, forumStatisticsCalculator.getAverageNumberOfPostsPerUser());
        assertEquals((float) 50 / 4, forumStatisticsCalculator.getAverageNumberOfCommentsPerUser());
        assertEquals((float) 50 / 100, forumStatisticsCalculator.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsTheNumberOfCommentsIsGreaterThanTheNumberOfPosts() {
        //Given
        List<String> resultUsersNames = generateListOfNUserNames(4);
        when(statisticsMock.usersNames()).thenReturn(resultUsersNames);
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);
        //When
        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals((float) 50 / 4, forumStatisticsCalculator.getAverageNumberOfPostsPerUser());
        assertEquals(25, forumStatisticsCalculator.getAverageNumberOfCommentsPerUser());
        assertEquals(2, forumStatisticsCalculator.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsTheNumberOfUsersIs0() {
        //Given
        List<String> resultUsersNames = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(resultUsersNames);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(100);
        //When
        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertTrue(forumStatisticsCalculator.isNumberOfUsersDivisionByZero());
        assertEquals(10, forumStatisticsCalculator.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsTheNumberOfUsersIs100() {
        //Given
        List<String> resultUsersNames = generateListOfNUserNames(100);
        when(statisticsMock.usersNames()).thenReturn(resultUsersNames);
        when(statisticsMock.postsCount()).thenReturn(60);
        when(statisticsMock.commentsCount()).thenReturn(150);
        //When
        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals((float) 60 / 100, forumStatisticsCalculator.getAverageNumberOfPostsPerUser());
        assertEquals((float) 150 / 100, forumStatisticsCalculator.getAverageNumberOfCommentsPerUser());
        assertEquals((float) 150 / 60, forumStatisticsCalculator.getAverageNumberOfCommentsPerPost());
    }

}

package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";

        // When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement2.execute(sqlProcedureCall);
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        // Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
        statement2.close();
    }

    @Test
    void testUpdateBestsellers() throws SQLException {

        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER = 0";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable1 = "SELECT COUNT(*) AS HOW_MANY_FALSE FROM BOOKS WHERE BESTSELLER = 0";
        String sqlCheckTable2 = "SELECT COUNT(*) AS HOW_MANY_TRUE FROM BOOKS WHERE BESTSELLER = 1";

        //When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement.execute(sqlProcedureCall);
        ResultSet rs = statement.executeQuery(sqlCheckTable1);
        ResultSet rs2 = statement2.executeQuery(sqlCheckTable2);

        //Then
        int howManyFalse = -1;
        if (rs.next()) {
            howManyFalse = rs.getInt("HOW_MANY_FALSE");
        }
        int howManyTrue = -1;
        if (rs2.next()) {
            howManyTrue = rs2.getInt("HOW_MANY_TRUE");
        }
        assertEquals(4, howManyFalse);
        assertEquals(1, howManyTrue);

        rs.close();
        rs2.close();
        statement.close();
        statement2.close();
    }
}
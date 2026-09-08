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
        Statement statement = dbManager.getConnection().createStatement();
        statement.addBatch("""
            CREATE TABLE BOOKS2 (
                BOOK_ID int(11) NOT NULL AUTO_INCREMENT,
                TITLE varchar(255) NOT NULL,
                PUBYEAR int(4) NOT NULL,
                BESTSELLER boolean,
                PRIMARY KEY (BOOK_ID)
            );
        """);

        statement.addBatch("""
            INSERT INTO BOOKS2 (TITLE, PUBYEAR, BESTSELLER)
                VALUES
                    ('title1', '1942', FALSE),
                    ('title2', '1927', FALSE),
                    ('title3', '1925', FALSE),
                    ('title4', '1943', FALSE),
                    ('title5', '1933', FALSE);
        """);

        statement.addBatch("""
            CREATE TABLE RENTS2 (
                RENT_ID int(11) NOT NULL AUTO_INCREMENT,
                BOOK_ID int(11) NOT NULL,
                READER_ID int(11) NOT NULL,
                RENT_DATE datetime NOT NULL,
                RETURN_DATE datetime,
                PRIMARY KEY (RENT_ID),
                FOREIGN KEY (BOOK_ID) REFERENCES BOOKS(BOOK_ID),
                FOREIGN KEY (READER_ID) REFERENCES READERS(READER_ID)
            );
        """);

        statement.addBatch("""
            INSERT INTO RENTS2 (BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
                VALUES
                    (1, 1, '2026-08-17 00:00:00', null),
                    (2, 1, '2026-08-17 00:00:00', null),
                    (4, 1, '2026-08-17 00:00:00', '2026-08-22 00:00:00'),
                    (1, 3, '2026-08-19 00:00:00', null),
                    (5, 3, '2026-08-23 00:00:00', '2026-08-25 00:00:00'),
                    (5, 4, '2026-08-17 00:00:00', '2026-08-19 00:00:00'),
                    (5, 5, '2026-08-19 00:00:00', null),
                    (1, 3, '2026-08-26 00:00:00', null),
                    (2, 3, '2026-08-29 00:00:00', null),
                    (3, 1, '2026-08-26 00:00:00', null),
                    (2, 4, '2026-08-28 00:00:00', '2026-08-31 00:00:00');
        """);

        statement.executeBatch();

        String sqlCheckTable1 = "SELECT COUNT(*) AS HOW_MANY_FALSE FROM BOOKS2 WHERE BESTSELLER = 0";
        String sqlCheckTable2 = "SELECT COUNT(*) AS HOW_MANY_TRUE FROM BOOKS2 WHERE BESTSELLER = 1";

        //When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateBestsellers2()";
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
        assertEquals(2, howManyFalse);
        assertEquals(3, howManyTrue);

        rs.close();
        rs2.close();

        statement.addBatch("DROP TABLE BOOKS2;");
        statement.addBatch("DROP TABLE RENTS2;");
        statement.executeBatch();

        statement.close();
        statement2.close();
    }
}
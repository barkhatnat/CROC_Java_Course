package ru.croc.barkhatnat.homework8.task15;

import java.sql.SQLException;
import java.util.List;

import static ru.croc.barkhatnat.homework8.task15.CsvFileReader.readCsv;
import static ru.croc.barkhatnat.homework8.task15.DbActions.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        String fileInfo = "HomeTasks\\src\\ru\\croc\\barkhatnat\\homework8\\task15\\info.csv";
//        String fileInfo = "C:\\Users\\Mvideo\\Documents\\GitHub\\CROC_Java_Course\\HomeTasks\\src\\ru\\croc\\barkhatnat\\homework8\\task15\\info.csv";
        try {
            List<List<String>> records = readCsv(args[0]);
            createDb();
            fillDb(records);
            showDb();
            closeDb();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

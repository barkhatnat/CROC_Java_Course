package ru.croc.barkhatnat.homework8.task15;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DbActions {
    static String connectionUrl = "jdbc:h2:mem:/test";
    static String user = "sa";
    static String password = "";
    public static Statement statement;
    public static Connection connection;

    public static void connectDb() throws SQLException {
        connection = DriverManager.getConnection(connectionUrl, user, password);
        statement = connection.createStatement();
    }

    public static void createDb() throws SQLException {
        DbActions.connectDb();
        statement.executeUpdate("CREATE TABLE client (id integer primary key , surname varchar NOT NULL , name varchar NOT NULL , phone_number varchar NOT NULL UNIQUE)");
        statement.executeUpdate("CREATE TABLE pet (medical_card integer primary key , name varchar NOT NULL , age integer NOT NULL )");
        statement.executeUpdate("CREATE TABLE client_pet_composition (id integer AUTO_INCREMENT PRIMARY KEY,client_id integer references client(id) ON DELETE CASCADE , pet_id integer references pet(medical_card) ON DELETE CASCADE, UNIQUE (pet_id, client_id))");
    }

    public static void fillDb(List<List<String>> records) throws SQLException {
        String sql;
        List<List<String>> clients = new ArrayList<>();
        List<List<String>> compositions = new ArrayList<>();
        List<List<String>> pets = new ArrayList<>();
        for (List<String> record : records) {
            List<String> compositionInfo = new ArrayList<>();
            clients.add(record.subList(0, 4));
            pets.add(record.subList(4, 7));
            compositionInfo.add(record.get(0));
            compositionInfo.add(record.get(4));
            compositions.add(compositionInfo);
        }
        clients = clients.stream().distinct().collect(Collectors.toList());
        pets = pets.stream().distinct().collect(Collectors.toList());
        for (List<String> client : clients) {
            sql = "INSERT INTO client VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(client.get(0)));
            preparedStatement.setString(2, client.get(1));
            preparedStatement.setString(3, client.get(2));
            preparedStatement.setString(4, client.get(3));
            preparedStatement.executeUpdate();
        }

        for (List<String> pet : pets) {
            sql = "INSERT INTO pet VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(pet.get(0)));
            preparedStatement.setString(2, pet.get(1));
            preparedStatement.setInt(3, Integer.parseInt(pet.get(2)));
            preparedStatement.executeUpdate();
        }

        for (List<String> composition : compositions) {
            sql = "INSERT INTO client_pet_composition (client_id, pet_id) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(composition.get(0)));
            preparedStatement.setInt(2, Integer.parseInt(composition.get(1)));
            preparedStatement.executeUpdate();
        }
    }

    public static void showDb() throws SQLException {
        showClients();
        showPets();
        showComposition();
    }

    public static void showClients() throws SQLException {
        ResultSet clientResult = statement.executeQuery("select * from client");
        System.out.print("TABLE CLIENT\n");
        while (clientResult.next()) {
            System.out.print("ID: " + clientResult.getInt("id"));
            System.out.print(", Surname: " + clientResult.getString("surname"));
            System.out.print(", Name: " + clientResult.getString("name"));
            System.out.print(", Phone: " + clientResult.getString("phone_number") + "\n");
        }
        ResultSet petResult = statement.executeQuery("select * from pet");
    }

    public static void showPets() throws SQLException {
        ResultSet petResult = statement.executeQuery("select * from pet");
        System.out.print("TABLE PET\n");
        while (petResult.next()) {
            System.out.print("ID: " + petResult.getInt("medical_card"));
            System.out.print(", Name: " + petResult.getString("name"));
            System.out.print(", Age: " + petResult.getInt("age") + "\n");
        }
    }

    public static void showComposition() throws SQLException {
        ResultSet compositionResult = statement.executeQuery("select * from client_pet_composition");
        System.out.print("TABLE CLIENT_PET_COMPOSITION\n");
        while (compositionResult.next()) {
            System.out.print("ID " + compositionResult.getInt("id"));
            System.out.print(", ID of client: " + compositionResult.getInt("client_id"));
            System.out.print(", ID of pet: " + compositionResult.getInt("pet_id") + "\n");
        }
    }

    public static void closeDb() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}

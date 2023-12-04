package ru.croc.barkhatnat.homework8.task16.classes;

import ru.croc.barkhatnat.homework8.task15.DbActions;
import ru.croc.barkhatnat.homework8.task16.exceptions.IdException;
import ru.croc.barkhatnat.homework8.task16.exceptions.NewEntityException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    final Connection connection = DbActions.connection;

    public Client createClient(Client client) throws SQLException, NewEntityException {
        Statement statement = connection.createStatement();
        ResultSet phoneNumberFromClient = statement.executeQuery("SELECT phone_number FROM client");
        List<String> phoneNumbers = new ArrayList<>();
        while (phoneNumberFromClient.next()) {
            phoneNumbers.add(phoneNumberFromClient.getString("phone_number"));
        }
        if (phoneNumbers.contains(client.getPhoneNumber())) {
            throw new NewEntityException("Client with this phone number already exists");
        }
        String sql = "INSERT INTO client VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, client.getId());
        preparedStatement.setString(2, client.getSurname());
        preparedStatement.setString(3, client.getName());
        preparedStatement.setString(4, client.getPhoneNumber());
        preparedStatement.executeUpdate();
        return client;
    }

    public Client findClient(Integer id) throws SQLException, IdException {
        String sql = "SELECT * FROM client WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet clientResult = preparedStatement.executeQuery();
        if (clientResult.next()) {
            return new Client(clientResult.getInt("id"), clientResult.getString("surname"), clientResult.getString("name"), clientResult.getString("phone_number"));
        }
        throw new IdException("There is no client with this id");
    }

    public Client updateClient(Client client) throws SQLException {
        String sql = "UPDATE client SET surname = ?, name = ?, phone_number = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, client.getSurname());
        preparedStatement.setString(2, client.getName());
        preparedStatement.setString(3, client.getPhoneNumber());
        preparedStatement.setInt(4, client.getId());
        preparedStatement.execute();
        sql = "SELECT * FROM client WHERE id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, client.getId());
        ResultSet clientResult = preparedStatement.executeQuery();
        if (clientResult.next()) {
            return new Client(clientResult.getInt("id"), clientResult.getString("surname"), clientResult.getString("name"), clientResult.getString("phone_number"));
        }
        return client;
    }

    public void deleteClient(Integer id) throws SQLException {
        String sql = "DELETE FROM client WHERE id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }
    public List<Pet> getAllPetsOf(Client client) throws SQLException {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet JOIN client_pet_composition ON pet.medical_card = client_pet_composition.pet_id WHERE client_pet_composition.client_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, client.getId());
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            pets.add(new Pet(result.getInt("medical_card"), result.getString("name"), result.getInt("age")));
        }
        return pets;
    }
}

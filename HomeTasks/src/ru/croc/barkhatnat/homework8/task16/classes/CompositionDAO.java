package ru.croc.barkhatnat.homework8.task16.classes;

import ru.croc.barkhatnat.homework8.task15.DbActions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompositionDAO {
    final Connection connection = DbActions.connection;

    public List<String> findClientPhoneNumbersBy(Pet pet) throws SQLException {
        DbActions.connectDb();
        List<String> numbers = new ArrayList<>();
        String sql = "SELECT phone_number FROM client JOIN client_pet_composition ON client.id = client_pet_composition.client_id WHERE client_pet_composition.pet_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, pet.medicalCard);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            System.out.println(result.getString("phone_number"));
            numbers.add(result.getString("phone_number"));
        }
        return numbers;
    }

    public List<Pet> getAllPetsOf(Client client) throws SQLException {
        DbActions.connectDb();
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet JOIN client_pet_composition ON pet.medical_card = client_pet_composition.pet_id WHERE client_pet_composition.client_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, client.id);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            pets.add(new Pet(result.getInt("medical_card"), result.getString("name"), result.getInt("age")));
        }
        return pets;
    }

}

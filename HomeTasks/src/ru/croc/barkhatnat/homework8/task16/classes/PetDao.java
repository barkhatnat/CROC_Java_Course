package ru.croc.barkhatnat.homework8.task16.classes;

import ru.croc.barkhatnat.homework8.task15.DbActions;
import ru.croc.barkhatnat.homework8.task16.exceptions.IdException;
import ru.croc.barkhatnat.homework8.task16.exceptions.NewEntityException;

import java.sql.*;
import java.util.List;

public class PetDao {
    final Connection connection = DbActions.connection;
    static int currentMedicalCard = 14;

    public Pet createPet(String name, Integer age, List<Client> clients) throws SQLException, NewEntityException {
        DbActions.connectDb();
        String sql = "INSERT INTO pet VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, currentMedicalCard);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, age);
        preparedStatement.executeUpdate();
        for (Client client : clients) {
            sql = "INSERT INTO client_pet_composition (client_id, pet_id) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, client.getId());
            preparedStatement.setInt(2, currentMedicalCard);
            preparedStatement.execute();
        }
        Pet pet = new Pet(currentMedicalCard, name, age);
        currentMedicalCard++;
        return pet;
    }

    //
    public Pet findPet(Integer medicalCardNumber) throws SQLException, IdException {
        DbActions.connectDb();
        String sql = "SELECT * FROM pet WHERE medical_card = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, medicalCardNumber);
        ResultSet petResult = preparedStatement.executeQuery();
        if (petResult.next()) {
            return new Pet(petResult.getInt("medical_card"), petResult.getString("name"), petResult.getInt("age"));
        }
        throw new IdException("There is no pet with this medical card number");
    }

    //
    public Pet updatePet(Pet pet) throws SQLException {
        DbActions.connectDb();
        String sql = "UPDATE pet SET  name = ?, age = ? WHERE medical_card = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, pet.getName());
        preparedStatement.setInt(2, pet.getAge());
        preparedStatement.setInt(3, pet.getMedicalCard());
        preparedStatement.execute();
        sql = "SELECT * FROM pet WHERE medical_card = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, pet.getMedicalCard());
        ResultSet petResult = preparedStatement.executeQuery();
        if (petResult.next()) {
            return new Pet(petResult.getInt("medical_card"), petResult.getString("name"), petResult.getInt("age"));
        }
        return pet;
    }

    public void deletePet(Integer medicalCardNumber) throws SQLException {
        DbActions.connectDb();
        String sql = "DELETE FROM pet WHERE medical_card = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, medicalCardNumber);
        preparedStatement.execute();
    }
}



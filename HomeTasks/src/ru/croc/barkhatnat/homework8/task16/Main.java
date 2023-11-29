package ru.croc.barkhatnat.homework8.task16;

import ru.croc.barkhatnat.homework8.task16.classes.*;
import ru.croc.barkhatnat.homework8.task16.exceptions.IdException;
import ru.croc.barkhatnat.homework8.task16.exceptions.NewEntityException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.croc.barkhatnat.homework8.task15.CsvFileReader.readCsv;
import static ru.croc.barkhatnat.homework8.task15.DbActions.*;

public class Main {
    public static void main(String[] args) {
        String fileInfo = "C:\\Users\\Mvideo\\Documents\\GitHub\\CROC_Java_Course\\HomeTasks\\src\\ru\\croc\\barkhatnat\\homework8\\task15\\info.csv";
        try {
            List<List<String>> records = readCsv(fileInfo);
            createDb();
            fillDb(records);
            System.out.println("Current DB:");
            showDb();
            ClientDao clientDao = new ClientDao();
            PetDao petDao = new PetDao();
            CompositionDAO compositionDAO = new CompositionDAO();

            Client client = clientDao.createClient(new Client(48, "Бархатова", "Наталья", "+78005553535"));
            ArrayList<Client> petMasters = new ArrayList<>();
            petMasters.add(client);
            System.out.println("Client table after adding a new client");
            showClients();
            clientDao.updateClient(new Client(1, "Орлов", "Сергей", "+79999999999"));
            System.out.println("Client table after updating id=1 client");
            showClients();
            System.out.println("Name of client with '7' id is " + clientDao.findClient(7).getName());
            petDao.createPet("Мяука", 3, petMasters);
            petDao.createPet("Ричард", 1, petMasters);
            System.out.println("Pet table after adding a new pets");
            showPets();
            System.out.println("Name of pet with '3' medical card number is " + petDao.findPet(3).getName());
            Pet pupirka = petDao.updatePet(new Pet(1, "Пупырка", 10));
            System.out.println("Pet table after updating id=1 pet");
            showPets();
            System.out.println("Current composition table");
            showComposition();
            clientDao.deleteClient(48);
            System.out.println("Client table after deleting a client");
            showClients();
            System.out.println("Composition table after deleting a client");
            showComposition();

            Client client2 = clientDao.findClient(4);
            System.out.println(compositionDAO.findClientPhoneNumbersBy(pupirka));
            System.out.println(compositionDAO.getAllPetsOf(client2));
        } catch (SQLException | NewEntityException | IdException e) {
            throw new RuntimeException(e);
        }
    }
}

package ru.croc.barkhatnat.homework7.task13;

import ru.croc.barkhatnat.homework7.task13.exceptions.BidException;
import ru.croc.barkhatnat.homework7.task13.exceptions.WinnerException;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, BidException, WinnerException, InterruptedException {
        final int MAX_BID_DIFFERENCE = 1000;

        String fileIot = "HomeTasks\\src\\ru\\croc\\barkhatnat\\homework7\\task13\\Iot.txt";
        String fileParticipants = "HomeTasks\\src\\ru\\croc\\barkhatnat\\homework7\\task13\\participants.txt";
        Item item = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileIot))) {
            String itemName = reader.readLine().trim();
            int startBid = Integer.parseInt(reader.readLine().trim());
            item = new Item(itemName, startBid);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        ArrayList<String> participants = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileParticipants))) {
            String line;
            while ((line = reader.readLine()) != null) {
                participants.add(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Random random = new Random();
        HashMap<String, Integer> bidNumberCounter = new HashMap<>();

        Item finalItem = item;
        class MyRunnable implements Runnable {
            private static final Object lock = new Object();

            public void run() {
                synchronized (lock) {
                    while (LocalDateTime.now().isBefore(finalItem.getStopTime())) {
                        String randomParticipant = participants.get(random.nextInt(participants.size()));
                        int startBid = finalItem.getCurrentBid().get() + 1;
                        int randomIntBid = random.nextInt((MAX_BID_DIFFERENCE + 1)) + startBid;
                        try {
                            finalItem.placeBid(randomParticipant, randomIntBid);
                        } catch (BidException e) {
                            System.out.println(e.getMessage());

                        }
                        if (!bidNumberCounter.containsKey(randomParticipant)){
                            bidNumberCounter.put(randomParticipant, 1);
                        }else{
                            int incrementedValue = bidNumberCounter.get(randomParticipant) + 1;
                            bidNumberCounter.put(randomParticipant, incrementedValue);
                        }
                    }
                }
            }

        }
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Победитель: " + finalItem.getWinnerName() + "\nЛот продан за: " + finalItem.getCurrentBid());
        System.out.println(bidNumberCounter);
    }

}

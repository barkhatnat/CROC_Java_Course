package ru.croc.barkhatnat.homework7.task14;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Client {

    private static Socket clientSocket;
    private static final Object lock = new Object();


    public static void main(String[] args) {
        try {
            clientSocket = new Socket("192.168.1.107", 8080);
            System.out.println("Подключено к серверу...");

            try {
                Scanner userInput = new Scanner(System.in);
                System.out.print("Введите ваш никнейм: ");
                String nickname = userInput.nextLine();
                Thread readerThread = new Thread(new ServerReader(clientSocket));
                readerThread.start();
                try (PrintWriter outClient = new PrintWriter(clientSocket.getOutputStream(), true)) {
                    while (true) {
                        String message = userInput.nextLine();
                        if ("stop".equalsIgnoreCase(message.trim())) {
                            synchronized (lock) {
                                outClient.println(nickname + " покинул чат :(");
                            }
                            break;
                        }

                        synchronized (lock) {
                           String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                            outClient.println("[" + nickname + " " + time + "]: " + message);
                        }
                    }
                }
            } finally {
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class ServerReader implements Runnable {
        private Socket socket;

        public ServerReader(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                Scanner in = new Scanner(socket.getInputStream());
                while (in.hasNextLine()) {
                    synchronized (lock) {
                        String message = in.nextLine();
                        System.out.println(message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
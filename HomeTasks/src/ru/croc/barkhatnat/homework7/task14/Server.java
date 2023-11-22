package ru.croc.barkhatnat.homework7.task14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {

    public static final int PORT = 8080;
    public static LinkedList<HelpServer> serverList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Сервер запущен. Ожидание подключений...");
        try {
            while (true) {
                Socket socket = server.accept();
                System.out.println("Новый клиент подключен...");
                try {
                    serverList.add(new HelpServer(socket));
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}

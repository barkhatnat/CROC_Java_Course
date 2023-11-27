package ru.croc.barkhatnat.homework7.task14;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//import static ru.croc.barkhatnat.homework7.task14.Client.clientSocket;

class HelpServer extends Thread implements AutoCloseable {

    private Socket socket;
    private Scanner in;
    private PrintWriter out;

    public HelpServer(Socket socket) throws IOException {
        this.socket = socket;
        start();
    }

    @Override
    public void run() {
        try {
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            while (!socket.isClosed()) {
                while (true) {
                    if (in.hasNextLine()) {
                        String message = in.nextLine();
                        System.out.println(message);
                        for (HelpServer server : Server.serverList) {
                            if (server != this) {
                                server.out.println(message);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void close() throws IOException {
        socket.close();
        out.close();
        socket.close();
    }
}
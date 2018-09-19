package ru.innopolis.stc9.interact.server;

import ru.innopolis.stc9.interact.Listener;
import ru.innopolis.stc9.interact.client.Client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server {
    public static Integer SERVER_PORT = 4999;

    //TCP socket
    public static void main(String[] args) {
        Listener listenerThread = new Listener(SERVER_PORT);
        listenerThread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try (Socket socket = new Socket("127.0.0.1", Client.CLIENT_PORT);
             BufferedWriter bufferedWriter =
                     new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            Scanner scanner = new Scanner(System.in);
            String message;
            while ((message = scanner.nextLine()) != "") {
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

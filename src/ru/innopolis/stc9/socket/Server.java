package ru.innopolis.stc9.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static Integer SERVER_PORT = 4999;

    //TCP socket
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        serverSocket = new ServerSocket(SERVER_PORT);
        //Enabled on 127.0.0.1:4999
        Socket socket = serverSocket.accept();
        InputStream fromClient = socket.getInputStream();
        OutputStream toClient = socket.getOutputStream();
        BufferedReader clientReader = new BufferedReader(new InputStreamReader(fromClient));
        BufferedWriter clientWriter = new BufferedWriter(new OutputStreamWriter(toClient));
        String message = null;
        while ((message = clientReader.readLine()) != null) {
            System.out.println(message);
            clientWriter.write("\"" + message + "\" received \n");
            clientWriter.flush();
        }
    }
}

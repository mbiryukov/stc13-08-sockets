package ru.innopolis.stc9.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", Server.SERVER_PORT);
        OutputStreamWriter serverOutput = new OutputStreamWriter(socket.getOutputStream());
        InputStreamReader serverInput = new InputStreamReader(socket.getInputStream());
        Scanner scanner = new Scanner(System.in);
        String message;
        BufferedReader bufferedReader = new BufferedReader(serverInput);

        while ((message = scanner.nextLine()) != "") {
            BufferedWriter bufferedWriter = new BufferedWriter(serverOutput);
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            System.out.println("server echo " + bufferedReader.readLine());
        }
    }
}

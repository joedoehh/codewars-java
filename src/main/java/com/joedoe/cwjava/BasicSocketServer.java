package com.joedoe.cwjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicSocketServer {

    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;

    /**
     * Basic Socket Server
     * 6 kyu
     * https://www.codewars.com/kata/6390ea74913c7f000d2e95cd/train/java
     */
    public static void runServer() {
        try {
            serverSocket = new ServerSocket(80);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            final Thread serverthread = new Thread(
                new Runnable() {
                    public void run() {
                        try {
                            while (true) {
                                String input = in.readLine();
                                if (input.contains("exit")) {
                                    System.out.println("stopping server");
                                    stopLoop();
                                    break;
                                }
                                out.write(input + "\n");
                                out.flush();
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            
                    private void stopLoop() throws IOException {
                        in.close();
                        out.close();
                        clientSocket.close();
                        serverSocket.close();
                    }
                }
            );
            serverthread.start();
            System.out.println("Server running");
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }

    }

}
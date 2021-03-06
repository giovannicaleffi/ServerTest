package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private int port;


    public Server(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        Server echoServer = new Server(1234);
        echoServer.startServer();
    }



    public void startServer() {
        ExecutorService executor = Executors.newCachedThreadPool();
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println(e.getMessage()); // Porta non disponibile
            return;
        }

        System.out.println("Server ready");
        while (true) {
            try {

                Socket socket = serverSocket.accept();
                System.out.println("Client Connected!");
                executor.submit(new ClientHandler(socket)); //per ogni socket noi creiamo un thread

            } catch(IOException e) {
                break; // Entrerei qui se serverSocket venisse chiuso
            }
        }
        executor.shutdown();
    }

}

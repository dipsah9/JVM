package Javanetworking;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        int port = 12345;
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server is listeningn on the port"+port);

            while(true){
                //Accepts the client connection 
                Socket socket = serverSocket.accept();
                System.out.println("Client is connected");

                //Handle client communication in new thread 
                new ClientHandler(socket).start();
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

class ClientHandler extends Thread{
    private Socket socket;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try(BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(),true)){
            
            String message; 
             while((message = input.readLine()) != null){
                    System.out.println("Received" + message);
                    output.println("output" + message);
             }

        }catch(IOException ex){
            System.out.println("ClientHandler Exception " + ex.getMessage());
        }
    }


}

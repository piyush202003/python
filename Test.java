import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Test/*server */ {
    public static void main(String[] args) {
        int port = 12345; // Replace with an available port number

        try {
            // Create a ServerSocket
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection established with " + clientSocket.getInetAddress());

            // Setup input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Send a message to the client
            String messageToClient = "Hello from the server!";
            out.println(messageToClient);

            // Receive a message from the client
            String clientMessage = in.readLine();
            System.out.println("Message from client: " + clientMessage);

            // Close the connection
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

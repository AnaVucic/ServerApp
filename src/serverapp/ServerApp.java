package serverapp;

import com.sun.net.httpserver.Request;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Response;

public class ServerApp {
    
    private ServerSocket serverSocket;
    private int port;
    //List<ProcessRequest> users; // u threads

    public static void main(String[] args) {
        ServerApp serverApp = new ServerApp();
        serverApp.startServer();

    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(9000);
            System.out.println("Waiting on clients...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

//            handleRequestTxt(socket);
            handleRequestObject(socket);
        } catch (IOException ex) {
            Logger.getLogger(ServerApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleRequestObject(Socket socket) throws IOException {

        while (true) {
            try {
                ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());

                ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("Waiting for client request...");
                
                Request request = (Request) inSocket.readObject();

                System.out.println(request.toString());
                
                Object result = handleResponseObject(request);
                
                Response response = new Response(result, null); //exception: null ???
                outSocket.writeObject(response);

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ServerApp.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private Object handleResponseObject(Request request) {
        return null;
    }
}

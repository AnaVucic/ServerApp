/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.threads;

import commonlib.domain.GenericEntity;
import commonlib.domain.User;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.Socket;
import java.net.SocketException;
import serverapp.controller.Controller;
import serverapp.view.coordinator.MainCoordinator;
import transfer.Receiver;
import transfer.Request;
import transfer.Response;
import transfer.Sender;

/**
 *
 * @author Lenovo
 */
public class ProcessRequests extends Thread {

    Socket socket;
    Sender sender;
    Receiver receiver;
    User user;

    public ProcessRequests(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!isInterrupted() && !socket.isClosed()) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();
                try {

                    
                    
                    
                    
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                }
                sender.send(response);
            } catch (SocketException ex) {
                //Logger.getLogger(ProcessRequests.class.getName()).log(Level.WARNING, "Client closed the connection forcefully. Logging out the user.", ex);
                try {
                    //Controller.getInstance().logout(user);
                    //MainCoordinator.getInstance().getFormMainController().refreshTbl();
                    socket.close();
                    //Logger.getLogger(ProcessRequests.class.getName()).log(Level.INFO, "User logged out successfully", ex);
                } catch (Exception e) {
                    //Logger.getLogger(ProcessRequests.class.getName()).log(Level.SEVERE, "Error while logging out the user", ex);
                }
            } catch (Exception ex) {
                //Logger.getLogger(ProcessRequests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

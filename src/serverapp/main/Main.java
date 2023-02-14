/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.main;

import serverapp.ServerApp;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import serverapp.view.coordinator.MainCoordinator;
import transfer.Response;
import transfer.Request;

/**
 *
 * @author Lenovo
 */
public class Main {
    
    private ServerSocket serverSocket;
    private int port;
    //List<ProcessRequest> users; // u threads

    public static void main(String[] args) {
        try {
            MainCoordinator.getInstance().openMainForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }
    
    
    
    
    
    
    
}

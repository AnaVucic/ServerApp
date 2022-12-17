/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientapp.communication;

import commonlib.domain.Appointment;
import commonlib.domain.User;
import java.net.Socket;
import java.util.List;
import transfer.Operation;
import transfer.Receiver;
import transfer.Request;
import transfer.Response;
import transfer.Sender;

/**
 *
 * @author Lenovo
 */
public class Communication {
    
    private final Sender sender;
    private final Receiver receiver;
    private static Communication instance;

    private Communication() throws Exception {
        Socket socket = new Socket("localhost", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    // GET_INSTANCE
    public static Communication getInstance() throws Exception {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }
    
    
    // LOGIN
    public User login(String username, String password) throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Request request = new Request(Operation.LOGIN, user);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (User) response.getResult();
        } else {
            throw response.getException();
        }
    }

    // LOGOUT
    public boolean logout(User user) throws Exception {
        Request request = new Request(Operation.LOGOUT, user);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (boolean) response.getResult();
        } else {
            throw response.getException();
        }
    }
    
    // GET ALL APPOINTMENTS
    public List<Appointment> getAllAppointments() throws Exception {
        Request request = new Request(Operation.GET_ALL_APPOINTMENTS, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException() == null) {
            return (List<Appointment>) response.getResult();
        } else {
            throw response.getException();
        }
    }
}

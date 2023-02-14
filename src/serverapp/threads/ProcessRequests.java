/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.threads;

import commonlib.domain.GenericEntity;
import commonlib.domain.User;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import serverapp.controller.Controller;
import serverapp.session.Session;
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

                    switch (request.getOperation()) {
                        case LOGIN:
                            try {
                                GenericEntity object = Controller.getInstance().login((GenericEntity) request.getParam());

                                if (Session.getInstance().getAllUsers().contains(object)) {
                                    response.setException(new Exception("User "
                                        + object + " is already logged in!\n"));
                                } else {
                                    response.setResult(object);
                                    user = (User) object;
                                    Session.getInstance().addUser(user);
                                    //MainCoordinator.getInstance().getFormMainController().refreshTbl();
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                response.setException(ex);
                            }
                        break;
                        case GET_ALL_SALONS:
                            try {
                                List<GenericEntity> salons = Controller.getInstance().getAllSalons();
                                response.setResult(salons);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            response.setException(ex);
                        }
                        break;
                        case GET_ALL_APPOINTMENTS:
                            try {
                            List<GenericEntity> appointments = Controller.getInstance().getAllAppointments();
                            response.setResult(appointments);
                        } catch (Exception e) {
                            e.printStackTrace();
                            response.setException(e);
                        }
                    }

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
                ex.printStackTrace();
            }
        }
    }
}

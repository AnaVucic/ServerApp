/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.view.coordinator;

import serverapp.view.controller.MainController;

/**
 *
 * @author Lenovo
 */
public class MainCoordinator {

    private static MainCoordinator instance;
    private final MainController mainController;

    private MainCoordinator() {
        mainController = new MainController();
    }

    public static MainCoordinator getInstance() {
        if (instance == null) {
            instance = new MainCoordinator();
        }
        return instance;
    }

}

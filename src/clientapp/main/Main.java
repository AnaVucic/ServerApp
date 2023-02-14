package clientapp.main;

import clientapp.view.coordinator.MainCoordinator;


public class Main {
    public static void main(String[] args) {
        MainCoordinator.getInstance().openLoginForm();
    }
}

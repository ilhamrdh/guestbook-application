package com.program;
import com.view.*;

public class Controller {

    private static vLogin login = new vLogin();

    public static void showMainLogin(){
        login.setVisible(false);
        login.initsLogin();
        login.setVisible(true);
    }

    public static void showMainDasboard(){
        vDashboard dashboardAdmin = new vDashboard();
        dashboardAdmin.setVisible(true);
    }
}
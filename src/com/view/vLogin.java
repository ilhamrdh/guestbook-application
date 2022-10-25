package com.view;
import com.templates.cLogin;
import com.partials.*;
import com.program.Controller;

public class vLogin extends cLogin{
    private cFormLable labelUser = new cFormLable("Username",0,157 ,400,true);
    private cTextField txtUser = new cTextField(65,195,270,true);
    private cErrorLable errorUser = new cErrorLable("username kosong!!",0,236,400,true);
    private cFormLable labelPass = new cFormLable("Password",0,268,400,true);
    private cPassField txtPass = new cPassField(65,306,270,true);
    private cErrorLable errorPass = new cErrorLable("password kosong!!",0,346,400,true);
    private cButton btnLogin = new cButton("LOGIN", 135, 390, 129);

    public vLogin(){
        super();
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me){
                
            }
        });
    }

    public void initsLogin(){
        this.setTitle("Login");
        bg.removeAll();
        title.setText("LOGIN ADMIN");
        bg.add(title);
        btnLogin.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae){
                if (txtUser.getText().equalsIgnoreCase("") || String.valueOf(txtPass.getPassword()).equalsIgnoreCase("")) {
                    Controller.showMainDasboard();
                    vLogin.this.dispose();
                    if (txtUser.getText().equalsIgnoreCase("")) {
                        bg.add(errorUser);
                    }
                    if (String.valueOf(txtPass.getPassword()).equalsIgnoreCase("")) {
                        bg.add(errorPass);
                    }
                }
            }
        });
        bg.add(labelUser);
        bg.add(txtUser);
        bg.add(labelPass);
        bg.add(txtPass);
        bg.add(btnLogin);
    }
}

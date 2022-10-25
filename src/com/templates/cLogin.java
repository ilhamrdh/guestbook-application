package com.templates;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import com.partials.cColor;
import com.partials.cFonts;

public abstract class cLogin extends JFrame{

    public JPanel bg = new JPanel();
    public JLabel title = new JLabel("LOGIN");
    
    public cLogin(){
        super();
        setSize(400,570);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(cLogin.EXIT_ON_CLOSE);
        bg.setBackground(cColor.BLUE);
        bg.setBounds(0,0,400,570);
        bg.setLayout(null);

        title.setFont(cFonts.FONT_BOLD);
        title.setForeground(cColor.WHITE);
        title.setBounds(0,75,400,56);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);

        add(title);
        add(bg);
    }
    public cLogin(String title){
        this();
        setTitle(title);
    }
}

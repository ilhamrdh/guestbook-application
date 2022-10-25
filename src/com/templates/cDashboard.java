package com.templates;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import com.partials.cColor;
import com.partials.cFonts;

public abstract class cDashboard  extends JFrame{

    public JPanel sidebar = new JPanel();
    public JPanel header = new JPanel();
    public JPanel main = new JPanel();
    public JPanel content = new JPanel();
    private JLabel appText = new JLabel("MENU");
    public JLabel roleText = new JLabel("DATA TAMU");
    public JLabel menuTitle = new JLabel("Menu Title");

    public cDashboard (){
        super();
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        sidebar.setBackground(cColor.WHITE);
        sidebar.setBounds(0,0,230,720);
        sidebar.setLayout(null);
        
        header.setBackground(cColor.BLUE);
        header.setBounds(230,0,1050,90);
        header.setLayout(null);
        
        main.setBackground(cColor.WHITE_GRAY);
        main.setBounds(230,90,1050,610);
        main.setLayout(null);
        
        content.setBackground(cColor.WHITE);
        content.setBounds(25,76,1000,500);
        content.setLayout(null);

        appText.setFont(cFonts.FONT_BOLD_SIDE);
        appText.setBounds(0,37,230,32);
        appText.setHorizontalAlignment(JLabel.CENTER);
        appText.setVerticalAlignment(JLabel.CENTER);
        appText.setForeground(cColor.BLUE);

        menuTitle.setFont(cFonts.FONT_BOLD);
        menuTitle.setBounds(30,10,600,50);
        menuTitle.setVerticalAlignment(JLabel.CENTER);
        menuTitle.setForeground(cColor.BLACK_GRAY);
        
        roleText.setFont(cFonts.FONT_BOLD);
        roleText.setBounds(20,17,300,65);
        roleText.setVerticalAlignment(JLabel.CENTER);
        roleText.setForeground(cColor.WHITE);

        header.add(roleText);
        sidebar.add(appText);
        main.add(menuTitle);
        main.add(content);
        add(main);
        add(header);
        add(sidebar);
    }
    public cDashboard(String title){
        this();
        setTitle(title);
    }
}

package com.partials;
import javax.swing.JLabel;

public class cSidebarMenu extends JLabel{
    public java.awt.event.MouseAdapter Hover = new java.awt.event.MouseAdapter(){
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e){
            setBackground(cColor.BLUE);
            setForeground(cColor.WHITE);
        }
        public void mouseExited(java.awt.event.MouseEvent e) {
            setBackground(cColor.BLUE);
            setForeground(cColor.WHITE);

        }
    };
    public java.awt.event.MouseAdapter nonHover = new java.awt.event.MouseAdapter(){
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e){
            setBackground(cColor.BLUE);
            setForeground(cColor.WHITE);
        }
        public void mouseExited(java.awt.event.MouseEvent e) {
            setBackground(cColor.WHITE);
            setForeground(cColor.GRAY);

        }
    };
    public cSidebarMenu(String text,int y){
        super();
        setText("   " + text);
        setBounds(0, y, 230, 50);
        setOpaque(true);
        setFont(cFonts.FONT_REGULAR_SIDE);
        setForeground(cColor.GRAY);
        setBackground(cColor.WHITE);
        addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });
        setSidebarnonAktif();
    }
    public void setSidebarAktif() {
        try {
            removeMouseListener(nonHover);
            addMouseListener(Hover);
        } catch (Exception e) {
            
        }
    }
    public void setSidebarnonAktif() {
        try {
            removeMouseListener(Hover);
            addMouseListener(nonHover);
        } catch (Exception e) {
            
        }
    }
}

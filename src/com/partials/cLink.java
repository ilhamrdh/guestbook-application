package com.partials;
import javax.swing.JLabel;

public class cLink extends JLabel{
    public cLink(String text, int y){
        super();
        setText(text);
        setBounds(0, y, 400, 20);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.FONT_REGULAR_LINK);
        setForeground(cColor.WHITE90);
        addMouseListener(new java.awt.event.MouseAdapter(){
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e){
            setCursor( new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
        }
        public void mouseExited(java.awt.event.MouseEvent e){
            setCursor( new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR) );
        }
        });
    }
}

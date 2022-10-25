package com.partials;
import javax.swing.JLabel;

public class cReport extends JLabel{
    public cReport(String text, int y){
        super();
        setText(text);
        setBounds(920, y, 40, 20);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.FONT_REGULAR_LINK);
        setForeground(cColor.BLACK_GRAY);
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

package com.partials;
import javax.swing.JLabel;

public class cLableTambah extends JLabel{
    
    public cLableTambah(String text,int x,int y,int width,boolean centerAlignment){
        super();
        setText(text);
        setBounds(x,y,width,35);
        if (centerAlignment) {
            setHorizontalAlignment(JLabel.CENTER);
        }
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.FONT_MEDIUM);
        setForeground(cColor.BLACK);
    }
}

package com.partials;
import javax.swing.JLabel;

public class cErrorLable  extends JLabel{
    
    public cErrorLable(String text,int x,int y,int width,boolean centerAlignment){
        super();
        setText(text);
        setBounds(x,y,width,15);
        if (centerAlignment) {
            setHorizontalAlignment(JLabel.CENTER);
        }
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.FONT_REGULAR_ERROR);
        setForeground(cColor.RED);
    }
}

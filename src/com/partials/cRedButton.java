package com.partials;
import javax.swing.JButton;

public class cRedButton extends JButton{
    public cRedButton(String text, int x, int y, int width){
        super();
        setText(text);
        setBounds(x, y, width, 35);
        setFont(cFonts.FONT_BUTTON);
        setBackground(cColor.RED);
        setForeground(cColor.WHITE);
        setBorder(null);
        }
}

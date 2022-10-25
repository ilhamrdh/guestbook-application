package com.partials;
import javax.swing.JButton;

public class cButton extends JButton{
    public cButton(String text, int x, int y, int width){
    super();
    setText(text);
    setBounds(x, y, width, 35);
    setFont(cFonts.FONT_BUTTON);
    setBackground(cColor.WHITE);
    setForeground(cColor.BLACK);
    setBorder(null);
    }
}

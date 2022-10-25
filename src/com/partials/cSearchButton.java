package com.partials;
import javax.swing.JButton;

public class cSearchButton extends JButton{
    public cSearchButton(String text, int x, int y, int width){
        super();
        setText(text);
        setBounds(x, y, width, 35);
        setFont(cFonts.FONT_BUTTON);
        setBackground(cColor.WHITE_GRAY_SEARCH);
        setForeground(cColor.BLACK_GRAY);
        setBorder(null);
        }
}

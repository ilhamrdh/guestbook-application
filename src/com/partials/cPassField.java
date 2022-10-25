package com.partials;
import javax.swing.JPasswordField;

public class cPassField extends JPasswordField{
    public cPassField(int x, int y, int widht, boolean centerAlignment){
        super();
        setBounds(x,y,widht,35);
        if (centerAlignment) {
            setHorizontalAlignment(JPasswordField.CENTER);
        }
        setFont(cFonts.FONT_REGULAR);
        setForeground(cColor.BLACK);
        setBorder(new javax.swing.border.LineBorder(cColor.BLACK_GRAY,1));
    }
}

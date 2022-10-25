package com.partials;
import javax.swing.JTextField;

public class cTextField extends JTextField{
    public cTextField(int x, int y, int widht, boolean centerAlignment){
        super();
        setBounds(x,y,widht,35);
        if (centerAlignment) {
            setHorizontalAlignment(JTextField.CENTER);
        }
        
        setFont(cFonts.FONT_REGULAR);
        setForeground(cColor.BLACK);
        setBorder(new javax.swing.border.LineBorder(cColor.BLACK_GRAY,1));
        
    }
}

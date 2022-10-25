package com.partials;
import javax.swing.JTextArea;

public class cTextArea extends JTextArea{
    public cTextArea(boolean editable){
        super();
        setFont(cFonts.FONT_REGULAR);
        setBackground(cColor.WHITE);
        if( editable ){
        setForeground(cColor.BLACK);
        }else{
      setForeground(cColor.RED);
      setEditable(false);
    }
    setLineWrap(true);
    setWrapStyleWord(true);
    }
    public cTextArea (int x, int y, boolean editable){
    this(editable);
    setBounds(x, y, 360, 200);
    }
}

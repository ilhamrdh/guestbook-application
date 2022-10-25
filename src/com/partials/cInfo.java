package com.partials;
import javax.swing.JLabel;

public class cInfo extends JLabel{

    public cInfo(String text, int x, int y){
    super();
    setText(text);
    setBounds(x, y, 600, 40);
    setVerticalAlignment(JLabel.CENTER);
    setFont(cFonts.FONT_BOLD);
    setForeground(cColor.BLACK);
  }
  
}

package com.partials;
import javax.swing.JLabel;

public class cBigFont extends JLabel{
  public cBigFont(String text, int x, int y){
    super();
    setText(text);
    setBounds(x, y, 350, 60);
    setVerticalAlignment(JLabel.CENTER);
    setHorizontalAlignment(JLabel.CENTER);
    setFont(cFonts.FONT_BOLD);
    setForeground(cColor.BLACK_GRAY);
  }
}


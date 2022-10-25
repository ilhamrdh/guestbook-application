package com.partials;
import javax.swing.JTable;

public class cTable extends JTable{
    public cTable (javax.swing.table.TableModel dm){
        super(dm);
        setFont(cFonts.FONT_REGULAR_14);
        getTableHeader().setFont(cFonts.FONT_REGULAR);
        getTableHeader().setBackground(cColor.BLUE);
        getTableHeader().setForeground(cColor.WHITE);
        setRowHeight(35);
        getTableHeader().setReorderingAllowed(false);
        // setShowVerticalLines(false);
        setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        setDragEnabled(true);
        setSelectionBackground(cColor.RED);
        setSelectionForeground(cColor.WHITE);
    }
    @Override
    public boolean isCellEditable(int row,int column){
        return false;
    }
}

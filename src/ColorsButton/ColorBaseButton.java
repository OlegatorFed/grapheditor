/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColorsButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class ColorBaseButton extends JButton{
    public ColorBaseButton(Color color){
        super();
        
        this.setBackground(color);
        this.setVisible(true);
//        this.setBounds(20, 50, 20, 20);
    }
}

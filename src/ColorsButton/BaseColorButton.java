/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColorsButton;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author andr
 */
public abstract class BaseColorButton extends JButton {
    BaseColorButton(String name){
        super(name);
        
    }
    abstract public Color getColor();
        
    
}

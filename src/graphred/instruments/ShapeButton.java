/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphred.instruments;

import javax.swing.JButton;
import save.BaseShape;

/**
 *
 * @author DNS
 */
public abstract class ShapeButton extends JButton{
    ShapeButton(String name) {
        super(name);
        
    }
    public abstract BaseShape getShape();
}

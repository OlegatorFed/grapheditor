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
public class ShapeButton extends JButton{
    BaseShape bs;
    
    public ShapeButton(BaseShape bs) {
        super(bs.getType());
        this.bs = bs;
    }
    public BaseShape getShape(){
        return bs.cloneShape();
    }
}

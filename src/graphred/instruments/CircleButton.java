package graphred.instruments;

import save.BaseShape;
import graphred.shape.CircleShape;
import javax.swing.JButton;


public class CircleButton extends ShapeButton {

    public CircleButton() {
        super("Овал");
    }
//    BaseShape bs = new CircleShape();
    
    public BaseShape getShape(){
        return new CircleShape();
    }
    
}

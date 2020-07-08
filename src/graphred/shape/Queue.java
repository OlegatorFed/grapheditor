/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphred.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import save.BaseShape;

/**
 *
 * @author andr
 */
public class Queue {
    ArrayList<BaseShape> shapes =new ArrayList<>();
    Color Cvet = Color.black;
    public int getSize(){
        return shapes.size();
    }
    public void addShape(BaseShape bt){
        
        shapes.add(bt);
        getLastShape().setColor(Cvet);
    }
    public BaseShape getLastShape(){
        if(shapes.isEmpty()) return null;
        return shapes.get(shapes.size()-1);
    }

    public void paintShapes(Graphics g){
   
       for (BaseShape bs:shapes) {          
           if (bs.getShape() !=null){
           bs.drawShape(g);
           }
       }
    }
    public void setCvetColor(Color color){
        this.Cvet = color;
//        this.getLastShape().setColor(color);
    }

    public Iterable<BaseShape> getShapes() {
        return shapes;
    }
    
    public void refresh() {
		this.shapes.clear();
	}
    
        
  

}


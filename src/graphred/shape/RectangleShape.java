/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphred.shape;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import save.BaseShape;

/**
 *
 * @author andr
 */
public class RectangleShape extends BaseShape {
    double x1;
    double x2;
    double y1;
    double y2;
    int xp,yp;
    Shape shape;
    Color shapeColor;
    
//    ArrayList<Integer> x;
//    ArrayList<Integer> y;
    
    
    public RectangleShape(){
        x1 = 0;
        x2 = 0;
        y1 = 0;
        y2 = 0;
//        this.x = new ArrayList<>();
//        this.y = new ArrayList<>();

     
}
    
    @Override
    public void addFirstCoordinates(Point2D point){
        x1 = (int)point.getX();
        y1 = (int)point.getY();
        
//       this.x.add(x);
//       this.y.add(y);
    }
    @Override
    public void addCurrCoordinates(Point2D point){
        x2 = (int)point.getX();
        y2 = (int)point.getY();
        Rectangle rect = new Rectangle();
        rect.setFrameFromDiagonal(x1, y1, x2, y2);
        shape = rect;
//        xp=x;
//        yp=y;


    }
    @Override
    
    public void drawShape(Graphics g){
        
        g.setColor(shapeColor);
        g.drawRect(((Rectangle)shape).x , ((Rectangle)shape).y, ((Rectangle)shape).width, ((Rectangle)shape).height);
       
//         for(int i = 1; i<x.size(); i++) {
//            if (x.get(i) >= x.get(i-1) & y.get(i) >= y.get(i-1)) g.drawRect(x.get(i-1), y.get(i-1),Math.abs(x.get(i)-x.get(i-1)), Math.abs(y.get(i)-y.get(i-1)));
//            else if(x.get(i) >= x.get(i-1) & y.get(i) < y.get(i-1)) g.drawRect(x.get(i-1), y.get(i),Math.abs(x.get(i)-x.get(i-1)), Math.abs(y.get(i)-y.get(i-1)));
//            else if(x.get(i) < x.get(i-1) & y.get(i) < y.get(i-1)) g.drawRect(x.get(i), y.get(i),Math.abs(x.get(i)-x.get(i-1)), Math.abs(y.get(i)-y.get(i-1)));
//            else if(x.get(i) < x.get(i-1) & y.get(i) >= y.get(i-1)) g.drawRect(x.get(i), y.get(i-1),Math.abs(x.get(i)-x.get(i-1)), Math.abs(y.get(i)-y.get(i-1)));
//
//    }
//    if (!x.isEmpty()) {
//        if (xp >= x.get(x.size()-1) & yp >= y.get(y.size()-1)) g.drawRect(x.get(x.size()-1), y.get(y.size()-1), Math.abs(xp - x.get(x.size()-1)), Math.abs(yp - y.get(y.size()-1)));
//            else if(xp >= x.get(x.size()-1) & yp < y.get(y.size()-1)) g.drawRect(x.get(x.size()-1), yp , Math.abs(xp - x.get(x.size()-1)), Math.abs(yp - y.get(y.size()-1)));
//            else if(xp < x.get(x.size()-1) & yp < y.get(y.size()-1)) g.drawRect(xp, yp, Math.abs(xp - x.get(x.size()-1)), Math.abs(yp - y.get(y.size()-1)));
//            else if(xp < x.get(x.size()-1) & yp >= y.get(y.size()-1)) g.drawRect(xp, y.get(y.size()-1), Math.abs(xp - x.get(x.size()-1)), Math.abs(yp - y.get(y.size()-1)));
//    }  
    
    
    }
    @Override
    public void setColor(Color color){
        this.shapeColor= color;
        
    }

    @Override
    public Shape getShape() {
        return shape;
    }


    @Override
    public Color getColor() {
        return shapeColor;
    }

    @Override
    public void setShape(Shape shape) {
         this.shape = shape;
    }


    @Override
    public void addSecondCoordinates(Point2D point) {
        x2 = (int)point.getX();
        y2 = (int)point.getY();
        Rectangle rect = new Rectangle();
        rect.setFrameFromDiagonal(x1, y1, x2, y2);
        shape = rect;
    }


    @Override
    public List<Point2D> getPoints() {
        List<Point2D> ls = new ArrayList<Point2D>();
        ls.add(new Point2D.Double(x1,y1));
        ls.add(new Point2D.Double(x2,y2));
        return ls;
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

    @Override
    public void setCoordinates(List<Point2D> points) {
        addFirstCoordinates(points.get(0));
        addSecondCoordinates(points.get(1));
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphred.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import save.BaseShape;

/**
 *
 * @author andr
 */
public class PolyLineShape extends BaseShape {
    PolyLine shape; 
    Color shapeColor;

    public PolyLineShape(){
       this.shape = new PolyLine();
     
}
    
    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public void addFirstCoordinates(Point2D point) {
       this.shape.addFirstCoordinates(point);
    }

    @Override
    public void addCurrCoordinates(Point2D point) {
        this.shape.addCurrCoordinates(point);
    }

    @Override
    public void drawShape(Graphics g) {
       g.setColor(shapeColor);
       g.drawPolyline(shape.getX(),shape.getY(),shape.getSize());
       
    }

    @Override
    public void setColor(Color color) {
        this.shapeColor = color;
       
    }


    @Override
    public Color getColor() {
        return shapeColor;
    }

    @Override
    public void setShape(Shape shape) {
         this.shape = (PolyLine) shape;
    }

 

    @Override
    public void addSecondCoordinates(Point2D point) {
        this.shape.addFirstCoordinates(point);
       
    }


    @Override
    public List<Point2D> getPoints() {
        List x = shape.x;
        List y = shape.y;
        
        List<Point2D> ls = new ArrayList<Point2D>();
        for (int i = 0;i<x.size()-1;i++){
        ls.add(new Point2D.Double((int)x.get(i),(int)y.get(i)));
        }
        ls.add(new Point2D.Double(shape.xp,shape.yp));
        return ls;
    }

    @Override
    public String getType() {
        return "Polyline";
    }

    @Override
    public void setCoordinates(List<Point2D> points) {
        addFirstCoordinates(points.get(0));
        addCurrCoordinates(points.get(1));
    }
    
}

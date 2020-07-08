/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphred.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class PolyLine implements Shape {
    public int[] getX(){
      int[] m = new int [this.x.size()];
		for(int i=1;i<this.x.size();i++) {
			m[i-1]=(int) this.x.get(i);
		}
		m[this.x.size()-1]=(int) this.x.get(0);
		return m;
    }
    
    public int[] getY(){
       int[] m = new int [this.y.size()];
		for(int i=1;i<this.y.size();i++) {
			m[i-1]=(int) this.y.get(i);
		}
		m[this.y.size()-1]=(int) this.y.get(0);
		return m;
	}
    
    public int getSize(){
        return this.x.size();
    }
    
    
    ArrayList<Integer> x;
    ArrayList<Integer> y;
    int xp,yp;
    Color ShapeColor;
    
    public PolyLine(){
        this.x = new ArrayList<>();
        x.add(0);
        this.y = new ArrayList<>();
        y.add(0);
     
}
    
 
    public void addFirstCoordinates(Point2D point){
       this.x.add((int)point.getX());
       this.y.add((int)point.getY());
    }

    public void addCurrCoordinates(Point2D point){
       if(this.x.size()<2) {
			this.x.add((int)point.getX());
                        this.y.add((int)point.getY());
		}
		this.x.set(0, (int)point.getX());
                this.y.set(0, (int)point.getY());
           
    }
  
  

   
 
    @Override
    public Rectangle getBounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rectangle2D getBounds2D() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(double x, double y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Point2D p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Rectangle2D r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void addСurrCoordinates(Point2D point) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

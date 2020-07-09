package save;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.List;


public abstract class BaseShape{
        
        public abstract void drawShape(Graphics g);
        public abstract void setColor(Color color);
        public abstract Shape getShape();
	public abstract Color getColor();
	public abstract void setShape(Shape shape);
	public abstract void addFirstCoordinates(Point2D point);
	public abstract void addSecondCoordinates(Point2D point);
	public abstract void addCurrCoordinates(Point2D point);
	public abstract List<Point2D> getPoints();
	public abstract String getType();
	public abstract void setCoordinates(List<Point2D> points);
        public abstract BaseShape cloneShape();
}



/*  public abstract void addCoordinate(int x, int y);
    public abstract void putCanvasCoordinate(int x,int y);
    public abstract void paintShape(Graphics g);
    public abstract void setColor(Color color);
    public abstract Shape getShape();*/


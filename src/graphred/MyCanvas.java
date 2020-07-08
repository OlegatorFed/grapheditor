
package graphred;
import graphred.shape.Queue;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class MyCanvas extends JPanel {
    
    MyCanvas me;
    Integer mouseX;
    Integer mouseY;
    int width =0;
    int height =0;
    BufferedImage buf = null;
    Graphics buffer = null;
    Queue q=null;
    
    public MyCanvas(int width, int height, Queue q){
        this();
        this.width = width;
        this.height = height;
        this.q = q;
        buf= new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        buffer=buf.getGraphics();
        buffer.setColor(Color.white);
        buffer.fillRect(0, 0, width, height);
    }
    
    
    public MyCanvas(){
        super();
        me= this;
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (q.getLastShape() != null){
                    q.getLastShape().addFirstCoordinates(e.getPoint());
                    me.paintToBuffer();
                    me.repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (q.getLastShape() != null){
                    q.getLastShape().addSecondCoordinates(e.getPoint());
                    me.paintToBuffer();
                    me.repaint();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        this.addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e) {
               if (q.getLastShape() != null){
                    q.getLastShape().addCurrCoordinates(e.getPoint());
                    me.paintToBuffer();
                    me.repaint();
               }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
//                q.getLastShape().putCanvasCoordinate(e.getX(),e.getY());
//                me.paintToBuffer();
//                me.repaint();
             
            }
        });
        
    }
    
    public void paintToBuffer(){
        buffer.setColor(Color.white);
        buffer.fillRect(0,0,1550,850);

        q.paintShapes(buffer);
        
    }
    @Override
    public void paint(Graphics g){
        g.drawImage(buf, 0, 0, me);
    }


   
    
}

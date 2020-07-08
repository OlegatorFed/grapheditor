
package graphred;


import ColorsButton.ColorBaseButton;
import save.*;
import graphred.instruments.CircleButton;
import graphred.instruments.LineButton;
import graphred.instruments.PolygonButton;
import graphred.instruments.RectangleButton;
import graphred.shape.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;



public class GraphRed extends javax.swing.JFrame{
    
//    JLabel jl,l,l1,l2;
    JPanel p;
    JFrame fr;
    MyCanvas jp;
    Queue q= new Queue();
    
    public GraphRed(){
       super("Графический редактор");
        this.setSize(1920,1080);
        fr= this;
        this.setVisible(true);
        this.setLayout(null);
        jp = new MyCanvas(1450,700,q);
        jp.setVisible(true);
        jp.setBounds(30,90,1450,700);
        
        p = new JPanel();
        p.setVisible(true);
        p.setBounds(1250, 10, 70, 70);
       
        int wc = 10;
        int hc = 5;
        for (int i = 1; i <= wc; i++){
            for (int j = 1; j <= hc; j++){
                int col = Color.HSBtoRGB(1f/wc * i , 1, 1f/hc * j);
                ColorBaseButton btn = new ColorBaseButton(new Color(col));
                btn.setBounds(i * 20, (j * 15) - 10, 20, 15);
                
                btn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        q.setCvetColor(new Color(col));
                    }
    
                });
                
                this.add(btn);
                 
            }
        }
        
        JButton ld = new JButton("Загрузить");
        ld.setBounds(1420, 30, 90, 25);
        ld.setVisible(true);
        ld.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
		SaveShapeQueue shapes = new SaveShapeQueue();
		FileInputStream fileInputStream = null;
                        try {
                            fileInputStream = new FileInputStream("save.ser");
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(GraphRed.class.getName()).log(Level.SEVERE, null, ex);
                        }
	    try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
			shapes = (SaveShapeQueue) objectInputStream.readObject();
			q.refresh();
			for (SaveShape saveShape:shapes.getShapes()) {
				q.setCvetColor(saveShape.getColor());
				if(saveShape.getType().equals("Ellipse")) {
					q.addShape(new CircleShape());
				}else if (saveShape.getType().equals("Rectangle")) {
					q.addShape(new RectangleShape());
				}else if (saveShape.getType().equals("Polygon")) {
					q.addShape(new PolygonShape());
				}else if (saveShape.getType().equals("Polyline")) {
					q.addShape(new PolyLineShape());
				}else throw new RuntimeException("problem");
				if(saveShape.getPoints().size()!=0) {
					q.getLastShape().setCoordinates(saveShape.getPoints());
				}
                                
			}
                        
			;
		}       catch (IOException ex) {
                            Logger.getLogger(GraphRed.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(GraphRed.class.getName()).log(Level.SEVERE, null, ex);
                        } 
            jp.paintToBuffer();
            repaint();
                    }
                   
                });
        
        
        JButton s = new JButton("Сохранить");
        s.setBounds(1330, 30, 90, 25);
        s.setVisible(true);
        s.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        SaveShapeQueue shapes = new SaveShapeQueue();
		for(BaseShape shape:q.getShapes()) {
			shapes.addShape(new SaveShape(shape));
		}
		FileOutputStream outputStream = null;
                        try {
                            outputStream = new FileOutputStream("save.ser");
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(GraphRed.class.getName()).log(Level.SEVERE, null, ex);
                        }
	    ObjectOutputStream objectOutputStream = null;
                        try {
                            objectOutputStream = new ObjectOutputStream(outputStream);
                        } catch (IOException ex) {
                            Logger.getLogger(GraphRed.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            objectOutputStream.writeObject(shapes);
                        } catch (IOException ex) {
                            Logger.getLogger(GraphRed.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            objectOutputStream.close();
                        } catch (IOException ex) {
                            Logger.getLogger(GraphRed.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
        
        JButton sv = new JButton("PNG");
        sv.setBounds(1240, 30, 90, 25);
        sv.setVisible(true);
        sv.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        File outputfile = new File("image.png");
                        try {
                            ImageIO.write(jp.buf, "png", outputfile);
                        } catch (IOException ex) {
                            Logger.getLogger(GraphRed.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
        
        
        
//        JButton b = new JButton("ok");
//        b.setBounds(1147, 45, 50, 30);
//        b.setVisible(true);
//        b.addActionListener(
//                new ActionListener(){
//                    @Override
//                    public void actionPerformed(ActionEvent e){
//                        int r,g,b;
//                        r = Integer.parseInt(R.getText());
//                        g = Integer.parseInt(G.getText());
//                        b = Integer.parseInt(B.getText());
//                        Color c = new Color(r,g,b);
//                        p.setBackground(c);
//                        q.getLastShape().setColor(c);
//                        q.setCvetColor(c);
//                    }
//                }
//        );
        
        JButton kvad = new RectangleButton();
        kvad.setBounds(430,30,200,20);
        kvad.setVisible(true);
        kvad.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if (kvad instanceof RectangleButton)q.addShape(((RectangleButton)kvad).getShape());
                        
                    }
                }
            
        );
        
        JButton cir = new CircleButton();
        cir.setBounds(630,30,200,20);
        cir.setVisible(true);
        cir.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if(cir instanceof CircleButton)q.addShape(((CircleButton)cir).getShape());
                    }
                }
            
        );
        
        JButton pol = new PolygonButton();
        pol.setBounds(830,30,200,20);
        pol.setVisible(true);
        pol.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if(pol instanceof PolygonButton)q.addShape(((PolygonButton)pol).getShape());
                        
                    }
                }
            
        );
        
        
        
        
        JButton jb = new LineButton();
        jb.setVisible(true);
        jb.setBounds(230, 30,200,20);
        jb.addActionListener ( 
        new ActionListener()
        {
             @Override
             public void actionPerformed(ActionEvent e){
                 if (jb instanceof LineButton) q.addShape(((LineButton)jb).getShape());
//                 jl.setText("new Line"+q.getSize()+"generated");
                 fr.repaint();
             }
        });
        
        this.add(ld);
        this.add(s);
        this.add(sv);
//        this.add(b);
        this.add(p);
        this.add(pol);
        this.add(cir);
        this.add(kvad);
        this.add(jp);
        this.add(jb);
        this.add(jp);
        
        this.repaint();
        
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
    }
    public static void main(String[] args){
        GraphRed app =new GraphRed();
//        app.setAlwaysOnTop(true);
        app.setEnabled(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
        
}
     
    
    
    

    
    


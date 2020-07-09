
package graphred;


import ColorsButton.ColorBaseButton;
import save.*;
import graphred.instruments.ShapeButton;
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
    JFrame me = this;
    MyCanvas jp;
    Queue q= new Queue();
    
    public GraphRed(){
       super("Графический редактор");
        this.setSize(1920,1080);
        this.setVisible(true);
        this.setLayout(null);
        
        initialize();
        
        this.repaint();
        
    }
    
    public void initColorSelector(int hueVar, int brVar){
//        int wc = 10;
//        int hc = 5;
        for (int i = 1; i <= hueVar; i++){
            for (int j = 1; j <= brVar; j++){
                int col = Color.HSBtoRGB(1f/hueVar * i , 1, 1f/brVar * j);
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
    }
    
    public void initInstruments(){
        BaseShape[] bss = {new PolyLineShape(), new RectangleShape(), new CircleShape(), new PolygonShape()};
        int i = 0;
        for (BaseShape bs: bss){
            JButton jb = new ShapeButton(bs);
            jb.setVisible(true);
            jb.setBounds(230+200*i, 30,200,20);
            i++;
            jb.addActionListener ( 
            new ActionListener()
                {
                     @Override
                     public void actionPerformed(ActionEvent e){
                         if (jb instanceof ShapeButton) q.addShape(((ShapeButton)jb).getShape());
        //                jl.setText("new Line"+q.getSize()+"generated");
                         me.repaint();
                     }
                });
            
            this.add(jb);
        }
    }
    
    public void initLoadButton(){
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
        this.add(ld);
    }
    
    public void initSaveButton(){
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
        this.add(s);
    }
    
    public void initPNGSaveButton(){
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
        this.add(sv);
    }
    
    public void initialize(){
        initMyCanvas();
        initColorSelector(10,5);
        initInstruments();
        initLoadButton();
        initSaveButton();
        initPNGSaveButton();
    }
    
    public void initMyCanvas(){
        this.jp = new MyCanvas(1450,700,q);
        this.jp.setVisible(true);
        this.jp.setBounds(30,90,1450,700);
        this.add(this.jp);
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
     
    
    
    

    
    


package aplicacao;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class FundoTela extends JPanel {
	    private BufferedImage img = null;    
	  
	    public FundoTela(String arquivo) throws IOException    {  
	        this.img = ImageIO.read(new File(arquivo));  
	        setLayout(null);
	    }  
	    
	    @Override  
	    public void paintComponent(Graphics g) {  
	        super.paintComponent(g);        
	        g.drawImage(img, 0, 0,this.getWidth(),this.getHeight(),this);       
	    }  


}

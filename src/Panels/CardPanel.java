package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CardPanel extends JPanel {
    private BufferedImage image;

    public CardPanel(BufferedImage image){
        super();
        this.image = image;
        Dimension dimension = new Dimension(173,264);
        setPreferredSize(dimension);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0, 0 , this);
    }

    public void setNewSize(int newW, int newH){
        Dimension dimension = new Dimension(newW, newH);
        setPreferredSize(dimension);
    }
}

package Cards;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Card {
    private String name;
    private String color;
    private BufferedImage image;

    public Card(String name, String color) {
        this.name = name;
        this.color = color;
        try {
            image = ImageIO.read(new File("./cards/" + name + color + ".png"));
            image = resize(image, 172,264);
        }catch (IOException ignored){}
    }

    public BufferedImage getImage(){
        return image;
    }

    @Override
    public String toString(){
        return "Cards.Card: " + name + color;
    }

    private static BufferedImage resize(BufferedImage img, int newW, int newH){
        Image tmp = img.getScaledInstance(newW, newH, BufferedImage.TYPE_INT_ARGB);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
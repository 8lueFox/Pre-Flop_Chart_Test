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
        this.name = name.toLowerCase();
        this.color = color.toLowerCase();
        try {
            image = ImageIO.read(new File("./cards_rsz/rsz_" + name + color + ".png"));
            image = resize(image, 173,264);
        }catch (IOException ignored){}
    }

    public BufferedImage getImage(){
        return image;
    }

    public String getName(){
        return name;
    }

    public String getColor(){
        return color;
    }

    @Override
    public String toString(){
        return "Cards.Card: " + name + color;
    }

    private static BufferedImage resize(BufferedImage img, int newW, int newH){
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D graphics2D = dimg.createGraphics();
        graphics2D.drawImage(img, 0,0, newW, newH, null);
        graphics2D.dispose();
        return dimg;
    }

    public void resize(int newW, int newH){
        BufferedImage dimg = new BufferedImage(newW, newH, image.getType());
        Graphics2D graphics2D = dimg.createGraphics();
        graphics2D.drawImage(image, 0, 0, newW, newH, null);
        graphics2D.dispose();
        image = dimg;
    }
}
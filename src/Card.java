import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class Card {
    private String name;
    private String color;
    private BufferedImage image;

    Card(String name, String color) {
        this.name = name;
        this.color = color;
        try {
            this.image = ImageIO.read(new File("./cards/" + name + color + ".png"));
        }catch (IOException ignored){}
    }

    public BufferedImage getImage(){
        return image;
    }

    @Override
    public String toString(){
        return "Card: " + name + color;
    }
}
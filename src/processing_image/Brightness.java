package processing_image;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Brightness {

    File input = null;

    public Brightness(File f) {
        this.input = f;
    }

    public void bright(double factor) throws IOException {
        BufferedImage picture1 = ImageIO.read(input);
        BufferedImage picture2 = new BufferedImage(picture1.getWidth(), picture1.getHeight(), BufferedImage.TYPE_INT_RGB);
        double width = picture1.getWidth();
        double height = picture1.getHeight();

        //loops for image matrix
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++) {

                Color c = new Color(picture1.getRGB(x,y ));

                //adding factor to rgb values
                int r = (int) (c.getRed() + factor);
                int b = (int) (c.getBlue() + factor);
                int g = (int) (c.getGreen() + factor);
                if (r >= 256) {
                    r = 255;
                } else if (r < 0) {
                    r = 0;
                }

                if (g >= 256) {
                    g = 255;
                } else if (g < 0) {
                    g = 0;
                }

                if (b >= 256) {
                    b = 255;
                } else if (b < 0) {
                    b = 0;
                }
                picture2.setRGB(x, y,new Color(r,g,b).getRGB());


            }
        ImageIO.write(picture2, "jpg", new File("brightness.jpg"));


    }
}

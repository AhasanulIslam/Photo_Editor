package processing_image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sapia {

    BufferedImage img = null;
    File f = null;

    public Sapia(File f) throws IOException {

        this.f = f;

        img = ImageIO.read(f);
    }

    public void setsepiaFilter()
    {

        //get width and height
        int width = img.getWidth();
        int height = img.getHeight();

        //convert to sepia image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                //calculate tr, tg, tb
                int tr = (int) (0.393 * r + 0.769 * g + 0.189 * b);
                int tg = (int) (0.349 * r + 0.686 * g + 0.168 * b);
                int tb = (int) (0.272 * r + 0.534 * g + 0.131 * b);

                //check condition
                if (tr > 255) {
                    r = 255;
                } else {
                    r = tr;
                }

                if (tg > 255) {
                    g = 255;
                } else {
                    g = tg;
                }

                if (tb > 255) {
                    b = 255;
                } else {
                    b = tb;
                }

                //set new RGB value
                p = (a << 24) | (r << 16) | (g << 8) | b;

                img.setRGB(x, y, p);
            }
        }

    }

    public void sepiaFilter() throws IOException {
        //write image
        f = new File("sepia.jpg");
        ImageIO.write(img, "jpg", f);
    }

}

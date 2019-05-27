package processing_image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class greenImage {


    BufferedImage img = null;
    File f = null;

    public greenImage(File f) throws IOException {

        this.f = f;

        img = ImageIO.read(f);

    }

    public void setGreenFilter()
    {

        //get width and height
        int width = img.getWidth();
        int height = img.getHeight();

        //convert to green image

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int g = (p >> 8) & 0xff;

                //set new RGB
                p = (a << 24) | (0 << 16) | (g << 8) | 0;

                img.setRGB(x, y, p);
            }
        }

    }

    public void greenFilter() throws IOException {
        //write image
        f = new File("green.jpg");
        ImageIO.write(img, "jpg", f);
    }


}

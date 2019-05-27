package processing_image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class grayScale {


    BufferedImage img = null;
    File f = null;

    public grayScale(File f) throws IOException {

        this.f = f;

        img = ImageIO.read(f);

    }

    public void setGrayFilter()
    {

        //get width and height
        int width = img.getWidth();
        int height = img.getHeight();

        //convert to grayscale
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                //calculate average
                int avg = (r + g + b) / 3;

                //replace RGB value with avg
                p = (a << 24) | (avg << 16) | (avg << 8) | avg;

                img.setRGB(x, y, p);
            }
        }

    }

    public void grayFilter() throws IOException {
        //write image
        f = new File("gray.jpg");
        ImageIO.write(img, "jpg", f);
    }


}

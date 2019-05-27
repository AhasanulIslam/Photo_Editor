package processing_image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class yellowImage {

    BufferedImage img = null;
    File f = null;

    public yellowImage(File f) throws IOException {

        this.f = f;

        img = ImageIO.read(f);

    }

    public void setYellowImageFilter()
    {

        //get width and height
        int width = img.getWidth();
        int height = img.getHeight();

        //convert to yellow image
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){

                int p = img.getRGB(x,y);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                r=255;
                g=255;

                p = (a<<24) | (r<<16) | (g<<8) | b;
                img.setRGB(x, y, p);

            }
        }

    }

    public void yellowImageFilter() throws IOException {
        //write image
        f = new File("yellow.jpg");
        ImageIO.write(img, "jpg", f);
    }
}

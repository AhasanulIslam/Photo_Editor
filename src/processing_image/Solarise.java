package processing_image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Solarise {

    BufferedImage img = null;
    File f = null;

    public Solarise(File f) throws IOException {

        this.f = f;

        img = ImageIO.read(f);

    }

    public void setSolariseFilter()
    {

        //get width and height
        int width = img.getWidth();
        int height = img.getHeight();

        //convert to solarise image
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){

                int p = img.getRGB(x,y);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                if(r <= 127) r = 255-r;
                if(g <= 127) g = 255-g;
                if(b <= 127) b = 255-b;

                p = (a<<24) | (r<<16) | (g<<8) | b;
                img.setRGB(x, y, p);
            }
        }

    }

    public void solariseFilter() throws IOException {
        //write image
        f = new File("solarise.jpg");
        ImageIO.write(img, "jpg", f);
    }

}

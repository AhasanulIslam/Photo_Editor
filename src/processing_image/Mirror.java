package processing_image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Mirror {


    BufferedImage img = null;
    File f = null;


    public Mirror(File f) throws IOException {

        this.f = f;

        img = ImageIO.read(f);

    }


    public void setMirrorFilter() {

        //get width and height
        int width = img.getWidth();
        int height = img.getHeight();


        //convert to mirror image

        for(int y = 0; y < height; y++){
            for(int x =0; x <= width/2 ; x++){
                int p = img.getRGB(x,y);

                img.setRGB(x, y, img.getRGB(width - 1 - x, y));
                img.setRGB(width - 1 - x, y, p);
            }
        }

    }

    public void mirrorFilter() throws IOException {
        //write image
        f = new File("1.jpg");
        ImageIO.write(img, "jpg", f);
    }


}

package processing_image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class redImage {

    BufferedImage img = null;
    File f = null;

    public redImage(File f) throws IOException {

        this.f = f;

        img = ImageIO.read(f);

    }

    public void setRedFilter() {

        //get width and height
        int width = img.getWidth();
        int height = img.getHeight();

        //convert to red image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;

                //set new RGB
                p = (a << 24) | (r << 16) | (0 << 8) | 0;

                img.setRGB(x, y, p);
            }
        }

    }
    public void redFilter () throws IOException {
        //write image
        f = new File("red.jpg");
        ImageIO.write(img, "jpg", f);
    }


}

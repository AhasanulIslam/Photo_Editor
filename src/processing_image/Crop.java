package processing_image;

import java.io.*;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;

public class Crop {

    File input = null;

    public Crop(File f)
    {
        this.input = f;
    }

    public void crop(double ammount) throws IOException {
        BufferedImage originalImage = ImageIO.read(input);
        int height = originalImage.getHeight();
        int width = originalImage.getWidth();



        int targetWidth = (int)(width * ammount);
        int targetHeight = (int)(height * ammount);
        // Coordinates of the image's middle
        int xc = (width - targetWidth) / 2;
        int yc = (height - targetHeight) / 2;

        // Crop
        BufferedImage croppedImage = originalImage.getSubimage(
                xc,
                yc,
                targetWidth, // widht
                targetHeight // height
        );
        ImageIO.write(croppedImage, "jpg", new File("1.jpg"));
    }

}

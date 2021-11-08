package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {
    public static void main(String[] args) {
        File image = new File("src/a.png");
        File f = new File("src/b.png");

        try {
            BufferedImage bufferedImage = ImageIO.read(image);
            int height = bufferedImage.getHeight();
            int width = bufferedImage.getWidth();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int RGBA = bufferedImage.getRGB(x, y);
                    int alpha = (RGBA >> 24) & 255;
                    int red = (RGBA >> 16) & 255;
                    int green = (RGBA >> 8) & 255;
                    int blue = RGBA & 255;
                    if (green != 0) {
                        green = blue;
                    }
                    int argb = (alpha << 24) | (red << 16) | (green << 8) | blue;
                    bufferedImage.setRGB(x, y, argb);

                }
            }
            ImageIO.write(bufferedImage, "png", f);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

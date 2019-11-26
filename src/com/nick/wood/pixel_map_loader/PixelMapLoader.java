package com.nick.wood.pixel_map_loader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PixelMapLoader {

    private final ArrayList<PixelMap> pixelMaps = new ArrayList<>();
    private ArrayList<ColourMap> colourMaps;
    private String fill = null;

    public PixelMapLoader(File colorMapFile) throws FileNotFoundException {

            colourMaps = loadColourMap(colorMapFile);

    }

    public void loadPixelMap(File imageFile) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(imageFile);

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        for (int currentRow = 0; currentRow < height; currentRow++) {

            for (int currentCol = 0; currentCol < width; currentCol++) {

                Color color = new Color(bufferedImage.getRGB(currentCol, currentRow));

                for (ColourMap colourMap : colourMaps) {

                    if (colourMap.R == color.getRed() && colourMap.B == color.getBlue() && colourMap.G == color.getGreen()) {

                        pixelMaps.add(new PixelMap(colourMap.layer, colourMap.name, currentCol, currentRow));

                    }

                }

            }

        }

    }

    public ArrayList<PixelMap> getPixelMaps() {
        return pixelMaps;
    }

    public String getFill() {
        return fill;
    }

    public ArrayList<ColourMap> loadColourMap(File file) throws FileNotFoundException {

        ArrayList<ColourMap> colourMaps = new ArrayList<>();

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            String stringLine = scanner.nextLine();

            if (!stringLine.startsWith("//")) {

                String[] stringArray = stringLine.split("-");

                if (stringArray[0].equalsIgnoreCase("fill")) {

                    fill = stringArray[1];

                } else {

                    colourMaps.add(new ColourMap(stringLine));

                }

            }

        }

        return colourMaps;

    }

}

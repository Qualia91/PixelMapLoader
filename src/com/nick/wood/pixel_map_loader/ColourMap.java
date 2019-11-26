package com.nick.wood.pixel_map_loader;

public class ColourMap {

    final int R;
    final int G;
    final int B;
    final String name;
    public int layer;

    public ColourMap(String row) {
        String[] splitRow = row.split(",");
        this.R = Integer.parseInt(splitRow[0]);
        this.G = Integer.parseInt(splitRow[1]);
        this.B = Integer.parseInt(splitRow[2]);
        this.name = splitRow[3];
        this.layer = Integer.parseInt(splitRow[4]);
    }

}

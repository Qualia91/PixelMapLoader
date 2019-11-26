package com.nick.wood.pixel_map_loader;

public class PixelMap {

    public int layer;
    public String tileName;
    public int x;
    public int y;

    public PixelMap(int layer, String tileName, int x, int y) {
        this.layer = layer;
        this.tileName = tileName;
        this.x = x;
        this.y = y;
    }

}

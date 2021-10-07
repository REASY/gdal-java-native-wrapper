package com.github.gdal.nativeloader;

import com.sun.jna.Platform;
import org.gdal.gdal.gdal;
import org.gdal.gdal.gdalJNI;
import org.gdal.ogr.DataSource;
import org.gdal.ogr.ogr;

public class GdalExample {
    private GdalExample() {}

    private static void gpkgExample() {
        gdalJNI.isAvailable();
        System.out.println(gdalJNI.GetCacheMax());
        gdal.AllRegister();

        DataSource open = ogr.Open("/domains.gpkg");
        System.out.println("Name: " + open.GetName());
        System.out.println("Layers: " + open.GetLayerCount());
        for (int layerIndex = 1; layerIndex <= open.GetLayerCount(); layerIndex ++) {
            System.out.printf("Layer[%d]: %s\n", layerIndex, open.GetLayer(layerIndex).GetName());
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("OS name: " + System.getProperty("os.name"));
        System.out.println("OS arch: " + System.getProperty("os.arch"));
        System.out.println("OS version: " + System.getProperty("os.version"));
        System.out.println("Platform.RESOURCE_PREFIX: " + Platform.RESOURCE_PREFIX);
        GdalLoader.load();

        gpkgExample();
    }
}
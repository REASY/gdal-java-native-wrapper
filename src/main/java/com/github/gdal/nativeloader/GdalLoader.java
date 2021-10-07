package com.github.gdal.nativeloader;

import com.sun.jna.Function;
import com.sun.jna.NativeLibrary;

public class GdalLoader {
    public static void load() {
        NativeLibrary gdalLibrary = NativeLibrary.getInstance("gdal_my.29");
        assert gdalLibrary != null;

        NativeLibrary gdalAllJniLibrary = NativeLibrary.getInstance("gdalalljni.29");
        assert gdalAllJniLibrary != null;
//
//        Function f = gdalAllJniLibrary.getFunction("Java_org_gdal_gdal_gdalJNI_HasThreadSupport");
//        System.out.println(f);
//        System.out.println(f.invokeInt(null));
    }
}
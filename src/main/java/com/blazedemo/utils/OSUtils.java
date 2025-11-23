package com.blazedemo.utils;

import com.blazedemo.utils.dataReader.PropertyReader;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class OSUtils {
    public enum OS {WINDOWS, MAC, LINUX, UNKNOWN}

    public static OS getCurrentOS() {
        String os = PropertyReader.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return OS.WINDOWS;
        } else if (os.contains("mac")) {
            return OS.MAC;
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            return OS.LINUX;
        } else {
            return OS.UNKNOWN;
        }
    }
}


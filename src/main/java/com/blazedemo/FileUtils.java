package com.blazedemo;

import com.blazedemo.utils.dataReader.PropertyReader;
import com.blazedemo.utils.logs.LogsManager;
import io.qameta.allure.internal.shadowed.jackson.databind.annotation.JsonAppend;
import org.openqa.selenium.logging.Logs;

import java.io.File;

public class FileUtils {
    private static final String USER_DIR = PropertyReader.getProperty("user.dir")+ File.separator;
    private FileUtils(){
        //prevent instantiation

    }

    //Renaming
    public static void renameFile(String oldFilePath, String newFilePath){

        try {
            File oldFile = new File(USER_DIR + oldFilePath);
            File newFile = new File(USER_DIR + newFilePath);
            if (oldFile.exists()) {
                if (oldFile.renameTo(newFile)) {
                    LogsManager.info("File renamed from: " , oldFilePath , " to: " , newFilePath);
                } else {
                    LogsManager.error("Could not rename file from: " , oldFilePath , " to: " , newFilePath);
                }
            } else {
                LogsManager.error("Old file does not exist: " , oldFilePath);
            }
        } catch (Exception e) {
            LogsManager.error("Could not rename file from: " , oldFilePath , " to: " , newFilePath , e.getMessage());
        }}


    //Creating Directory
    public static void createDirectory(String Path){

        try {
            File file = new File(USER_DIR + Path);
            if (!file.exists()) {
                file.mkdirs();
                LogsManager.info("Directory created: " , Path);
            }
        } catch (Exception e) {
            LogsManager.error("Could not create directory: " , Path , e.getMessage());
        }

    }


    //Cleaning Directory
    public static void cleanDirectory(File file){

        try {
            org.apache.commons.io.FileUtils.deleteQuietly(file);
        } catch (Exception e) {
            LogsManager.error("Could not clean directory: " , file.getAbsolutePath() , e.getMessage());
        }

    }
}

package com.poorjar.sftp.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import com.poorjar.sftp.SFTPDetails;

public class PropertiesReader {
    public static SFTPDetails readProperties() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("server.properties"));

        return SFTPDetails.getInstance(properties.getProperty("serverAddress").trim(), 
                                       properties.getProperty("directory").trim(),
                                       properties.getProperty("username").trim(),
                                       properties.getProperty("password").trim());
    }
}

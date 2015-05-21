package com.poorjar.sftp;

import java.io.File;
import java.net.URL;

import org.junit.Test;

public class SFTPManagerImplTest {

    @Test
    public void testHappyPath() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL url = classLoader.getResource("com/poorjar/sftp/testFile.txt");

        File uploadFile = new File(url.getPath());
        SFTPDetails details = SFTPDetails.getInstance("10.32.13.132", "/opt/darn/", "Swaroop", "Swaroop");

        SFTPManagerImpl manager = new SFTPManagerImpl();
        manager.ftpUpload(details, uploadFile);
    }
}

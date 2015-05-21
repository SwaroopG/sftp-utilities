package com.poorjar.sftp;

import java.io.File;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

public class SFTPManagerImpl implements SFTPManager {
    public void ftpUpload(SFTPDetails sftpDetails, File sourceFile) {
        // Validate
        if (sourceFile == null || !sourceFile.exists()) {
            throw new IllegalArgumentException("File was not found - " + sourceFile);
        }

        // Initializes the file manager
        StandardFileSystemManager manager = new StandardFileSystemManager();
        try {
            manager.init();

            // Setup our SFTP configuration
            FileSystemOptions sftpOptions = new FileSystemOptions();
            SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(sftpOptions, "no");
            SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(sftpOptions, true);
            SftpFileSystemConfigBuilder.getInstance().setTimeout(sftpOptions, 10000);

            // Create the SFTP URI using the host name, userid, password, remote path and file name
            String sftpUri = sftpDetails.getSFTPUrl() + sourceFile.getName();
            System.out.println(sftpUri);

            // Create local file object
            FileObject localFile = manager.resolveFile(sourceFile.getAbsolutePath());

            // Create remote file object
            FileObject remoteFile = manager.resolveFile(sftpDetails.getSFTPUrl() + sourceFile.getName(), sftpOptions);

            // Copy local file to sftp server
            remoteFile.copyFrom(localFile, Selectors.SELECT_SELF);
            System.out.println("File upload successful");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }

    public void ftpCopy(SFTPDetails sftpDetails, String ftpFile) {
        // TODO Auto-generated method stub

    }

    public void ftpDelete(SFTPDetails sftpDetails, String ftpFile) {
        // TODO Auto-generated method stub

    }
}

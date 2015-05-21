package com.poorjar.sftp;

import java.io.File;

/**
 * Utilities for FTPing files.
 * @author Swaroop
 */
public interface SFTPManager {
    /**
     * FTPs a given file to a destination FTP location.
     * @param sftpDetails The details of the SFTP server.
     * @param sourceFile The source file that has to be uploaded.
     */
    public void ftpUpload(SFTPDetails sftpDetails, File sourceFile);
    /**
     * Downloads file from an SFTP location.
     * @param sftpDetails The details of the SFTP server.
     * @param ftpFile The name of the file on the SFTP server that has to be copied.
     * @param destinationLocation The location where the file will be copied to.
     */
    public void ftpCopy(SFTPDetails sftpDetails, String ftpFile);
    /**
     * Deletes a file on the SFTP server
     * @param sftpDetails The details of the SFTP server.
     * @param ftpFileLocation The name of the file on the SFTP server that has to be deleted.
     */
    public void ftpDelete(SFTPDetails sftpDetails, String ftpFile);
}

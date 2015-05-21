package com.poorjar.sftp;

/**
 * Contains details about the SFTP server, username and password.
 * @author Swaroop
 */
public class SFTPDetails {
    private String serverAddress;
    private String directory;
    private String username;
    private String password;

    /**
     * Contains details about the SFTP server, username and password.
     * @param serverAddress The address of the SFTP server.
     * @param directory The directory where the file has to be managed.
     * @param username The username for authentication.
     * @param password The password for authentication.
     */
    private SFTPDetails(String serverAddress, String directory, String username, String password) {
        this.serverAddress = serverAddress;
        this.directory = directory;
        this.username = username;
        this.password = password;
    }

    public static SFTPDetails getInstance(String serverAddress, String directory, String username, String password) {
        return new SFTPDetails(serverAddress, directory, username, password);
    }

    public String getSFTPUrl() {
        return "sftp://" + username + ":" + password + "@" + serverAddress + "/" + directory;
    }

    /**
     * @return The address of the SFTP server.
     */
    public String getServerAddress() {
        return serverAddress;
    }

    /**
     * @return The directory where the file has to be managed.
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * @return The username for authentication.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return The password for authentication.
     */
    public String getPassword() {
        return password;
    }
}
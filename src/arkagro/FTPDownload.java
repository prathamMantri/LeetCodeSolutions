/*
package arkagro;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FTPDownload {
    public static void downloadDirStructure(FTPClient ftpClient, String parentDir,
                                            String currentDir, String saveDir) throws IOException {
        String dirToList = parentDir;
        if (!currentDir.equals("")) {
            dirToList += "/" + currentDir;
        }

        FTPFile[] subFiles = ftpClient.listFiles(dirToList);

        if (subFiles != null && subFiles.length > 0) {
            for (FTPFile aFile : subFiles) {
                String currentFileName = aFile.getName();
                if (currentFileName.equals(".") || currentFileName.equals("..")) {
                    // skip parent directory and the directory itself
                    continue;
                }

                if (aFile.isDirectory()) {
                    String newDirPath = saveDir + parentDir + File.separator
                            + currentDir + File.separator + currentFileName;
                    if (currentDir.equals("")) {
                        newDirPath = saveDir + parentDir + File.separator
                                + currentFileName;
                    }

                    // create the directory in saveDir
                    File newDir = new File(newDirPath);
                    boolean created = newDir.mkdirs();
                    if (created) {
                        System.out.println("CREATED the directory: " + newDirPath);
                    } else {
                        System.out.println("COULD NOT create the directory: " + newDirPath);
                    }

                    // download the sub directory
                    downloadDirStructure(ftpClient, dirToList, currentFileName,
                            saveDir);
                }
            }
        }
    }

    public static void main(String[] args) {

        FTPClient ftpClient = new FTPClient();

        FileOutputStream fos = null;

        String server="ftp.arkkagro.com";

        String user = "arkkagro";
        String pass = "arkk@12#";




        try {
            // connect and login to the server
            ftpClient.connect(server);
            ftpClient.login(user, pass);

            // use local passive mode to pass firewall
            ftpClient.enterLocalPassiveMode();

            System.out.println("Connected");

            String remoteDirPath = "httpdocs/wwwroot.zip";
            String saveDirPath = "C:/CODEBASE/LeetCodeSolutions/src/arkagro/";

            downloadDirStructure(ftpClient, remoteDirPath, "",
                    saveDirPath);

            // log out and disconnect from the server
            ftpClient.logout();
            ftpClient.disconnect();

            System.out.println("Disconnected");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



}
*/

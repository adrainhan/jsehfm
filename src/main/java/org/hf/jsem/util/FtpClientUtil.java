package org.hf.jsem.util;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.hf.jsem.entity.JcmJobInfo;

import java.io.*;
import java.net.SocketException;
import java.util.Date;


/**
 * Created by adramer on 2016/10/25.
 */
public class FtpClientUtil {

    public static boolean doFtpDown(JcmJobInfo jcmJobInfo) {
        boolean result = true;


        return result;
    }


    public static void getFilesByFtp(JcmJobInfo jcmJobInfo) {
        FTPClient client = new FTPClient();
        InputStream in = null;
        OutputStream out = null;
        try {
            client.setReceiveBufferSize(10 * 1024 * 1024);
            client.connect(jcmJobInfo.getFtpAdr());
            client.login(jcmJobInfo.getFtpUser(), jcmJobInfo.getFtpPwd());
            client.setFileType(FTP.BINARY_FILE_TYPE);    //这一句话一定需要
            long b = new Date().getTime();
            System.out.println(b);
            client.setBufferSize(1024 * 1024 * 10);
            in = new BufferedInputStream((new FileInputStream(new File("C:\\Users\\adramer\\Desktop\\ftpload\\x.txt"))));
            client.appendFile("bbbb.ctl", in);
            System.out.println(new Date().getTime() - b);


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeSource(client);
        }


    }


    public static void closeSource(FTPClient client) {
        if (client != null) {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String args[]) {
        JcmJobInfo jcmJobInfo = new JcmJobInfo();
        jcmJobInfo.setFtpAdr("167.10.0.1");
        jcmJobInfo.setFtpUser("han");
        jcmJobInfo.setFtpPwd("han");
        getFilesByFtp(jcmJobInfo);
    }

}

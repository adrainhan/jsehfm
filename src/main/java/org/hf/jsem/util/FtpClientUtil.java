package org.hf.jsem.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.hf.jsem.entity.JcmJobInfo;

import java.io.*;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by adramer on 2016/10/25.
 */
public class FtpClientUtil {

    private static Log log = LogFactoryImpl.getLog(FtpClientUtil.class);

    public static boolean doFtpDown(JcmJobInfo jcmJobInfo) {
        boolean result = true;


        return result;
    }


    public static Map<String, String> getFilesByFtp(JcmJobInfo jcmJobInfo) {
        Map<String, String> result = new HashMap<String, String>();
        FTPClient client = new FTPClient();
        InputStream in = null;
        OutputStream out = null;
        boolean readyOrNot = false;
        SimpleDateFormat dateFormat = null;
        try {
            client.connect(jcmJobInfo.getFtpAdr());
            readyOrNot = client.login(jcmJobInfo.getFtpUser(), jcmJobInfo.getFtpPwd());
            if (!readyOrNot) {
                result.put("result", "FAILED");
                result.put("info", "错误的用户名密码：" + jcmJobInfo.getFtpUser() + "/" + jcmJobInfo.getFtpPwd());
            } else {
                client.setReceiveBufferSize(10 * 1024 * 1024);  //设置缓冲流大小
                client.setFileType(FTP.BINARY_FILE_TYPE);//设置文件格式
                if (jcmJobInfo.getDistanDir() == null || (!jcmJobInfo.getDistanDir().startsWith("/"))) {
                    String dataFilePath = jcmJobInfo.getDistanDir();
                    if (jcmJobInfo.getSuffixDisranDir() != null) {
                        if (!jcmJobInfo.getSuffixDisranDir().endsWith("/")) dataFilePath = dataFilePath + "/";
                        if ("Y".equals(jcmJobInfo.getExeHistFlag())) {
                            dataFilePath = dataFilePath + jcmJobInfo.getHsitDate();
                        } else {
                            dataFilePath = dataFilePath + jcmJobInfo.getDataDate();
                        }
                    }
                    readyOrNot = client.changeWorkingDirectory(jcmJobInfo.getDistanDir());
                    if (readyOrNot) {
                        //获取所有的文件列表
                        List<String> fileNameList = new ArrayList<String>();
                        for (FTPFile ftpFile : client.listFiles()) {
                            fileNameList.add(ftpFile.getName());
                        }
                        //判断是否需要校验OK文件
                        if (jcmJobInfo.getOkFileName() != null && jcmJobInfo.getOkFileName().length() > 0) {
                            if (!fileNameList.contains(jcmJobInfo.getOkFileName())) {
                                result.put("result", "FAILED");
                                result.put("info", "无法获取OK文件： " + jcmJobInfo.getOkFileName());
                            }
                        }
                        StringBuffer buffer = new StringBuffer();
                        buffer.append(jcmJobInfo.getConentFileName());
                        if (jcmJobInfo.getSuffixTimeFormat() != null && !"".equals(jcmJobInfo.getSuffixTimeFormat())) {
                            dateFormat = new SimpleDateFormat(jcmJobInfo.getSuffixTimeFormat());
                            if ("Y".equals((jcmJobInfo.getExeHistFlag()))) {
                                buffer.append(jcmJobInfo.getHsitDate());
                            } else {
                                buffer.append(dateFormat.format(jcmJobInfo.getCurrentDt()));
                            }
                        }
                        buffer.append(jcmJobInfo.getSufffix());
                        String fileName = buffer.toString();
                        if (!fileNameList.contains(fileName)) {
                            result.put("result", "FAILED");
                            result.put("info", "无法获取数据文件： " + fileName);
                        } else {
                            //DOWNLOAD FILE
                            out = new FileOutputStream(jcmJobInfo.getLocalDir() + fileName);
                            in = client.retrieveFileStream(fileName);
                            byte[] bytes = new byte[1024];
                            int readLen = 0;
                            while ((readLen = in.read(bytes)) > 0) {
                                out.write(bytes, 0, readLen);
                            }
                            result.put("result", "SUCCESS");
                            result.put("info", fileName+"下载成功！");
                        }
                    } else {
                        result.put("result", "FAILED");
                        result.put("info", "无法切换到远程目录 " + jcmJobInfo.getDistanDir());
                    }
                } else {
                    result.put("result", "FAILED");
                    result.put("info", "远程路径为：" + jcmJobInfo.getDistanDir() + ",不符合规范：规范的远程路径不能以\"/\"开头");
                }

            }
        } catch (IOException e) {
            result.put("result", "FAILED");
            result.put("info", e.getMessage());
            e.printStackTrace();
        } finally {
            closeSource(in);
            closeSource(out);
            closeSource(client);
        }

        log.error(result);
        return result;

    }


    public static void closeSource(FTPClient client) {
        if (client != null) {
            try {
                //  client.logout();
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void closeSource(InputStream in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void closeSource(OutputStream out) {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        System.out.println(list.contains("hello"));
    }

    private String getSring(String regx) {
        return regx == null ? "" : regx;
    }
}

package org.hf.jsem.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.trilead.ssh2.Connection;
import com.trilead.ssh2.Session;
import org.apache.log4j.Logger;


/**
 * Created by adramer on 2016/11/1.
 */
public class ShellInvokeUtil {
    private static Logger logger = Logger.getLogger(ShellInvokeUtil.class);

    /**
     * 远程调用
     */
    public static Map<String, String> dynamicExeShell(String ip, String user, String pwd, String shellStatement, String[] parames) {
        Map<String, String> result = new HashMap<String, String>();
        Connection connection = null;
        Session session = null;
        InputStream in = null;
        try {
            connection = new Connection(ip);
            connection.connect();
            boolean login = connection.authenticateWithPassword(user, pwd);
            if (!login) {
                logger.error("无法连接到远程服务器：" + ip + ":" + user + ":" + shellStatement);
                result.put("result", "failed");
                result.put("info", "无法连接到远程服务器：" + ip + ":" + user + ":" + shellStatement);
                return result;
            }
            session = connection.openSession();
            result = exeCmd(session, shellStatement, parames);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            result.put("result", "failed");
            result.put("info", "执行shell出错：" + ip + ":" + user + ":" + shellStatement);
        } finally {
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }


        return result;
    }


    /***
     * 当前服务部署在当前服务器上
     */
    public static Map<String, String> staticInvoke(String shell, String[] parameters) {
        Map<String, String> result = new HashMap<String, String>();
        StringBuffer buffer = new StringBuffer();
        Process process = null;
        InputStream in = null;
        try {
            process = Runtime.getRuntime().exec(buffer.toString());
            Integer exeFlag = process.waitFor();
            if (exeFlag != null && exeFlag == 0) {
                result.put("result", "success");
                in = process.getInputStream();
                result.put("info", readReturnMsg(in));
            }

        } catch (IOException e) {
            e.printStackTrace();
            result.put("result", "failed");
            result.put("info", e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            result.put("result", "failed");
            result.put("info", e.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (process != null) {
                process.destroy();
            }
        }

        return result;
    }


    /**
     * 执行shell调用 远程调用
     */
    private static Map<String, String> exeCmd(Session session, String exeStatemnt, String[] parameters) {
        Map<String, String> result = new HashMap<String, String>();
        StringBuffer buffer = new StringBuffer();
        buffer.append(exeStatemnt);
        if (parameters != null && parameters.length > 0) {
            for (String par : parameters) {
                buffer.append(" ").append(par);
            }
        }
        try {
            session.execCommand(buffer.toString());
            session.waitForCondition(1, 1000 * 60 * 30);   //设置shell最大执行时间，这里设置为30分钟
            int exitCd = session.getExitStatus();  //此处结果依赖上步骤代码
            if (exitCd == 0) {
                result.put("result", "success");
                result.put("info", readReturnMsg(session.getStdout()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            result.put("result", "failed");
            result.put("info", "执行shell脚本发生异常！" + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return result;
    }


    /**
     * 读取输入流
     */
    private static String readReturnMsg(InputStream inputStream) throws IOException {
        StringBuffer buffer = new StringBuffer();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) > 0) {
            buffer.append(new String(bytes, 0, len));
        }

        return buffer.toString();
    }


    public static void main(String args[]) {
        System.out.println("hey......");
    }
}

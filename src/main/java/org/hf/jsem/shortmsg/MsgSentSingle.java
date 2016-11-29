package org.hf.jsem.shortmsg;

import org.hf.jsem.util.PropertyUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adramer on 2016/11/14.
 */
public class MsgSentSingle {
    private byte[] shortMessage;

    public MsgSentSingle(byte[] shortMessage) {
        this.shortMessage = shortMessage;
    }

    public Map<String, String> send() {
        InputStream in = null;
        OutputStream out = null;
        Socket socket = null;
        StringBuffer buffer = new StringBuffer();
        Map<String, String> sendRes = new HashMap<String, String>();
        String retutnInfo = "";
        try {
            Map<String, String> config = PropertyUtil.getAll("shortMsg.properties");
            socket = new Socket(config.get("ip"), Integer.parseInt(config.get("port")));
            out = socket.getOutputStream();
            out.write(shortMessage);
            in = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = in.read(bytes)) > 0) {
                buffer.append(new String(bytes, 0, len,"GBK"));
            }
            retutnInfo = buffer.toString();
            if (retutnInfo != null && retutnInfo.length() > 0 && retutnInfo.contains("ISS0000")) {
                sendRes.put("result", "success");
            } else {
                sendRes.put("result", "failed");
            }
            sendRes.put("info", retutnInfo);
        } catch (IOException e) {
            e.printStackTrace();
            sendRes.put("result", "failed");
            sendRes.put("info", e.getMessage());
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sendRes;
    }
}

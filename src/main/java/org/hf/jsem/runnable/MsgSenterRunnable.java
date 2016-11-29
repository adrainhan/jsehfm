package org.hf.jsem.runnable;

import org.hf.jsem.entity.JcmJobInfo;
import org.hf.jsem.shortmsg.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Created by adramer on 2016/11/15.
 */
public class MsgSenterRunnable implements Runnable {
    private List<Message> message;
    private String flag;
    private MsgClientSingle client;
    private JcmJobInfo jcmJobInfo;

    public MsgSenterRunnable(List<Message> message, String flag, MsgClientSingle client, JcmJobInfo jcmJobInfo) {
        this.message = message;
        this.flag = flag;
        this.client = client;
        this.jcmJobInfo = jcmJobInfo;
    }

    public void run() {
        try {
            if ("SUCH".equals(flag)) {
                sentSuch();
            } else if ("JCM".equals(flag)) {
                sentJcm();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }


    private void sentJcm() throws UnsupportedEncodingException {
        Map<String, String> sendRes = null;
        for (int i = 0; i < message.size(); i++) {
            this.client.sentMsgSingle((ShortMessage) this.message.get(i), jcmJobInfo);
        }

    }

    private void sentSuch() throws UnsupportedEncodingException {
        Map<String, String> sendRes = null;
        for (int i = 0; i < message.size(); i++) {
            this.client.sentMsgSingle((SuchMsg) this.message.get(i), jcmJobInfo);
        }

    }

}

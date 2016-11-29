package org.hf.jsem.runnable;

import org.hf.jsem.entity.JcmJobInfo;
import org.hf.jsem.shortmsg.Message;
import org.hf.jsem.shortmsg.ShortMessage;

import java.util.List;

/**
 * Created by adramer on 2016/11/3.
 * 启动对账线程
 */
public class ExeMdAcctCprRunnable implements Runnable {
    private List<Message> messages;
    private JcmJobInfo jcmJobInfo;

    public ExeMdAcctCprRunnable(List<Message> messages, JcmJobInfo jcmJobInfo) {
        this.messages = messages;
        this.jcmJobInfo = jcmJobInfo;
    }

    public void run() {

    }





}

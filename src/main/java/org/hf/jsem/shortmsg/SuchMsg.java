package org.hf.jsem.shortmsg;

import org.hf.jsem.entity.SscfMsgPpsl;

import java.io.UnsupportedEncodingException;

/**
 * Created by adramer on 2016/11/15.
 */
public class SuchMsg extends Message {
    private SscfMsgPpsl msgPpsl;

    public SscfMsgPpsl getMsgPpsl() {
        return msgPpsl;
    }

    public SuchMsg(SscfMsgPpsl msgPpsl) {
        this.msgPpsl = msgPpsl;
    }

    @Override
    public byte[] getMsgBody() throws UnsupportedEncodingException {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getConfig("tradecode")).append(getConfig("srvid"));
        buffer.append(getConfig("branchno")).append(getConfig("immedflag")).append(getConfig("lastsndtime"));
        buffer.append(formatData(msgPpsl.getCustNo(), MsgConfig._CUSTNO)).append(getConfig("srvaccno"));
        buffer.append(formatData(msgPpsl.getMobitl(), MsgConfig._OBJADDR)).append(formatData(msgPpsl.getMsgInfo(), MsgConfig._MSGCONT));
        String body = buffer.toString();
        int len = body.getBytes("UTF-8").length;
        buffer.setLength(0);
        buffer.append("0").append(len).append(body);

        return buffer.toString().getBytes("UTF-8");
    }
}

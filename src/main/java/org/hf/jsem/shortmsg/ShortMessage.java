package org.hf.jsem.shortmsg;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adramer on 2016/11/11.
 */
public class ShortMessage extends Message {

    private String phoneNo;
    private String content;
    private String custNo;
    private String type;
    private String remark;

    public String getType() {
        return type;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getContent() {
        return content;
    }

    public String getCustNo() {
        return custNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }



    public ShortMessage(String phoneNo, String content, String custNo, String type) throws UnsupportedEncodingException {
        init();
        this.content = content;
        this.phoneNo = phoneNo;
        this.type = type;
        this.custNo = custNo;
    }


    @Override
    public byte[] getMsgBody() throws UnsupportedEncodingException {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getConfig("tradecode")).append(getConfig("srvid"));
        buffer.append(getConfig("branchno")).append(getConfig("immedflag")).append(getConfig("lastsndtime"));
        buffer.append(formatData(custNo, MsgConfig._CUSTNO)).append(getConfig("srvaccno"));
        buffer.append(formatData(phoneNo, MsgConfig._OBJADDR)).append(formatData(content, MsgConfig._MSGCONT));
        String body = buffer.toString();
        int len = body.getBytes("UTF-8").length;
        buffer.setLength(0);
        buffer.append("0").append(len).append(body);

        return buffer.toString().getBytes("UTF-8");

    }





}

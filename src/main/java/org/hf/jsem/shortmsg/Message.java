package org.hf.jsem.shortmsg;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adramer on 2016/11/15.
 */
public abstract class Message {
    private static final Map<String, String> steadyElemets = new HashMap<String, String>();

    void init() throws UnsupportedEncodingException {
        while (steadyElemets.size() == 0) {
            synchronized (steadyElemets) {
                steadyElemets.put("tradecode", formatData("820001", MsgConfig._TRADECODE));
                steadyElemets.put("srvid", formatData("6626", MsgConfig._SRVID));
                steadyElemets.put("branchno", formatData("8888888", MsgConfig._BRANCHNO));
                steadyElemets.put("immedflag", formatData("1", MsgConfig._IMMEDFLAG));
                steadyElemets.put("lastsndtime", formatData("0", MsgConfig._LASTSNDTIME));
                steadyElemets.put("srvaccno", formatData("", MsgConfig._SRVACCNO));
                steadyElemets.notify();
            }
        }
    }

    /**
     * @Author: adrainhan
     * @Time: 2016-11-11 17:23:41
     * @Description: 规范化数据
     * @Param:para
     * @Param:standardLen 数据长度
     * @Return:String
     */
    public String formatData(String para, Integer standardLen) throws UnsupportedEncodingException {
        String result = para;
        StringBuffer buffer = new StringBuffer();
        if (result == null) result = "";
        int paraLen = result.getBytes("UTF-8").length;
        if (standardLen == null) throw new NullPointerException("formatData failed ,cause the  standardLen value is null");
        buffer.append(para);
        while (paraLen < standardLen) {
            buffer.append(" ");
            paraLen++;
        }

        return buffer.toString();
    }


    public String getConfig(String property) {
        return steadyElemets.get(property);
    }
    
    /**
    *@Author: adrainhan
    *@Time: 2016-11-15 15:19:51
    *@Description: 获取短信内容
    *@Param:
    *@Return:  byte[]
    */
    public abstract byte[] getMsgBody() throws UnsupportedEncodingException;
}

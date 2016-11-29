package org.hf.jsem.shortmsg;

import org.hf.jsem.entity.JcmJobInfo;
import org.hf.jsem.runnable.MsgSenterRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adramer on 2016/11/16.
 */
@Component
public class MsgClientMuilt {
    @Autowired
    private MsgClientSingle single;


    /**
     * @Author: adrainhan
     * @Time: 2016-11-17 11:21:07
     * @Description: 短息批量发送
     * @Param: messages  短信
     * @Param: clazz  短信类型
     * @Return:
     */
    public void sentMsges(List<Message> messages, String flag, JcmJobInfo jobInfo) {
        Map<String, Integer> runInfo = getThraeadNums(messages.size());
        int threadNum = runInfo.get("threadNum");
        int size = runInfo.get("size");
        int times = 0;
        while (threadNum > 0) {
            List<Message> part = new ArrayList<Message>();
            part = messages.subList(times * size, (times + 1) * size);
            new Thread(new MsgSenterRunnable(part, flag, single, jobInfo)).start();
            times++;
            threadNum--;
        }


    }


    /**
     * @Author: adrainhan
     * @Time: 2016-11-17 10:31:56
     * @Description: 计算线程数
     * @Param:messagesNums 短信条数
     * @Return:Map
     */
    private Map<String, Integer> getThraeadNums(int messagesNums) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        int size = 0;
        int threadNum = 0;
        int maxThredNum = 100;
        if (messagesNums > 200000) {
            threadNum = maxThredNum;
        } else if (messagesNums >= 100000 && 200000 > messagesNums) {
            threadNum = maxThredNum - 30;
        } else if (50000 < messagesNums && messagesNums < 100000) {
            threadNum = maxThredNum - 50;
        } else if (50000 > messagesNums && messagesNums < 25000) {
            threadNum = maxThredNum - 70;
        } else if (25000 > messagesNums && 10000 < messagesNums) {
            threadNum = maxThredNum - 80;
        } else if (10000 > messagesNums && messagesNums > 2000) {
            threadNum = maxThredNum - 95;
        } else {
            threadNum = 2;
        }

        size = (int) (messagesNums / threadNum);
        result.put("threadNum", threadNum);  //线程数目
        result.put("size", size);//单线程发送短信条数
        return result;
    }


}

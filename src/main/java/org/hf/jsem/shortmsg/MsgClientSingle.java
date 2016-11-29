package org.hf.jsem.shortmsg;

import org.hf.jsem.dao.JcmJobInnerLogMapper;
import org.hf.jsem.dao.SscfMsgRecordMapper;
import org.hf.jsem.dao.SscfSuchMapper;
import org.hf.jsem.entity.*;
import org.hf.jsem.keypool.KeyGenerator;
import org.hf.jsem.orm.DataSourceSelector;
import org.hf.jsem.orm.MultDataSource;
import org.hf.jsem.serviceI.SscfSuchServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by adramer on 2016/11/11.
 *
 * @desc： 短信单客户端
 */
@Component
public class MsgClientSingle {
    @Autowired
    private SscfMsgRecordMapper recordMapper;
    @Autowired
    private SscfSuchServiceI suchServiceI;
    @Autowired
    private JcmJobInnerLogMapper jobInnerLogMapper;
    @Autowired
    private KeyGenerator key;

    /**
     * @Author: adrainhan
     * @Time: 2016-11-11 11:59:21
     * @Description: 短信发送客户端--单挑发送
     * @Param:shortMessage 发送短信
     * @Return:
     */
    public void sentMsgSingle(ShortMessage shortMessage, JcmJobInfo jobInfo) throws UnsupportedEncodingException {
        MsgSentSingle run = new MsgSentSingle(shortMessage.getMsgBody());
        Map<String, String> sendRes = run.send();
        try {
            if ("success".equals(sendRes.get("result"))) {
                this.recordMapper.insert(translate(shortMessage));
            } else {
                saveInnerLog(jobInfo, sendRes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @Author: adrainhan
     * @Time: 2016-11-16 14:59:20
     * @Description: 短信发送客户端--单条发送
     * @Param:
     * @Return:
     */
    public void sentMsgSingle(SuchMsg suchMsg, JcmJobInfo info) throws UnsupportedEncodingException {

        MsgSentSingle run = new MsgSentSingle(suchMsg.getMsgBody());
        Map<String, String> sendRes = run.send();
        try {
            if ("success".equals(sendRes.get("result"))) {
                this.recordMapper.insert(translate(suchMsg));
            } else {
                saveInnerLog(info, sendRes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @Author: adrainhan
     * @Time: 2016-11-15 16:14:27
     * @Description: 封装SscfMsgRecord
     * @Param: shortMessage
     * @Return: 封装SscfMsgRecord
     */
    private SscfMsgRecord translate(ShortMessage shortMessage) throws Exception {
        SscfMsgRecord msgRecord = new SscfMsgRecord();
        msgRecord.setRecId(BigDecimal.valueOf(suchServiceI.getSeqByTableName("sscf_msg_record")));
        msgRecord.setMsgCd(suchServiceI.getSeqByTableName("sscf_send_messages").toString());
        msgRecord.setMsgType(shortMessage.getType());
        msgRecord.setMsgInfo(shortMessage.getContent());
        msgRecord.setMsgStatus("Y");
        msgRecord.setCustId(BigDecimal.valueOf(0));
        msgRecord.setMobitl(shortMessage.getPhoneNo());
        msgRecord.setSendDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        msgRecord.setRemark(shortMessage.getRemark());
        msgRecord.setSender("xadmin");
        return msgRecord;
    }

    /**
     * @Author: adrainhan
     * @Time: 2016-11-15 16:21:33
     * @Description: 保存错误日志
     * @Param:jobInfo
     * @Param:sendRes
     * @Return:
     */
    private void saveInnerLog(JcmJobInfo jobInfo, Map<String, String> sendRes) {
        JcmJobInnerLog innerLog = new JcmJobInnerLog();
        innerLog.setId(BigDecimal.valueOf(key.getKeyByTableName("jcm_job_inner_log")));
        innerLog.setWorkType(jobInfo.getWorkType());
        innerLog.setJobCd(jobInfo.getJobCd());
        innerLog.setFunctionCd("MsgClientSingle.sentMsgSingle");
        innerLog.getPrcsDt();
        innerLog.setLogDtDtl(new Date());
        innerLog.setRemark(sendRes.get("info"));
        this.jobInnerLogMapper.insert(innerLog);
    }

    /**
     * @Author: adrainhan
     * @Time: 2016-11-16 14:58:32
     * @Description:
     * @Param: suchMsg
     * @Return:SscfMsgRecord
     */
    private SscfMsgRecord translate(SuchMsg suchMsg) throws Exception {
        SscfMsgRecord record = new SscfMsgRecord();
        record.setRecId(BigDecimal.valueOf(suchServiceI.getSeqByTableName("sscf_msg_record")));
        record.setMsgCd(suchServiceI.getSeqByTableName("sscf_send_messages").toString());
        record.setMsgType(suchMsg.getMsgPpsl().getMsgType());
        record.setMsgInfo(suchMsg.getMsgPpsl().getMsgInfo());
        record.setMsgStatus("Y");
        record.setCustId(suchMsg.getMsgPpsl().getCustId());
        record.setMobitl(suchMsg.getMsgPpsl().getMobitl());
        record.setSendDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        record.setRemark(suchMsg.getMsgPpsl().getRemark());
        record.setLnNo(suchMsg.getMsgPpsl().getLnNo());
        record.setSender("xadmin");
        record.setMsgTemp(suchMsg.getMsgPpsl().getMsgTemp());
        record.setMsgTempName(suchMsg.getMsgPpsl().getMsgTempName());
        record.setCustName(suchMsg.getMsgPpsl().getCustName());

        return record;
    }
}

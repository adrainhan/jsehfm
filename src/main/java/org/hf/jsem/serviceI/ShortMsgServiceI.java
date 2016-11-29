package org.hf.jsem.serviceI;

/**
 * Created by adramer on 2016/11/3.
 */
public interface ShortMsgServiceI {
    /**
     * 当调用 sentShortMsg 失败时，会调用此方法进行通知
     * */
    void  sentBadShortMsg();
    boolean sentShortMsg();



}

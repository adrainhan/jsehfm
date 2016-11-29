
package org.hf.jsem.shortmsg;

/**
 * @author adramer
 * @ClassName: MsgConfig
 * @Description: TODO 该类定义了MSG信息
 * @date 2016年10月14日
 */

public class MsgConfig {


    /**
     * @Fields: TODO  定义了短信各个字段的长度 不可变
     */
    public static final int _PACKLEN = 4;
    public static final int _TRADECODE = 6;
    public static final int _SRVID = 4;
    public static final int _BRANCHNO = 7;
    public static final int _IMMEDFLAG = 1;
    public static final int _LASTSNDTIME = 14;
    public static final int _CUSTNO = 30;
    public static final int _SRVACCNO = 30;
    public static final int _OBJADDR = 30;
    public static final int _MSGCONT = 360;   //短信内容可能包含数字 所以UTF-8的最大长度为360


}

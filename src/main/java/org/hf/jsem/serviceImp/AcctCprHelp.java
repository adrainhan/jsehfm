package org.hf.jsem.serviceImp;

/**
 * Created by adramer on 2016/11/4.
 */
public class AcctCprHelp {

    public static boolean cprStatus(String xd, String zf, String applyNo) {
        if (xd == null || "".equals(xd)) {
            throw new NullPointerException("交易流水号：" + applyNo + "信贷交易状态为空！");
        }

        if (zf == null || "".equals(zf)) {
            throw new NullPointerException("交易流水号：" + applyNo + "支付交易状态为空！");
        }

        if ("4".equals(xd) && "R".equals(zf)) return false;
        if ("3".equals(xd) && "S".equals(zf)) return false;
        if ("2".equals(xd) && "E".equals(zf)) return false;

        return true;
    }
}

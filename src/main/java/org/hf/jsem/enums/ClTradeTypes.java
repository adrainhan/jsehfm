package org.hf.jsem.enums;

/**
 * Created by adramer on 2016/11/4.
 */
public enum ClTradeTypes {
    BKAMTD("BKAmtD", "补备款交易（白天）"), BKAMTN("BKAmtN", "备款交易（晚间）"), CL("CL", "授信"), CSETL("CSETL", "代偿"), COLLOAN("ColLoan", "贷后催收"),
    CRINVEST("CrInvest", "征信补录"), CRWARN("CrWarn", "征信预警"), FRONTFEE("FrontFee","前收服管费"), LOAN("LOAN", "贷款"), REFUND("Refund", "退款"),
    REPAY("Repay", "按时还款"), SNCL("SNCL", "核销"), ACCTADJ("acctAdj", "客户账户变更"), AFTERLOAN("afterLoan", "贷后风险认定"), LNADGUST("lnAdgust", "随借随还转分期"),
    PADLOAN("padLoan", "预授权"), PREREPAY("preRepay", "提前还款");


    private String key;
    private String value;

    private  ClTradeTypes(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValue(String key) {
        String result = "位置的业务类型" + key;

        for (ClTradeTypes types : ClTradeTypes.values()) {
            if (types.key.equals(key)) {
                result = types.value;
                break;
            }
        }

        return result;
    }
}

package org.hf.jsem.enums;

/**
 * Created by adramer on 2016/11/4.
 */
public enum ClTradeStatus {

    UNSTART(0, "未启动"), INFLOWING(1, "流程中"), FAILED(2, "失败"), SUCCESS(3, "成功"), DEALIING(4, "处理中");

    private int key;
    private String name;


    private ClTradeStatus(int key, String name) {
        this.key = key;
        this.name = name;
    }


    public static String getName(int key) {
        String result = "未知装的信贷业务状态！";
        for (ClTradeStatus tradeStatus : ClTradeStatus.values()) {
            if (tradeStatus.key == key) {
                result = tradeStatus.name;
                break;
            }
        }

        return result;
    }


}

package org.hf.jsem.enums;

/**
 * Created by adramer on 2016/11/4.
 */
public enum ZfTradeStatus {
    S("S","成功"), F("F","失败"), R("R","待查询");

    private String name;
    private String key;

    private ZfTradeStatus(String key,String name) {
        this.key = key;
        this.name = name;
    }

    public static String getName(String key){
        String result = "未知的支付状态！";

        for(ZfTradeStatus  status: ZfTradeStatus.values()){
            if(status.key.equals(key)){
                return status.name;
            }
        }
        return  result;
    }


    }

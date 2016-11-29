package org.hf.jsem.test;

import org.hf.jsem.entity.SscfWorkMain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adramer on 2016/11/29.
 */
public class TestInvoke {

    public Map<String,String> test(List<SscfWorkMain> workMains){
        System.out.println("hey....................");

        Map<String,String> result  = new HashMap<String, String>();
        result.put("info","invoke success..................");
        return  result;

    }



}

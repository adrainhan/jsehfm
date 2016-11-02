package org.hf.jsem.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by adramer on 2016/11/1.
 */
public class PropertyUtil {

    public static Map<String, String> getAll(String filePath) throws IOException {
        Map<String, String> result = new HashMap<String, String>();
        Properties p = new Properties();
        p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath));
        Set<String> keys = p.stringPropertyNames();
        for (String key : keys) {
            result.put(key, p.get(key).toString());
        }

        return result;
    }


}

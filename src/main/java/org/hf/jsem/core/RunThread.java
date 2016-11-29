package org.hf.jsem.core;

import org.hf.jsem.keypool.KeyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by adramer on 2016/11/9.
 */
public class RunThread implements Runnable {
    private String name;
    private KeyGenerator keyGenerator;
    private File file;

    public RunThread(String name, KeyGenerator keyGenerator, File file) {
        this.name = name;
        this.keyGenerator = keyGenerator;
        this.file = file;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " begin...............");
        String in = null;
        OutputStream out = null;

        try {
            for (int i = 0; i < 10000; i++) {
                out = new FileOutputStream(file, true);
                in = new StringBuffer().append(Thread.currentThread().getName()).append(name).append(keyGenerator.getKeyByTableName(name).toString()).toString()+"\r\n";
                out.write(in.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " stop...............");
        }
    }
}

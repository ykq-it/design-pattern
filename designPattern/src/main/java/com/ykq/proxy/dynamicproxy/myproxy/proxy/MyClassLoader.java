package com.ykq.proxy.dynamicproxy.myproxy.proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 功能描述：
 *
 * @author: ykq
 * @date: 2021/3/24 16:05
 */
public class MyClassLoader extends ClassLoader {

    private File classPathFiles;

    public MyClassLoader() {
        String classPath = MyClassLoader.class.getResource("").getPath();
        this.classPathFiles = new File(classPath);
    }

    @Override
    public Class<?> findClass(String name) {
        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        if (classPathFiles != null) {
            File classFile = new File(classPathFiles, name.replace("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }
                    return defineClass(className, out.toByteArray(), 0, out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

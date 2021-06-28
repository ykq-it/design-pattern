package com.ykq.proxy.dynamicproxy.myproxy.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 功能描述：
 *
 * @author: ykq
 * @date: 2021/3/24 15:38
 */
public class MyProxy {

    public static final String LN = "\r\n";
    public static Object newProxyInstance(MyClassLoader loader,
                                          Class<?>[] interfaces,
                                          MyInvocationHandler h) {

        try {
            // 1、动态生成源码.java文件。拼字符串
            String src = generateSrc(interfaces);
            System.out.println("================================");
            System.out.println(src);

            // 2、java文件输出到磁盘，保存为$Proxy0.java
            String filePath = MyProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fileWriter = new FileWriter(f);
            fileWriter.write(src);
            fileWriter.flush();
            fileWriter.close();

            // 3、把java文件编译成$Proxy0.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 4、把生成的class文件加载到JVM中
            Class proxyClass = loader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(MyInvocationHandler.class);

            // 5、返回新的代理对象
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.ykq.proxy.dynamicproxy.myproxy.proxy;" + LN);
        sb.append("import com.ykq.proxy.dynamicproxy.myproxy.IPerson;" + LN);
        sb.append("import java.lang.reflect.*;" + LN);
        sb.append("import java.lang.reflect.*;" + LN);
//        sb.append("public final class $Proxy0 extends Proxy implements IPerson {")
        sb.append("public final class $Proxy0 implements " + interfaces[0].getName() +" {" + LN);
        sb.append("MyInvocationHandler h;" + LN);
        sb.append("public $Proxy0(MyInvocationHandler h) {" + LN);
        sb.append("this.h = h;" + LN);
        sb.append("}" + LN);

        for (Method m : interfaces[ 0].getMethods()) {
            Class<?>[] params = m.getParameterTypes();

            StringBuilder paramNames = new StringBuilder();
            StringBuilder paramValues = new StringBuilder();
            StringBuilder paramClasses = new StringBuilder();

//            for (int i = 0; i < params.length; i++) {
//                paramNames.append(params[i].getName());
//                paramValues.append(params[i].get);
//                paramClasses.append();
//            }

            sb.append("@Override" + LN);
            sb.append("public final " + m.getReturnType() + " " + m.getName() + "() {" + LN);
            sb.append("    try {" + LN);
            sb.append("         Method mn = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\", new Class[]{});" + LN);
            sb.append("        this.h.invoke(this, mn, new Class[]{});" + LN);
            sb.append("        return;" + LN);
            sb.append("    } catch (Error|RuntimeException error) {" + LN);
            sb.append("        throw null;" + LN);
            sb.append("    } catch (Throwable throwable) {" + LN);
            sb.append("        throw new UndeclaredThrowableException(throwable);" + LN);
            sb.append("    }" + LN);
            sb.append("}" + LN);
        }
        sb.append("}" + LN);
        return sb.toString();
    }
}

//public final class $Proxy0 extends Proxy implements IPerson {
//    private static Method m1;
//
//    private static Method m2;
//
//    private static Method m3;
//
//    private static Method m0;
//
//    public $Proxy0(InvocationHandler paramInvocationHandler) {
//        super(paramInvocationHandler);
//    }
//
//    public final boolean equals(Object paramObject) {
//        try {
//            return ((Boolean)this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
//        } catch (Error|RuntimeException error) {
//            throw null;
//        } catch (Throwable throwable) {
//            throw new UndeclaredThrowableException(throwable);
//        }
//    }
//
//    public final String toString() {
//        try {
//            return (String)this.h.invoke(this, m2, null);
//        } catch (Error|RuntimeException error) {
//            throw null;
//        } catch (Throwable throwable) {
//            throw new UndeclaredThrowableException(throwable);
//        }
//    }
//
//    public final void Hungary() {
//        try {
//            this.h.invoke(this, m3, null);
//            return;
//        } catch (Error|RuntimeException error) {
//            throw null;
//        } catch (Throwable throwable) {
//            throw new UndeclaredThrowableException(throwable);
//        }
//    }
//
//    public final int hashCode() {
//        try {
//            return ((Integer)this.h.invoke(this, m0, null)).intValue();
//        } catch (Error|RuntimeException error) {
//            throw null;
//        } catch (Throwable throwable) {
//            throw new UndeclaredThrowableException(throwable);
//        }
//    }
//
//    static {
//        try {
//            m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[] { Class.forName("java.lang.Object") });
//            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
//            m3 = Class.forName("com.ykq.proxy.dynamicproxy.jdkproxy.IPerson").getMethod("Hungary", new Class[0]);
//            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
//            return;
//        } catch (NoSuchMethodException noSuchMethodException) {
//            throw new NoSuchMethodError(noSuchMethodException.getMessage());
//        } catch (ClassNotFoundException classNotFoundException) {
//            throw new NoClassDefFoundError(classNotFoundException.getMessage());
//        }
//    }
//}
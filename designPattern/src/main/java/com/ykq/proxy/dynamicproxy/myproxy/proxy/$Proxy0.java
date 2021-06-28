package com.ykq.proxy.dynamicproxy.myproxy.proxy;
import com.ykq.proxy.dynamicproxy.myproxy.IPerson;
import java.lang.reflect.*;
import java.lang.reflect.*;
public final class $Proxy0 implements com.ykq.proxy.dynamicproxy.myproxy.IPerson {
    MyInvocationHandler h;
    public $Proxy0(MyInvocationHandler h) {
        this.h = h;
    }
    @Override
    public final void hungary() {
        try {
            Method mn = com.ykq.proxy.dynamicproxy.myproxy.IPerson.class.getMethod("hungary", new Class[]{});
            this.h.invoke(this, mn, new Class[]{});
            return;
        } catch (Error|RuntimeException error) {
            throw null;
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }
}
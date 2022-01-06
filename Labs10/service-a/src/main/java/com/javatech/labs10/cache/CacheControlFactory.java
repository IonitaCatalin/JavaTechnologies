package com.javatech.labs10.cache;

import com.javatech.labs10.annotations.CacheControlConfig;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.ws.rs.core.CacheControl;

public class CacheControlFactory {

    @Produces
    public CacheControl get(InjectionPoint ip) {

        CacheControlConfig ccConfig = ip.getAnnotated().getAnnotation(CacheControlConfig.class);
        CacheControl cc = null;
        if (ccConfig != null) {
            cc = new CacheControl();
            cc.setMaxAge(ccConfig.maxAge());
            cc.setMustRevalidate(ccConfig.mustRevalidate());
            cc.setNoCache(ccConfig.noCache());
            cc.setNoStore(ccConfig.noStore());
            cc.setNoTransform(ccConfig.noTransform());
            cc.setPrivate(ccConfig.isPrivate());
            cc.setProxyRevalidate(ccConfig.proxyRevalidate());
            cc.setSMaxAge(ccConfig.sMaxAge());
        }

        return cc;
    }
}
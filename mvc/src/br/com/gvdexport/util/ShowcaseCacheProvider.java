package br.com.gvdexport.util;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import org.primefaces.cache.CacheProvider;
import org.primefaces.cache.EHCache3Provider;

@ApplicationScoped
public class ShowcaseCacheProvider {

    private CacheProvider cacheProvider;

    @PostConstruct
    public void init() {
        cacheProvider = new EHCache3Provider();
    }

    public CacheProvider getCacheProvider() {
        return cacheProvider;
    }
}

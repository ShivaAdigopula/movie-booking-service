package com.albathanext.movie.config;


import com.albathanext.movie.dto.MoviesResponse;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.time.Duration;

@EnableCaching
@Configuration
public class CacheConfiguration {

    @Bean
    public CacheManager ehCacheManager() {
        CachingProvider provider = Caching.getCachingProvider();
        CacheManager cacheManager = provider.getCacheManager();
        CacheConfigurationBuilder<Long, MoviesResponse>
                configuration =
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, MoviesResponse.class,
                                ResourcePoolsBuilder
                                        .newResourcePoolsBuilder().offheap(1, MemoryUnit.MB))
                        .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(20)));
        javax.cache.configuration.Configuration<Long, MoviesResponse>
                stringDoubleConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(configuration);
        cacheManager.createCache("featuredMoviesCache", stringDoubleConfiguration);
        return cacheManager;
    }
}


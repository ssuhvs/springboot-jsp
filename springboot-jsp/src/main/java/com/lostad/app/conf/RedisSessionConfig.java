package com.lostad.app.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration  
@EnableRedisHttpSession  
public class RedisSessionConfig {  
	@Bean  
	public JedisConnectionFactory jedisConnectionFactory() {  
	     return new JedisConnectionFactory();  
	 }  
	      
	 @Bean 
	 public RedisTemplate<String, String>redisTemplate(RedisConnectionFactory factory) {  
        RedisTemplate<String, String> template = new RedisTemplate<String, String>();  
        template.setConnectionFactory(jedisConnectionFactory());  
          
        template.setKeySerializer(new StringRedisSerializer());  
        template.setValueSerializer(new StringRedisSerializer());  
        return template;  
	  }  
} 
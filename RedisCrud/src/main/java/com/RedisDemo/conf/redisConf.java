package com.RedisDemo.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class redisConf {

	@Value("${redis.host}")
	private String redisHostName;
	
	@Value("${redis.port}")
	private Integer redisPort;
	
	@Bean
	public JedisConnectionFactory connectionFactory() {
		RedisStandaloneConfiguration redConfiguration=new RedisStandaloneConfiguration();
		redConfiguration.setHostName(redisHostName);
		redConfiguration.setPort(redisPort);
		return new JedisConnectionFactory(redConfiguration);
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		RedisTemplate<String, Object> redisTemplate=new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setValueSerializer(new  JdkSerializationRedisSerializer());
		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
	

}
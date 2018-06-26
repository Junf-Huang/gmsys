package com.exercise.gmsys.config;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 24 * 60 * 60)
public class SessionConfig {
}

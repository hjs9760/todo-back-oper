package com.js.ms.todo.global.config.security;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {
    @Bean("jasyptEncryptor")
    public StringEncryptor stringEncryptor() {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("todoEncrypt"); //암호화에 사용할 키
        encryptor.setAlgorithm("PBEWithMD5AndDES"); //사용할 알고리즘

        return encryptor;
    }
}

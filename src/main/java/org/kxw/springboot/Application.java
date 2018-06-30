package org.kxw.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Create by kangxiongwei on 2018/6/28 15:38.
 */
@SpringBootApplication(scanBasePackages = "org.kxw.springboot")
@ImportResource("classpath:beans.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

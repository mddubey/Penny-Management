package com.vellas.gareebs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mritunjd on 09/09/17.
 * This class will be used as a config file for tests.
 * Beans which will be used just in tests should be defined here.
 */
@Configuration
@ComponentScan({"com.vellas.gareebs"})
public class TestConfig {
}

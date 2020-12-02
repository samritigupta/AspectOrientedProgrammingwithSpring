package com.springmvclearn.aoparoundadvice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.springmvclearn.aoparoundadvice")
public class DemoConfig {

}

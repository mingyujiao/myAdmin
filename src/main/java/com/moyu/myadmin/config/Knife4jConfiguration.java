package com.moyu.myadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/18 10:22
 */

@Configuration
@EnableSwagger2
public class Knife4jConfiguration {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        //.title("swagger-bootstrap-ui-demo RESTful APIs")
                        .description("# swagger-bootstrap-ui-demo RESTful APIs")
                        .termsOfServiceUrl("http://www.xx.com/")
                        .contact(new Contact("一二三四五", "123", "jiaomingyu5888@gmail.com"))
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("1.0 版本")
                .select()
                //这里指定你自己的Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.moyu.myadmin.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}

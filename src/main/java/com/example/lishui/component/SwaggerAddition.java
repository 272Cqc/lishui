package com.example.lishui.component;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.OperationBuilder;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiDescription;
import springfox.documentation.service.Operation;
import springfox.documentation.service.ParameterType;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ApiListingScannerPlugin;
import springfox.documentation.spi.service.contexts.DocumentationContext;
import springfox.documentation.spring.web.readers.operation.CachingOperationNameGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jesse on 2020/12/14 下午3:47
 */
@Component
public class SwaggerAddition implements ApiListingScannerPlugin {
    /**
     * Implement this method to manually add ApiDescriptions
     * 实现此方法可手动添加ApiDescriptions
     *
     * @param context - Documentation context that can be used infer documentation context
     */

    @Override
    public List<ApiDescription> apply(DocumentationContext context) {
        Operation usernamePasswordOperation = new OperationBuilder(new CachingOperationNameGenerator())
                .method(HttpMethod.POST)
                .summary("用户名密码登录")
                .notes("username/password登录")
                .consumes(Collections.singleton(MediaType.APPLICATION_FORM_URLENCODED_VALUE)) // 接收参数格式
                .produces(Collections.singleton(MediaType.APPLICATION_JSON_VALUE)) // 返回参数格式
                .tags(Collections.singleton("登录"))
                .requestParameters(Arrays.asList(
                        new RequestParameterBuilder()
                                .description("用户名")
//                                .type(new TypeResolver().resolve(String.class))
                                .name("username")
                                .in(ParameterType.QUERY)
//                                .defaultValue("admin")
//                                .parameterType("query")
//                                .parameterAccess("access")
                                .required(true)
//                                .modelRef(new ModelRef("string"))
                                .build(),
                        new RequestParameterBuilder()
                                .description("密码")
//                                .type(new TypeResolver().resolve(String.class))
                                .name("password")
//                                .defaultValue("123456")
//                                .parameterType("query")
//                                .parameterAccess("access")
                                .required(true)
//                                .modelRef(new ModelRef("string"))
                                .build(),
//                        new RequestParameterBuilder()
//                                .description("验证码唯一标识")
////                                .type(new TypeResolver().resolve(String.class))
//                                .name("randomKey")
////                                .defaultValue("666666")
////                                .parameterType("query")
////                                .parameterAccess("access")
//                                .required(true)
////                                .modelRef(new ModelRef("string"))
//                                .build(),
                        new RequestParameterBuilder()
                                .description("验证码")
//                                .type(new TypeResolver().resolve(String.class))
                                .name("code")
//                                .parameterType("query")
//                                .parameterAccess("access")
                                .required(true)
//                                .modelRef(new ModelRef("string"))
                                .build()
                ))
                .responses(Collections.singleton(
                        new ResponseBuilder().code("200").description("请求成功").build()))
//                .responseMessages(Collections.singleton(
//                        new ResponseMessageBuilder().code(200).message("请求成功")
//                                .responseModel(new ModelRef(
//                                        "xyz.gits.boot.common.core.response.RestResponse")
//                                ).build()))
                .build();

        ApiDescription loginApiDescription = new ApiDescription("login", "/api/login", "登录接口","登录接口",
                Arrays.asList(usernamePasswordOperation), false);

        Operation logoutOperation = new OperationBuilder(new CachingOperationNameGenerator())
                .method(HttpMethod.GET)
                .summary("注销")
                .notes("注销")
//                .consumes(Collections.singleton(MediaType.APPLICATION_FORM_URLENCODED_VALUE)) // 接收参数格式
                .produces(Collections.singleton(MediaType.APPLICATION_JSON_VALUE)) // 返回参数格式
                .tags(Collections.singleton("注销"))
//                .requestParameters(Arrays.asList(
//
//                ))
                .responses(Collections.singleton(
                        new ResponseBuilder().code("200").description("请求成功").build()))
//                .responseMessages(Collections.singleton(
//                        new ResponseMessageBuilder().code(200).message("请求成功")
//                                .responseModel(new ModelRef(
//                                        "xyz.gits.boot.common.core.response.RestResponse")
//                                ).build()))
                .build();

        ApiDescription logoutApiDescription = new ApiDescription("logout", "/api/logout", "注销接口","注销接口",
                Arrays.asList(logoutOperation), false);


        return Arrays.asList(loginApiDescription,logoutApiDescription);

    }
    /**
     * 是否使用此插件
     *
     * @param documentationType swagger文档类型
     * @return true 启用
     */
    @Override
    public boolean supports(DocumentationType documentationType) {
        return true;
    }

}

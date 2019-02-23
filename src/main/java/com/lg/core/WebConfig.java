package com.lg.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @类名称：WebConfig
 * @作者: 段大神经
 * @创建时间: 2018/9/29 22:09
 * @说明: web配置类
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;
    //不经过controller实现页面跳转
    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //第一个（）里面时访问方法   第二个是跳转页面
       //registry.addViewController("/login").setViewName("viewindex");
    }*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //定义拦截路径和放行路径
        registry.addInterceptor(myInterceptor)
                //拦截配置
                .addPathPatterns("/**")
        //不拦截路径
                .excludePathPatterns(
               "/css/**","/js/**","/images/**"
        )
        ;
    }
    //注入视图处理器bean
   /* @Bean
    public InternalResourceViewResolver viewResolver(){
      InternalResourceViewResolver resourceViewResolver=new InternalResourceViewResolver();
      resourceViewResolver.setPrefix("/");
      resourceViewResolver.setSuffix(".jsp");
      resourceViewResolver.setViewClass(JstlView.class);
      return resourceViewResolver;
    }*/
     //自定义静态资源
    /* @Override
     public void addResourceHandlers(ResourceHandlerRegistry registry) {
//          registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//         WebMvcConfigurer.super.addResourceHandlers(registry);
     }*/

}

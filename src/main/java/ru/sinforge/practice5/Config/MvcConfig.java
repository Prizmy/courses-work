package ru.sinforge.practice5.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;
import java.util.Optional;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/application").setViewName("applicationPage");
        registry.addViewController("/admin/panel").setViewName("admin/panel");
    }
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/static/css/**")
                .addResourceLocations("classpath:/static/");
        registry
                .addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(0)
                .resourceChain(true)
                .addResolver(new PathResourceResolver() {
                    protected Object getMediaType(Resource resource) throws IOException {
                        Optional<MediaType> mediaType = MediaTypeFactory.getMediaType(resource);
                        return mediaType.equals(MediaType.APPLICATION_OCTET_STREAM)
                                ? MediaTypeFactory.getMediaType(resource.getFilename()).orElse(MediaType.APPLICATION_OCTET_STREAM)
                                : mediaType;
                    }
                });
    }
}
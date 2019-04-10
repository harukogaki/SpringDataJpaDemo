package com.example.springdatajpademo;

import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import static java.lang.Integer.parseInt;

public class PageableArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(Pageable.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String pageParam = nativeWebRequest.getParameter("page.number");
        String sizeParam = nativeWebRequest.getParameter("page.size");
        int page = pageParam != null ? parseInt(pageParam) : 0;
        int size = sizeParam != null ? parseInt(sizeParam) : 10;
        return PageRequest.of(page, size);
    }
}

package com.study.ikmyeongshopteam4.aop;

import com.study.ikmyeongshopteam4.exception.CustomValidationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Aspect
public class ValidationAop {


//    private void executionPointCut(){}
    @Pointcut("@annotation(com.study.ikmyeongshopteam4.aop.annotation.ValidAspect)")
    private void annotationPointCut(){}

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args =  joinPoint.getArgs();

        BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class){
                bindingResult = (BeanPropertyBindingResult)arg;
                break;
            }
        }

        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<String,String>();

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors){
                errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }

            throw new CustomValidationException("Validation Error",errorMap);

        }

        Object result = null;
        result = joinPoint.proceed();

        return result;
    }
}

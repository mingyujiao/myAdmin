package com.moyu.myadmin.config;

import com.moyu.myadmin.utils.ResultData;
import com.moyu.myadmin.utils.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/12 23:27
 */

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * 异常数据封装.
     *
     * @param e 异常信息
     * @return 错误消息
     */
    @ExceptionHandler(value = BindException.class)
    public ResultData<String> handleValidException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            String errMsg = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining());
            log.error("参数验证失败，错误消息：{}", errMsg);
            return ResultData.error(ReturnCode.RC999.getCode(), errMsg);
        }
        return ResultData.error(ReturnCode.RC999.getCode(), ReturnCode.RC999.getMessage());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResultData<String> constraintViolationException(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
        return ResultData.error(ReturnCode.RC999.getCode(), message);
    }

    /**
     * 默认全局异常处理。
     *
     * @param e the e
     * @return ResultData
     */
    @ExceptionHandler(value = Exception.class)
    public ResultData<String> exception(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        // 异常消息不要抛给前端，进行包装后返回
        return ResultData.error(ReturnCode.RC500.getCode(), ReturnCode.RC500.getMessage());
    }


}

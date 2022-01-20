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

import java.util.Objects;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/12 23:27
 */

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * 异常数据封装.
     * @param e 异常信息
     * @return 错误消息
     */
    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public ResultData<String> handleValidException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (Objects.nonNull(fieldError)) {
                log.error("参数验证失败，字段名称：{}，错误消息：{}", fieldError.getField(), fieldError.getDefaultMessage());
                return ResultData.error(ReturnCode.RC999.getCode(), fieldError.getDefaultMessage());
            }
        }
        return ResultData.error(ReturnCode.RC999.getCode() , ReturnCode.RC999.getMessage());
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

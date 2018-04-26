package com.yuqiyu;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/29
 * Time：10:38
 * 码云：http://git.oschina.net/jnyqy
 * <p>
 * 配置全局的异常Handler
 * <p>
 *
 * @ControllerAdvice注解是用来配置控制器通知的，我们可以配置过滤拦截具体一种或者多种类型的注解，添加annotations属性即可， 因为我们全局返回的都是Json格式的字符串，所以需要再类上配置@ResponseBody注解
 * <p>
 * ========================
 */
//在类的上方我们配置了@ControllerAdvice的annotations属性值为RestController.class，也就是只有添加了@RestController注解的控制器才会进入全局异常处理
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {
    /**
     * 默认统一异常处理方法
     *
     * @param e 默认Exception异常对象
     * @return
     */
    @ExceptionHandler//@ExceptionHandler注解用来配置需要拦截的异常类型，默认是全局类型
    @ResponseStatus(value=HttpStatus.FORBIDDEN,reason="出现异常了")//@ResponseStatus注解用于配置遇到该异常后返回数据时的StatusCode的值，我们这里默认使用值500
    public ApiResult runtimeExceptionHandler(Exception e) {
        return ApiResultGenerator.errorResult(e.getMessage(), e);
    }
}

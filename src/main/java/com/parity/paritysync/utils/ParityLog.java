package com.parity.paritysync.utils;

import java.lang.annotation.*;

/**
 * @author an_qiang on 2018/06/02 0002.
 * @version 1.0
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParityLog {

    String value() default "";
}

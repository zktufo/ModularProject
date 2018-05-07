package com.leozkt.baselib.exception;

/**
 * @author zhengkaituo
 * @date 2018/4/27
 */
public class ResNotFoundException extends RuntimeException {
    public ResNotFoundException() {
        super("There is no resource found");
    }
}

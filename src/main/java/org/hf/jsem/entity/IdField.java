package org.hf.jsem.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by adramer on 2016/10/25.
 */


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface IdField {

}
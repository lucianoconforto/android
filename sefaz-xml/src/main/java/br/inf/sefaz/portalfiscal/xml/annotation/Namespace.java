package br.inf.sefaz.portalfiscal.xml.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Namespace {
    String reference() default "";
    String prefix() default "";
}

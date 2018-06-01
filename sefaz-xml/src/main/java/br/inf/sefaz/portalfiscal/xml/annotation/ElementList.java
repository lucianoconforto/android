package br.inf.sefaz.portalfiscal.xml.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ElementList   {

    String name();
    String prefix() default "";
    String reference() default "";
    boolean inline() default true;
}

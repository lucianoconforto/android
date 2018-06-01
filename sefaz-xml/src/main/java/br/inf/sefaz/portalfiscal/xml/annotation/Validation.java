package br.inf.sefaz.portalfiscal.xml.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Validation {
    String whiteSpace() default  "";
    String pattern() default  "";


    String maxLength()default  "";

    String minLength()default  "";

    String length() default  "";

    String text() default  "";

    boolean required() default true;

    String choices() default  "";

    String minOccurs()  default  "1";

    String[] enumerations() default {};
}

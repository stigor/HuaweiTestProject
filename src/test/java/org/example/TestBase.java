package org.example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class TestBase {

    @Tag("ParameterizedTestWithDisplayName")
    @Target({ANNOTATION_TYPE, METHOD})
    @Retention(RUNTIME)
    @ParameterizedTest(name = "{displayName} -> {arguments}")
    protected @interface ParameterizedTestWithDisplayName {
    }

}

package com.geektime.spring.data.simplejdbcdemo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Foo {
    private Long id;
    private String bar;

    public Foo() {
    }

    public Foo(Long id, String bar) {
        this.id = id;
        this.bar = bar;
    }
}

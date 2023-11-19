package com.oracle;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.oracle.App;
public class AppTest {
    @Test
    public void testMain() {
        // mainメソッドがエラーをスローしないことを確認する
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }
}
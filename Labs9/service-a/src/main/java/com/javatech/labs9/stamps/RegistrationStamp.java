package com.javatech.labs9.stamps;

import javax.enterprise.inject.Default;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@Default
public class RegistrationStamp implements Stamp {
    @Override
    public String getStamp() {
        byte[] array = new byte[7];
        new Random().nextBytes(array);

        return new String(array, StandardCharsets.UTF_8);
    }
}

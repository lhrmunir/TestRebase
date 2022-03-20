package com.optional.stackify.test.optional.chaining;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import com.optional.stackify.code.optional.chaining.Address;
import com.optional.stackify.code.optional.chaining.Country;
import com.optional.stackify.code.optional.chaining.User;
// import com.optional.stackify.main.java.com.stackify.optional.
;
public class OptionalChainingTest {

    @Test
    public void whenChaining_thenOk() {
        User user = new User("anna@gmail.com", "1234");

        String result = Optional.ofNullable(user)
                .flatMap(u -> u.getAddress())
                .flatMap(a -> a.getCountry())
                .map(c -> c.getIsocode())
                .orElse("default");

        assertEquals(result, "default");
    }
    
    @Test
    public void whenChainingWithMethodReferences_thenOk() {
        User user = new User("anna@gmail.com", "1234");

        String result = Optional.ofNullable(user)
                .flatMap(User::getAddress)
                .flatMap(Address::getCountry)
                .map(Country::getIsocode)
                .orElse("default");

        assertEquals(result, "default");
    }
}

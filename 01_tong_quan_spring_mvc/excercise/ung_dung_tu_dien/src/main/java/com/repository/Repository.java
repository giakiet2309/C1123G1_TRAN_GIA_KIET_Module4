package com.repository;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Repository
public class Repository implements IRepository{
    private final static Map<String, String> map = new HashMap<>();
    static {
        map.put("cat", "cun mèo");
        map.put("dog", "cun chó");
        map.put("iskiet", "đẹp trai");
    }
    public String translate(String word){

        String result = map.get(word);
        if (result == null){
            return word + " chưa có trong từ điển";
        } else {
            return result;
        }
    }
}

package com.aaron.security.dto;

import java.io.Serializable;
import java.util.List;

public class TestDto implements Serializable {
    private String name;
    private List<Integer> nums;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getNums() {
        return nums;
    }

    public void setNums(List<Integer> nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "name='" + name + '\'' +
                ", nums=" + nums +
                '}';
    }
}

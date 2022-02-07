package com.demo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserResponse implements Serializable {


    private String title;

    private String content;

    private int userId;
}

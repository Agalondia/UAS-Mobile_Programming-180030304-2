package com.bi183.anandakusuma.model;

import java.util.List;

public class ResponseData {

    private String value;
    private String message;
    private List<Kampus> result;

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public List<Kampus> getResult() {
        return result;
    }
}
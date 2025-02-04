package com.muhammet.jpa.config;

public class RestApis {

    private static final String VERSION = "/v1";
    private static final String DEV = "/dev";
    private static final String PROD = "/prod";
    private static final String TEST = "/test";
    private static final String API = "/api";
    private static final String BASE_URL = DEV + VERSION;
    public static final String CUSTOMER = BASE_URL+ "/customer";
    public static final String PRODUCT = BASE_URL+ "/product";
    public static final String USER = BASE_URL+ "/user";
    public static final String AUTH = BASE_URL + "/auth";

    public static final String ADD_CUSTOMER = "/add-customer";
    public static final String ADD_PRODUCT= "/add-product";
    public static final String GET_ALL = "/get-all";
    public static final String GET_BY_NAME = "/get-by-name";
    public static final String GET_ALL_BY_MODEL = "/get-all-by-model";
    public static final String DO_REGISTER = "/do-register";
    public static final String DO_LOGIN = "/do-login";

}

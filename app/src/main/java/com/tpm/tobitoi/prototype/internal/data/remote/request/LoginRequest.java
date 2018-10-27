package com.tpm.tobitoi.prototype.internal.data.remote.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Tobitoi on 20/10/2018.
 */

public class LoginRequest {

    @JsonProperty(value = "username")
    public String username;

    @JsonProperty(value = "password")
    public String password;
}

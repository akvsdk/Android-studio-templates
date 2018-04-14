package com.j1ang.demo.home.model;

import com.j1ang.demo.home.contract.LoginContract;

/**
 * Date:  2018-4-12 10:13:54
 * version:  V1.0
 * Description:
 *
 * @author Joy
 */

public class LoginModel implements LoginContract.Model {

    @Override
    public String setUser() {
        return "SB110";
    }
}

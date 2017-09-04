package me.stonerivers.controller;

import me.stonerivers.model.user.User;
import me.stonerivers.model.vo.ResponseVo;
import me.stonerivers.model.vo.SuccessVo;
import me.stonerivers.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhang on 2017/9/4.
 */
@RestController
@RequestMapping("/login")
public class MainController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/validate.json", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseVo validate(@RequestBody User req) throws Exception {

        boolean validate = loginService.validate(req.getName(), req.getPassword());
        if (validate) {
            return SuccessVo.BLANK_SUCCESS_VO;
        } else {
            return SuccessVo.BLANK_SUCCESS_VO;
        }
    }

}

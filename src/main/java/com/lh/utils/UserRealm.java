package com.lh.utils;

import com.lh.pojo.Person;
import com.lh.service.PersonService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm
 * Created by laiHom on 2019/8/21.
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private PersonService personService;

    //执行授权逻辑
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //shiro判断逻辑，判断用户名和密码
        //1、判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        Person person = personService.getUserName(token.getUsername());

        if(person == null){
            //用户不存在
            return null;//shiro底层会抛出UnKnowAccountException
        }
        return new SimpleAuthenticationInfo("",person.getPassword(),"");
    }
}

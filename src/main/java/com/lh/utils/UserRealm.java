package com.lh.utils;

import com.lh.pojo.Person;
import com.lh.pojo.Resource;
import com.lh.pojo.Role;
import com.lh.service.PersonService;
import com.lh.service.ResourceService;
import com.lh.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义Realm
 * Created by laiHom on 2019/8/21.
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private PersonService personService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private RoleService roleService;

    //执行授权逻辑
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权逻辑");
        Person person= (Person) SecurityUtils.getSubject().getPrincipal();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("roleId",person.getRoleId());
        Role role = roleService.getById(person.getRoleId());
        List<Resource> resourcesList = resourceService.loadPersonResources(map);
        System.out.println("拿资源？**************");
        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for(Resource resource: resourcesList){
            info.addStringPermission(resource.getResoureUrl());
        }
            info.addRole(role.getRoleName());
        return info;
//        return null;
    }

    //执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证逻辑");
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();
        int state= (int) session.getAttribute("state");
        //

        //shiro判断逻辑，判断用户名和密码
        //1、判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        Person person = personService.getUserName(token.getUsername(),state);

        if(person == null){
            //用户不存在
            return null;//shiro底层会抛出UnKnowAccountException
        }
        request.getSession().setAttribute("userName", person.getName());
        return new SimpleAuthenticationInfo(person,person.getPassword(), "");
    }
}

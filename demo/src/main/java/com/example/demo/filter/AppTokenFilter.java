package com.example.demo.filter;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.constants.Contants;
import com.example.demo.common.dtos.ResponseResult;
import com.example.demo.common.enums.AppHttpCodeEnum;
import com.example.demo.pojo.ApUser;
import com.example.demo.utils.jwt.AppJwtUtil;
import com.example.demo.utils.threadlocal.AppThreadLocalUtils;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Order(2)
@WebFilter(filterName = "appTokenFilter" ,urlPatterns = "/*" )
public class AppTokenFilter extends GenericFilterBean {
    //白名单
    private static final Set<String> set = new HashSet<>();
    static {
        set.add("/login");
    }

    public  void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        //不在白名单的token校验
        if (!set.contains(path)){
            if (checkToken(request)!=null){
                return;
            }
        }
        chain.doFilter(req,res);
    }

    /**
     * 判断TOKEN信息，并设置为上下文
     * @param request
     * @return
     * 如果验证不通过则返回对应的错误，否则返回null继续执行
     */
    public ResponseResult checkToken(HttpServletRequest request){
        String token = request.getHeader("token");
        ResponseResult<?> rr = null;
        if(StringUtils.isNotEmpty(token)) {
            Claims claims = AppJwtUtil.getClaimsBody(token);
            int result = AppJwtUtil.verifyToken(claims);
            // 有效的token
            if (result == 0||result==-1) {
                ApUser user = new ApUser();
                user.setId(Long.valueOf((Integer)claims.get("id")));
                user = findUser(user);
                if(user.getId()!=null) {
                    AppThreadLocalUtils.setUser(user);
                    //验证成功 发送用户刷新消息
                    sendUserRefresh(user);
                }else{
                    rr = ResponseResult.setAppHttpCodeEnum(AppHttpCodeEnum.TOKEN_INVALID);
                }
            }else if(result==1){
                // 过期
                rr = ResponseResult.setAppHttpCodeEnum(AppHttpCodeEnum.TOKEN_EXPIRE);
            }else if(result==2){
                // TOKEN错误
                rr = ResponseResult.setAppHttpCodeEnum(AppHttpCodeEnum.TOKEN_INVALID);
            }
        }else{
            rr = ResponseResult.setAppHttpCodeEnum(AppHttpCodeEnum.TOKEN_REQUIRE);
        }
        return rr;
    }

    /**
     * 发送用户刷新消息
     * @param user
     */
    private void sendUserRefresh(ApUser user) {
        //http invoke send kafka
    }

    public ApUser findUser(ApUser user){
        user.setName("test");
        return user;
    }

}

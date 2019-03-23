package com.red.red2.filter;



import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;


@Component
public class DemoFilter implements Filter {
 @Override
//过滤器初始化调用
       public void init(FilterConfig arg0) throws ServletException {
System.out.println("time filter init");
}



    @Override
//过滤器销毁时调用
  public void destroy() {
System.out.println("time filter destroy");
}

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
throws IOException, ServletException {

}
}

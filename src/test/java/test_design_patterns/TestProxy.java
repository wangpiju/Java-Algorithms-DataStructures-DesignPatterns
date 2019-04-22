package test_design_patterns;

import design_pattern.proxy.IUserDao;
import design_pattern.proxy.ProxyFactory;
import design_pattern.proxy.UserDao;
import design_pattern.proxy.UserDaoProxy;

public class TestProxy {

    public static void main(String[] args) {
        //testStaticProxy();
        testDynamicProxy();
    }
    //測試靜態代理
    public static void testStaticProxy(){
        //目标对象
        UserDao target = new UserDao();

        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);

        proxy.save();//执行的是代理的方法
    }

    //測試動態代理
    public static void testDynamicProxy(){
        // 目标对象
        IUserDao target = new UserDao();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法   【代理对象】
        proxy.save();
    }
}

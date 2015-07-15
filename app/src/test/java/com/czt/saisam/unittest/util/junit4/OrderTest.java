package com.czt.saisam.unittest.util.junit4;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * 测试junit 4的测试方法执行顺序
 *
 * @author zhitao
 * @since 2015-07-12 23:55
 */

//默认值：使用一个确定的但是不可预测的排序
@FixMethodOrder(MethodSorters.DEFAULT)

//根据测试方法的方法名排序,按照词典排序规则(ASC,从小到大,递增)。
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

//保留测试方法的执行顺序为JVM返回的顺序。每次测试的执行顺序有可能会所不同。
//@FixMethodOrder(MethodSorters.JVM)

public class OrderTest {

    @Test
    public void a() {
        System.out.println("======a======");
    }

    @Test
    public void d() {
        System.out.println("======d======");
    }

    @Test
    public void c() {
        System.out.println("======c======");
    }

    @Test
    public void b() {
        System.out.println("======b======");
    }
}

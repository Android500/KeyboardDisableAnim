package com.czt.saisam.unittest.util.junit4;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

/**
 * 某些场合下，方法会抛出异常，但是并不是说抛出异常就表示方法出现问题，比如参数不合法异常，就表示参数传入有问题，方法是没有问题的，因此我们需要捕捉这种"正常"的异常
 * <p/>
 * 无论是expected还是expect都表示期望抛出的异常，
 * 假如某一方法，当参数为某一值时会抛出异常，
 * 第一种方法：必须为该参数单独写一个测试方法来测试异常，而无法与其他参数值一同写在一个测试方法里，所以显得累赘。
 * 第二种方法：虽然解决这个问题，但是写法不仅繁琐也不利于理解。
 * 第三种方法：不仅能动态更改期望抛出的异常，与断言语句结合的也非常好，因此推荐使用该方法来测试异常。
 *
 * @author zhitao
 * @since 2015-07-06 23:43
 */
public class ExceptionJunit4TestCase {

    /**
     * 第一种异常捕捉测试
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void empty() {
        new ArrayList<Object>().get(0);
    }

    /**
     * 第二种异常捕捉测试
     */
    @Test
    public void testExceptionMessage() {
        try {
            new ArrayList<Object>().get(0);
            Assert.fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
            //            Assert.assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
        }
    }

    // 第三种异常捕捉测试
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldTestExceptionMessage() throws IndexOutOfBoundsException {
        List<Object> list = new ArrayList<Object>();

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");
        list.get(0);
        Assert.assertEquals(1, list.get(0));
    }
}

package com.czt.saisam.unittest.util.junit4;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

/**
 * ĳЩ�����£��������׳��쳣�����ǲ�����˵�׳��쳣�ͱ�ʾ�����������⣬����������Ϸ��쳣���ͱ�ʾ�������������⣬������û������ģ����������Ҫ��׽����"����"���쳣
 * <p/>
 * ������expected����expect����ʾ�����׳����쳣��
 * ����ĳһ������������Ϊĳһֵʱ���׳��쳣��
 * ��һ�ַ���������Ϊ�ò�������дһ�����Է����������쳣�����޷�����������ֵһͬд��һ�����Է���������Ե���׸��
 * �ڶ��ַ�������Ȼ���������⣬����д����������Ҳ��������⡣
 * �����ַ����������ܶ�̬���������׳����쳣�����������ϵ�Ҳ�ǳ��ã�����Ƽ�ʹ�ø÷����������쳣��
 *
 * @author zhitao
 * @since 2015-07-06 23:43
 */
public class ExceptionJunit4TestCase {

    /**
     * ��һ���쳣��׽����
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void empty() {
        new ArrayList<Object>().get(0);
    }

    /**
     * �ڶ����쳣��׽����
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

    // �������쳣��׽����
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

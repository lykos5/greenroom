package com.lykos.pattern;

import com.lykos.pattern.factory.BeanFactory;
import com.lykos.httpclient.IHttpUrl;
import com.lykos.common.po.People;
import org.junit.Test;

/**
 * Created by Lykos on 16/1/13.
 */
public class BeanFactoryTest {

    @Test
    public void getBean(){
        BeanFactory.getHttpBean(IHttpUrl.class).get();
        People people = BeanFactory.getInstance(People.class);
    }

}
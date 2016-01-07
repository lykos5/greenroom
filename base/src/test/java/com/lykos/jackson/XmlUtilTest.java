package com.lykos.jackson;

import com.lykos.po.BankCard;
import com.lykos.po.Family;
import com.lykos.po.People;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Lykos on 16/1/7.
 */
public class XmlUtilTest {

    @Test
    public void testSerialize(){
        People people = new People();
        people.setName("lykos");
        people.setAge(25);
        Family family = new Family();
        family.setAddress("湖北");
        people.setFamily(family);
        BankCard bc1 = new BankCard();
        bc1.setCardNo("1");
        BankCard bc2 = new BankCard();
        bc2.setCardNo("2");
        List<BankCard> bankCards = Arrays.asList(bc1,bc2);
        people.setBankCards(bankCards);
        String peopleStr = XmlUtil.serialize(people);
        System.out.println(peopleStr);
        People people1 = (People)XmlUtil.deserialize(peopleStr,People.class);
        System.out.println(people1);
        Map map = XmlUtil.deserialize(peopleStr);
        System.out.println(map);
    }


    @Test
    public void testDeserialize(){
        String peopleStr = "<people><name>lykos</name><age>25</age><family><address>湖北</address></family><bankCards><bankCard><cardNo>1</cardNo></bankCard><bankCard><cardNo>2</cardNo></bankCard></bankCards></people>";
        Map map = XmlUtil.deserialize2(peopleStr);
        System.out.println(map);
    }

}
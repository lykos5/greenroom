package com.lykos.jdk8;

import java.util.List;

/**
 * 过滤器接口
 * Created by Lykos on 16/1/18.
 */
public interface IFilter<E> {
    public List<E> filter(List<E> collects);
}

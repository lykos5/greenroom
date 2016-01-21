package com.lykos.httpclient.parse;

import com.lykos.jackson.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Lykos on 16/1/21.
 */
public class ApplicationJsonParse implements IResponseParse {
    @Override
    public Object parse(HttpEntity entity,String charset)throws IOException {
        return JsonUtil.deserialize(EntityUtils.toString(entity,charset),Map.class);
    }
}

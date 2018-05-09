package com.mll.data.testing.util;

import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJSONConfig {

    public static SerializerFeature FEATURES[];

    static {
        FEATURES = (new SerializerFeature[] { SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat });
    }

}
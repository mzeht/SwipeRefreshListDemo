package com.example.mzeht.swiperefreshlistdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wpmac on 16/2/1.
 */
public class DataSource {

    public static final List<String> generateData(int size)
    {
        if (size <= 0)
            return null;
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            datas.add("这是列表数据"+i);
        }
        return datas;
    }
}

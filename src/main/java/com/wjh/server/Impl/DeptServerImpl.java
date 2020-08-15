package com.wjh.server.Impl;

import com.wjh.dao.DeptDao;
import com.wjh.model.Dept;
import com.wjh.server.DeptServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeptServerImpl implements DeptServer {
    DeptDao deptDao=new DeptDao();
    @Override
    public  HashMap<String, ArrayList<Map<String, Object>>> findAll() {
        HashMap<String, ArrayList<Map<String, Object>>> listHashMap = new HashMap<>();
        List<Map<String, Object>> maps = deptDao.findAll();
        for (Map<String, Object> map : maps) {
            Object uId="uId";
            Object deptName="deptName";
            Object o1=map.get(uId);
            String string=map.get(deptName).toString();
            if (null==listHashMap.get(string)){
                ArrayList<Map<String,Object>> list = new ArrayList<>();
                if (null!=o1){
                    list.add(map);
                }   listHashMap.put(string,list);
            }else {
                listHashMap.get(string).add(map);
            }
        }
        return listHashMap;
    }
}

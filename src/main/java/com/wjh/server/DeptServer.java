package com.wjh.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DeptServer {
    HashMap<String, ArrayList<Map<String, Object>>> findAll();
}

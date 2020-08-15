package com.wjh.server;

import java.util.List;
import java.util.Map;

public interface MeetingServer {
    List<Map<String, Object>> findAllMeet(String title, Integer status, Integer currPage);
}

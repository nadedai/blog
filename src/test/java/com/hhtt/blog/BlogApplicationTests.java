package com.hhtt.blog;
import com.hhtt.blog.pojo.Type;
import com.hhtt.blog.service.IPService;
import com.hhtt.blog.service.TypeService;
import com.hhtt.blog.service.UserService;
import com.hhtt.blog.util.MyUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.DigestUtils;

import java.io.File;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    IPService ipService;

}

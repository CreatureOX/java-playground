package com.creatureox.feign;

import com.creatureox.feign.dto.request.CommonRequestDTO;
import com.creatureox.feign.service.ApiService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FeignApplication.class)
public class FeignApplicationTests {

    @Resource
    private ApiService apiService;

    @Test
    public void getTest() {
        String url = "https://www.baidu.com/";
        log.info("{}", apiService.doGet(url));
    }

    @Data
    private class PostReqDTO{
        private String content;
        private Integer type = 0;
        private String logo_img;
    }

    @Test
    public void postTest() {
        CommonRequestDTO requestDTO = new CommonRequestDTO();
        requestDTO.setUrl("https://www.mxnzp.com/api/qrcode/create/logo");
        PostReqDTO reqDTO = new PostReqDTO();
        reqDTO.setContent("test");
        reqDTO.setLogo_img("https://pic2.zhimg.com/v2-0b8858be5dc9785681a527d9dda16964_250x0.jpg");
        requestDTO.setRequestBody(reqDTO);
        log.info("{}", apiService.doPost(requestDTO));
    }

}

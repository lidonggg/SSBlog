package com.lidong.blog.repository.es;
import static org.assertj.core.api.Assertions.assertThat;
import com.lidong.blog.domain.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;
import org.springframework.data.domain.Pageable;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {
    @Autowired
    private EsBlogRepository esBlogRepository;
    @Before
    public void initRepositoryData(){
        //清除所有数据
        esBlogRepository.deleteAll();
        esBlogRepository.save(new EsBlog("111","222111","daf111wwwfff222"));
        esBlogRepository.save(new EsBlog("222","222333","daf111www111222fff222"));
        esBlogRepository.save(new EsBlog("333","333111","daf111www333222111fff222"));

    }

    @Test
    public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(){
        Pageable pageable = new PageRequest(0,20);
        String title = "111";
        String summary = "111";
        String content = "111";
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,  pageable);
        assertThat(page.getTotalElements()).isEqualTo(1);
        System.out.println("------------------------------ ");
        for(EsBlog esBlog : page.getContent()){
            System.out.println(esBlog.toString());
        }
        System.out.println("------------------------------ ");
    }
}
package com.example.bulletin.board.service;

import com.example.bulletin.board.dao.PostDao;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;

@SpringBootTest
class BulletinBoardServiceTest {

    @Autowired
    private BulletinBoardService service;

    @MockBean
    private PostDao postDao;

    @Test
    void 検索値によって正しい投稿件数を取得できること() {
        // Arrange
        Mockito.when(postDao.countByExample(any()))
                .thenReturn(3);

        // Act
        int result = service.countByExample("検索ワード");

        // Assert
        assertEquals(3, result);
        Mockito.verify(postDao, Mockito.times(1))
                .countByExample("検索ワード");
    }
}
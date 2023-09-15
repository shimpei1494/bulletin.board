package com.example.bulletin.board.logic;

import com.example.bulletin.board.component.PagerComponent;
import com.example.bulletin.board.model.form.BoardIndexForm;
import com.example.bulletin.board.model.view.BoardView;
import com.example.bulletin.board.service.AccountService;
import com.example.bulletin.board.service.BulletinBoardService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.BiConsumer;

@Component
public class GetPostListLogic {
    private BulletinBoardService bulletinBoardService;


    public GetPostListLogic(BulletinBoardService bulletinBoardService) {
        this.bulletinBoardService = bulletinBoardService;
    }

    // viewを返す
    public BoardView execute(BoardIndexForm form) {
        BoardView view = new BoardView();
        PagerComponent pager = new PagerComponent();

        String searchWord = form.getSearchWord();

        int count = bulletinBoardService.countByExample(searchWord);

        String queryString = createQueryString(form);
        view.setPager(pager.createPager(form.getUrl(), form.getPage(), count, queryString));

        // 0件の場合処理を終了する
        if (count == 0) {
            // 何かLIstセットする？
            return view;
        }

        Map<String, Integer> limitOffset = pager.calcLimitOffset(form.getPage(), count);
        var list = bulletinBoardService.getPostList(searchWord, limitOffset.get("limit"), limitOffset.get("offset"));

        view.setList(list);

        return view;
    }

    private String createQueryString(BoardIndexForm form) {
        var query = new StringBuffer();
        BiConsumer<String, String> addQuery = (key, value) -> {
            if (StringUtils.isNotEmpty(value)) {
                query.append(key).append("=").append(value).append("&");
            }
        };

        addQuery.accept("searchWord", form.getSearchWord());
        // 複数クエリパラメータある場合は以下のような感じで追加できる
//        if (form.getPublishState() != null) {
//            addQuery.accept("publishState", form.getPublishState());
//        }

        return query.toString();
    }

}

package com.example.bulletin.board.component;

import com.example.bulletin.board.exception.PagerInvalidException;
import com.example.bulletin.board.model.dto.PagerDto;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PagerComponent {
    // 1ページあたり表示するコンテンツ数
    public static final int NUMBERS_PER_PAGE = 3;
    // 一度に表示するページリンク数
    public static final int PAGE_SIZE = 5;

    private final int numberPerPage;
    private final int pageSize;

    public PagerComponent() {
        this.numberPerPage = NUMBERS_PER_PAGE;
        this.pageSize = PAGE_SIZE;
    }

    public PagerComponent(int numberPerPage, int pageSize) {
        this.numberPerPage = numberPerPage;
        this.pageSize = pageSize;
    }

    public PagerDto createPager(String url, Integer pageNo, Integer totalCount, String query) {
        String pageParam = StringUtils.isNotEmpty(query) ? ("?" + query + "page=") : "?page=";
        return createDto(url, pageNo, totalCount, pageParam);
    }

    // pageNoに応じてSQLに発行するlimit, offset値の計算を行う
    public Map<String, Integer> calcLimitOffset(Integer pageNo, Integer count) {
        Integer offset = (pageNo-1) * numberPerPage;

        // 表示するページが最大ページ数を超えていたらエラー
        int maxPageNo = (int) (count/numberPerPage);
        maxPageNo += count % numberPerPage > 0 ? 1 : 0;
        if (maxPageNo < pageNo) {
            throw new PagerInvalidException("invalid pageNo is " + pageNo + " max pageNo is " + maxPageNo);
        }

        // 最終ページだとlimit値がレコード件数を超える可能性があるため、レコード件数を超えた場合limit値を最終レコード行数に合わせる
        Integer limit = (int) ((offset + numberPerPage) <= count ? numberPerPage : (count - offset));

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("limit", limit);
        resultMap.put("offset", offset);

        return resultMap;
    }

    // 表示するページリンクの配列を生成する
    private List<Integer> createShowPageList(Integer pageNo, Integer totalPageNumbers) {

        int pageSizeHalf = (int)(pageSize / 2);

        int start = Math.max(1, pageNo - pageSizeHalf);
        int end = Math.min(totalPageNumbers, pageNo + pageSizeHalf);

        // pageSize以下の場合は足りないページ数を補充
        int diff = end - start;
        if (diff != pageSize) {

            // ページ先頭の場合はendをページサイズか最後尾に変更
            if (pageNo <= pageSizeHalf) {
                end = Math.min(pageSize, totalPageNumbers);
                // ページ末尾の場合はstartを1ページ目か(最後尾-ページサイズ+1)に変更
            } else if (pageNo >= (totalPageNumbers - pageSizeHalf)) {
                start = Math.max(1, (totalPageNumbers - pageSize + 1));
            }
        }

        return IntStream.rangeClosed(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

    private PagerDto createDto(String url, Integer pageNo, Integer totalCount, String pageParam) {
        PagerDto dto = new PagerDto();

        dto.setBaseUrl(url + pageParam);
        dto.setTotalCount(totalCount);
        dto.setCurrentPageNumber(pageNo);

        // 端数が存在する場合は1ページ余分に表示する必要あり
        int totalPageNum = ((dto.getTotalCount() - 1)/ numberPerPage) + 1;

        // 表示するページが最大ページ数を超えていたらエラー
        if (pageNo > totalPageNum) {
            throw new PagerInvalidException("invalid pageNo is " + pageNo);
        }

        // page番号が先頭じゃない場合は[前へ], [最初へ]のリンクを生成する
        if (pageNo > 1) {
            dto.setPrev(true);
            dto.setFirstPageUrl(url + pageParam + "1");
            dto.setPrevPageUrl(url + pageParam + (pageNo-1));
        } else {
            dto.setPrev(false);
        }

        // page番号が最後じゃない場合は[後へ], [最後へ]のリンクを生成する
        if (pageNo < totalPageNum) {
            dto.setNext(true);
            dto.setNextPageUrl(url + pageParam + (pageNo+1));
            dto.setLastPageUrl(url + pageParam + totalPageNum);
        } else {
            dto.setNext(false);
        }

        dto.setShowPageList(createShowPageList(pageNo, totalPageNum));

        return dto;
    }
}
package com.example.bulletin.board.model.form;

import com.example.bulletin.board.exception.IllegalQueryParamException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BasePageForm {

    @NotNull
    private Integer page = 1;

    private String url;

    // クエリパラムのチェックと変換を行う
    // pageに文字列や無効な数字が入っていた場合変換する
    public void setPage(String page) {
        // クエリパラムがnullもしくは文字列が含まれている場合1に変換する
        if (page == null || !page.matches("^-?\\d+$")) {
            this.page = 1;
        } else {
            Integer pageInt = Integer.parseInt(page);
            // クエリパラムが1未満の場合は1にする
            this.page = pageInt < 1 ? 1 : pageInt;
        }
    }

    public void setUrl(HttpServletRequest req) {
        this.url = req.getServletPath();
    }

    /**
     * ブラウザからクエリ入力された場合はExceptionを投げる.
     * urlはHttpServletRequestから取得するためユーザからの入力はさせない.
     * @param url URL
     */
    public void setUrl(String url) {
        throw new IllegalQueryParamException("cannot set query params 'url'");
    }


}

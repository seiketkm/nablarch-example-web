package com.nablarch.example.app.web.action;

import nablarch.core.log.Logger;
import nablarch.core.log.LoggerManager;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;
import nablarch.fw.web.servlet.ServletExecutionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * セッション生成防止機能の検証画面用 Action クラス。
 *
 * @author Nabu Rakutaro
 */
public class PreventSessionCreationAction {
    /**ロガー*/
    private static final Logger LOGGER = LoggerManager.get(PreventSessionCreationAction.class);

    /**
     * 画面表示。
     * @param request HTTPリクエスト
     * @param context 実行コンテキスト
     * @return HTTPレスポンス
     */
    public HttpResponse index(HttpRequest request, ExecutionContext context) {
        return new HttpResponse("/WEB-INF/view/preventSessionCreation/index.jsp");
    }

    /**
     * 検証の実行。
     * @param request HTTPリクエスト
     * @param context 実行コンテキスト
     * @return HTTPレスポンス
     */
    public HttpResponse execute(HttpRequest request, ExecutionContext context) {
        HttpServletRequest req = (HttpServletRequest) ((ServletExecutionContext) context).getServletRequest().getRequest();

        try {
            LOGGER.logInfo("===== getSession(false) =====");
            HttpSession session = req.getSession(false);
            LOGGER.logInfo("エラーなし session=" + session);
        } catch (Exception e) {
            LOGGER.logInfo("例外がスローされた e=" + e.getClass() + ", message=" + e.getMessage());
        }

        try {
            LOGGER.logInfo("===== getSession(true) =====");
            HttpSession session = req.getSession(true);
            LOGGER.logInfo("エラーなし session=" + session);
        } catch (Exception e) {
            LOGGER.logInfo("例外がスローされた e=" + e.getClass() + ", message=" + e.getMessage());
        }

        try {
            LOGGER.logInfo("===== getSession() =====");
            HttpSession session = req.getSession();
            LOGGER.logInfo("エラーなし session=" + session);
        } catch (Exception e) {
            LOGGER.logInfo("例外がスローされた e=" + e.getClass() + ", message=" + e.getMessage());
        }

        return new HttpResponse("/WEB-INF/view/preventSessionCreation/index.jsp");
    }
}

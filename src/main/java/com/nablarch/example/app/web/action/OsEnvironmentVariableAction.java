package com.nablarch.example.app.web.action;

import nablarch.core.log.Logger;
import nablarch.core.log.LoggerManager;
import nablarch.core.repository.SystemRepository;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;

/**
 * OS環境変数による上書きを検証するためのActionクラス。
 *
 * @author Nabu Rakutaro
 */
public class OsEnvironmentVariableAction {
    /**ロガー*/
    private static final Logger LOGGER = LoggerManager.get(OsEnvironmentVariableAction.class);

    /**
     * 画面表示。
     * @param request HTTPリクエスト
     * @param context 実行コンテキスト
     * @return HTTPレスポンス
     */
    public HttpResponse index(HttpRequest request, ExecutionContext context) {
        return new HttpResponse("/WEB-INF/view/osEnvironmentVariable/index.jsp");
    }

    /**
     * 検証の実行。
     * @param request HTTPリクエスト
     * @param context 実行コンテキスト
     * @return HTTPレスポンス
     */
    public HttpResponse execute(HttpRequest request, ExecutionContext context) {
        LOGGER.logInfo("===============================================");
        logSystemRepositoryValue("env-value.first");
        logSystemRepositoryValue("env-value.second");
        logSystemRepositoryValue("env-value.third");
        logSystemRepositoryValue("env-value.fourth");
        logSystemRepositoryValue("env-value.fifth");
        logSystemRepositoryValue("env-value.sixth");
        logSystemRepositoryValue("env-value.seventh");
        logSystemRepositoryValue("env-value.eighth");
        LOGGER.logInfo("===============================================");

        return new HttpResponse("/WEB-INF/view/osEnvironmentVariable/index.jsp");
    }

    /**
     * 指定したキーで{@link SystemRepository}を検索し、結果をINFOレベルのログで出力する。
     * @param key 検索キー
     */
    private void logSystemRepositoryValue(String key) {
        LOGGER.logInfo("key=[" + key + "] value=[" + SystemRepository.get(key) + ']');
    }
}

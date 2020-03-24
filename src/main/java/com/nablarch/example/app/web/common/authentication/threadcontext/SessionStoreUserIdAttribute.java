package com.nablarch.example.app.web.common.authentication.threadcontext;

import com.nablarch.example.app.web.common.authentication.context.LoginUserPrincipal;
import nablarch.common.handler.threadcontext.UserIdAttribute;
import nablarch.common.web.session.SessionUtil;
import nablarch.fw.ExecutionContext;

public class SessionStoreUserIdAttribute extends UserIdAttribute {
    protected Object getUserIdSession(ExecutionContext ctx, String skey) {
        LoginUserPrincipal userContext = (LoginUserPrincipal)SessionUtil.orNull(ctx, "userContext");
        if (userContext == null)
            return null;
        return String.valueOf(userContext.getUserId());
    }
}

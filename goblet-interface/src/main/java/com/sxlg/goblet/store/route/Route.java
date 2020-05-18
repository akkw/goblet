package com.sxlg.goblet.store.route;

public interface Route {

        void beforeRoute();

        void afterRoute();
        void route();
}

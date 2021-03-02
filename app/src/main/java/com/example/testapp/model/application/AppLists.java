package com.example.testapp.model.application;

public class AppLists {
    private String appId, app_name, app_icon, app_package_name, status;

    public AppLists(String appId, String app_name, String app_icon, String app_package_name, String status) {
        this.appId = appId;
        this.app_name = app_name;
        this.app_icon = app_icon;
        this.app_package_name = app_package_name;
        this.status = status;
    }

    public String getAppId() {
        return appId;
    }

    public String getApp_name() {
        return app_name;
    }

    public String getApp_icon() {
        return app_icon;
    }

    public String getApp_package_name() {
        return app_package_name;
    }

    public String getStatus() {
        return status;
    }
}

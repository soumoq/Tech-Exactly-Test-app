
package com.example.testapp.model.application;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "app_id",
    "fk_kid_id",
    "app_name",
    "app_icon",
    "app_package_name",
    "status"
})
public class AppList {

    @JsonProperty("app_id")
    private Integer appId;
    @JsonProperty("fk_kid_id")
    private Integer fkKidId;
    @JsonProperty("app_name")
    private String appName;
    @JsonProperty("app_icon")
    private String appIcon;
    @JsonProperty("app_package_name")
    private String appPackageName;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("app_id")
    public Integer getAppId() {
        return appId;
    }

    @JsonProperty("app_id")
    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    @JsonProperty("fk_kid_id")
    public Integer getFkKidId() {
        return fkKidId;
    }

    @JsonProperty("fk_kid_id")
    public void setFkKidId(Integer fkKidId) {
        this.fkKidId = fkKidId;
    }

    @JsonProperty("app_name")
    public String getAppName() {
        return appName;
    }

    @JsonProperty("app_name")
    public void setAppName(String appName) {
        this.appName = appName;
    }

    @JsonProperty("app_icon")
    public String getAppIcon() {
        return appIcon;
    }

    @JsonProperty("app_icon")
    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }

    @JsonProperty("app_package_name")
    public String getAppPackageName() {
        return appPackageName;
    }

    @JsonProperty("app_package_name")
    public void setAppPackageName(String appPackageName) {
        this.appPackageName = appPackageName;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

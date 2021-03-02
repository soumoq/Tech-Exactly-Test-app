
package com.example.testapp.model.application;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "app_list",
    "usage_access"
})
public class Data {

    @JsonProperty("app_list")
    private List<AppList> appList = null;
    @JsonProperty("usage_access")
    private Integer usageAccess;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("app_list")
    public List<AppList> getAppList() {
        return appList;
    }

    @JsonProperty("app_list")
    public void setAppList(List<AppList> appList) {
        this.appList = appList;
    }

    @JsonProperty("usage_access")
    public Integer getUsageAccess() {
        return usageAccess;
    }

    @JsonProperty("usage_access")
    public void setUsageAccess(Integer usageAccess) {
        this.usageAccess = usageAccess;
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

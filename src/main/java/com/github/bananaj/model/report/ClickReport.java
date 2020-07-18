package com.github.bananaj.model.report;

import com.github.bananaj.utils.DateConverter;
import org.json.JSONObject;

import java.time.ZonedDateTime;

public class ClickReport {

    private String id;
    private String url;
    private Integer totalClicks;
    private Double clickPercentage;
    private Integer uniqueClicks;
    private Double uniqueClickPercentage;
    private ZonedDateTime lastClick;
    private ClickABSplit abSplit_a;
    private ClickABSplit abSplit_b;

    public ClickReport(JSONObject jsonObj) {

        id = jsonObj.getString("id");
        url = jsonObj.getString("url");
        totalClicks = jsonObj.getInt("total_clicks");
        clickPercentage = jsonObj.getDouble("click_percentage");
        uniqueClicks = jsonObj.getInt("unique_clicks");
        uniqueClickPercentage = jsonObj.getDouble("unique_click_percentage");
        lastClick = DateConverter.fromISO8601(jsonObj.getString("last_click"));

        if (jsonObj.has("ab_split")) {
            JSONObject split = jsonObj.getJSONObject("ab_split");
            abSplit_a = new ClickABSplit("a", split.getJSONObject("a"));
            abSplit_b = new ClickABSplit("b", split.getJSONObject("b"));
        }
    }

    /**
     * @return The unique id for the link.
     */
    public String getId() {

        return id;
    }

    /**
     * @return The URL for the link in the campaign.
     */
    public String getUrl() {

        return url;
    }

    /**
     * @return The number of total clicks for a link.
     */
    public Integer getTotalClicks() {

        return totalClicks;
    }

    /**
     * @return The percentage of total clicks a link generated for a campaign.
     */
    public Double getClickPercentage() {

        return clickPercentage;
    }

    /**
     * @return Number of unique clicks for a link.
     */
    public Integer getUniqueClicks() {

        return uniqueClicks;
    }

    /**
     * @return The percentage of unique clicks a link generated for a campaign.
     */
    public Double getUniqueClickPercentage() {

        return uniqueClickPercentage;
    }

    /**
     * @return The date and time for the last recorded click for a link.
     */
    public ZonedDateTime getLastClick() {

        return lastClick;
    }

    /**
     * @return Stats for Group A.
     */
    public ClickABSplit getAbSplit_a() {

        return abSplit_a;
    }

    /**
     * @return Stats for Group B.
     */
    public ClickABSplit getAbSplit_b() {

        return abSplit_b;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return
                "Click Report: " + getId() + " " + getUrl() + System.lineSeparator() +
                        "    Total Clicks: " + getTotalClicks() + System.lineSeparator() +
                        "    Click Percentage: " + getClickPercentage() + System.lineSeparator() +
                        "    Unique Clicks: " + getUniqueClicks() + System.lineSeparator() +
                        "    Unique Click Percentage: " + getUniqueClickPercentage() +
                        (getAbSplit_a() != null ? System.lineSeparator() + getAbSplit_a().toString() : "") +
                        (getAbSplit_b() != null ? System.lineSeparator() + getAbSplit_b().toString() : "");
    }
}

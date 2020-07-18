package com.github.bananaj.model;

import com.github.bananaj.model.report.Ecommerce;
import org.json.JSONObject;

public class ReportSummary {

    private int opens;
    private int uniqueOpens;
    private double openRate;
    private int clicks;
    private int subscriberClicks;
    private double clickRate;
    private Ecommerce ecommerce;

    public ReportSummary(JSONObject jsonObj) {

        opens = jsonObj.getInt("opens");
        uniqueOpens = jsonObj.getInt("unique_opens");
        openRate = jsonObj.getDouble("open_rate");
        clicks = jsonObj.getInt("clicks");
        subscriberClicks = jsonObj.getInt("subscriber_clicks");
        clickRate = jsonObj.getDouble("click_rate");

        if (jsonObj.has("ecommerce")) {
            ecommerce = new Ecommerce(jsonObj.getJSONObject("ecommerce"));
        }
    }

    public ReportSummary() {

    }

    /**
     * The total number of opens for a campaign
     */
    public int getOpens() {

        return opens;
    }

    /**
     * The number of unique opens
     */
    public int getUniqueOpens() {

        return uniqueOpens;
    }

    /**
     * The number of unique opens divided by the total number of successful deliveries
     */
    public double getOpenRate() {

        return openRate;
    }

    /**
     * The total number of clicks for a campaign
     */
    public int getClicks() {

        return clicks;
    }

    /**
     * The number of unique clicks
     */
    public int getSubscriberClicks() {

        return subscriberClicks;
    }

    /**
     * The number of unique clicks divided by the total number of successful deliveries
     */
    public double getClickRate() {

        return clickRate;
    }

    /**
     * E-Commerce stats for a campaign
     *
     * @return null or E-Commerce stats
     */
    public Ecommerce getEcommerce() {

        return ecommerce;
    }

    @Override
    public String toString() {

        return
                "ReportSummary:" + System.lineSeparator() +
                        "    Opens: " + opens + System.lineSeparator() +
                        "    Unique Opens: " + uniqueOpens + System.lineSeparator() +
                        "    Open Rate: " + openRate + System.lineSeparator() +
                        "    Clicks: " + clicks + System.lineSeparator() +
                        "    Subscriber Clicks: " + subscriberClicks + System.lineSeparator() +
                        "    click Rate: " + clickRate +
                        (ecommerce != null ? System.lineSeparator() + ecommerce.toString() : "");
    }
}

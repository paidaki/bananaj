package com.github.bananaj.model.searchmembers;

import com.github.bananaj.connection.MailChimpConnection;
import org.json.JSONObject;

public class SearchMembers {

    private ExactMatches exactMatches;
    private FullSearch fullSearch;

    public SearchMembers(MailChimpConnection connection, JSONObject jsonObject) {

        this.exactMatches = new ExactMatches(connection, jsonObject);
        this.fullSearch = new FullSearch(connection, jsonObject);
    }

    public ExactMatches getExactMatches() {

        return exactMatches;
    }

    public void setExactMatches(ExactMatches exactMatches) {

        this.exactMatches = exactMatches;
    }

    public FullSearch getFullSearch() {

        return fullSearch;
    }

    public void setFullSearch(FullSearch fullSearch) {

        this.fullSearch = fullSearch;
    }
}

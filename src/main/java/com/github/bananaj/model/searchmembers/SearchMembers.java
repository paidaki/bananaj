package com.github.bananaj.model.searchmembers;

import com.github.bananaj.connection.MailChimpConnection;
import org.json.JSONObject;

public class SearchMembers {

    private SearchMembersMatches exactMatches;
    private SearchMembersMatches fullSearch;

    public SearchMembers(MailChimpConnection connection, JSONObject jsonObject) {

        this.exactMatches = new SearchMembersMatches(connection, jsonObject.getJSONObject("exact_matches"));
        this.fullSearch = new SearchMembersMatches(connection, jsonObject.getJSONObject("full_search"));
    }

    public SearchMembersMatches getExactMatches() {

        return exactMatches;
    }

    public void setExactMatches(SearchMembersMatches exactMatches) {

        this.exactMatches = exactMatches;
    }

    public SearchMembersMatches getFullSearch() {

        return fullSearch;
    }

    public void setFullSearch(SearchMembersMatches fullSearch) {

        this.fullSearch = fullSearch;
    }
}

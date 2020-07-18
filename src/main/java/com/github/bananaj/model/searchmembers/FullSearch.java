package com.github.bananaj.model.searchmembers;

import com.github.bananaj.connection.MailChimpConnection;
import com.github.bananaj.model.list.member.Member;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Objects;

public class FullSearch {

    private List<Member> members;
    private int totalItems;

    public FullSearch(MailChimpConnection connection, JSONObject jsonObject) {

        Objects.requireNonNull(connection, "MailChimpConnection");

        this.totalItems = jsonObject.getInt("total_items");
        if (jsonObject.has("members")) {
            JSONArray list = jsonObject.getJSONArray("members");
            for (int i = 0; i < list.length(); i++) {
                JSONObject memberJson = list.getJSONObject(i);
                members.add(new Member(connection, memberJson));
            }
        }
    }

    public List<Member> getMembers() {

        return members;
    }

    public void setMembers(List<Member> members) {

        this.members = members;
    }

    public int getTotalItems() {

        return totalItems;
    }

    public void setTotalItems(int totalItems) {

        this.totalItems = totalItems;
    }
}

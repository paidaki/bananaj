package com.github.alexanderwe.bananaj.model.campaign;

import static org.junit.Assert.*;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.github.alexanderwe.bananaj.model.list.segment.ConditionType;
import com.github.alexanderwe.bananaj.model.list.segment.MatchType;

public class CampaignTest {

	@Test
	public void testCampaign() throws Exception {
		JSONObject jsonObj = new JSONObject("{\"id\":\"012abcde01\",\"web_id\":1767757,\"type\":\"regular\",\"create_time\":\"2019-03-15T14:34:59+00:00\",\"archive_url\":\"http://eepurl.com/gkRad1\",\"long_archive_url\":\"https://us3.campaign-archive.com/?u=003f3ec44928e2d1d3d506a22&id=025b945e22\",\"status\":\"sent\",\"emails_sent\":9,\"send_time\":\"2019-03-15T14:35:05+00:00\",\"content_type\":\"html\",\"needs_block_refresh\":false,\"has_logo_merge_tag\":false,\"resendable\":true,\"recipients\":{\"list_id\":\"0a05001000\",\"list_is_active\":true,\"list_name\":\"TEST_LIST\",\"segment_text\":\"\",\"recipient_count\":9},\"settings\":{\"subject_line\":\"Implementation Insights for TEST on March 14, 2019\",\"title\":\"TEST #15 2018\",\"from_name\":\"Sue Tester, Ph.D.\",\"reply_to\":\"Sue.Tester@nospam.com\",\"use_conversation\":false,\"to_name\":\"*|FNAME|* *|LNAME|*\",\"folder_id\":\"aa1a88812a\",\"authenticate\":true,\"auto_footer\":false,\"inline_css\":false,\"auto_tweet\":false,\"fb_comments\":true,\"timewarp\":false,\"template_id\":0,\"drag_and_drop\":false},\"tracking\":{\"opens\":true,\"html_clicks\":true,\"text_clicks\":false,\"goal_tracking\":false,\"ecomm360\":false,\"google_analytics\":\"\",\"clicktale\":\"N\"},\"report_summary\":{\"opens\":23,\"unique_opens\":3,\"open_rate\":0.375,\"clicks\":0,\"subscriber_clicks\":0,\"click_rate\":0,\"ecommerce\":{\"total_orders\":0,\"total_spent\":0,\"total_revenue\":0}},\"delivery_status\":{\"enabled\":false},\"_links\":[{\"rel\":\"parent\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns\",\"method\":\"GET\",\"targetSchema\":\"https://us3.api.mailchimp.com/schema/3.0/Definitions/Campaigns/CollectionResponse.json\",\"schema\":\"https://us3.api.mailchimp.com/schema/3.0/CollectionLinks/Campaigns.json\"},{\"rel\":\"self\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/025b945a01\",\"method\":\"GET\",\"targetSchema\":\"https://us3.api.mailchimp.com/schema/3.0/Definitions/Campaigns/Response.json\"},{\"rel\":\"delete\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/025b945a01\",\"method\":\"DELETE\"},{\"rel\":\"send\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/025b945a01/actions/send\",\"method\":\"POST\"},{\"rel\":\"cancel_send\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/025b945a01/actions/cancel-send\",\"method\":\"POST\"},{\"rel\":\"feedback\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/025b945a01/feedback\",\"method\":\"GET\",\"targetSchema\":\"https://us3.api.mailchimp.com/schema/3.0/Definitions/Campaigns/Feedback/CollectionResponse.json\"},{\"rel\":\"content\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/025b945a01/content\",\"method\":\"GET\",\"targetSchema\":\"https://us3.api.mailchimp.com/schema/3.0/Definitions/Campaigns/Content/Response.json\"},{\"rel\":\"send_checklist\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/025b945a01/send-checklist\",\"method\":\"GET\",\"targetSchema\":\"https://us3.api.mailchimp.com/schema/3.0/Definitions/Campaigns/Checklist/Response.json\"},{\"rel\":\"pause\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/025b945a01/actions/pause\",\"method\":\"POST\"},{\"rel\":\"resume\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/025b945a01/actions/resume\",\"method\":\"POST\"},{\"rel\":\"replicate\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/025b945a01/actions/replicate\",\"method\":\"POST\"},{\"rel\":\"create_resend\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/025b945a01/actions/create-resend\",\"method\":\"POST\"}]}");
		Campaign campaign = new Campaign(null, jsonObj);
		assertEquals(campaign.getId(), "012abcde01");
		assertEquals(campaign.getType(), CampaignType.REGULAR);
		assertEquals(campaign.getStatus(), CampaignStatus.SENT);
		assertEquals(campaign.getRecipients().getListId(), "0a05001000");
		assertEquals(campaign.getRecipients().getListName(), "TEST_LIST");
		assertEquals(campaign.getReportSummary().getOpens(), 23);
		assertEquals(campaign.getTracking().isHtmlClicks(), Boolean.TRUE);
		assertEquals(campaign.getReportSummary().getOpens(), 23);

		// TODO: JSONObject json = campaign.getJsonRepresentation();
	}

	@Test
	public void testCampaign_w_segmentOps() throws Exception {
		JSONObject jsonObj = new JSONObject("{\"id\":\"0606061661\",\"web_id\":2146833,\"type\":\"regular\",\"create_time\":\"2019-08-22T02:30:10+00:00\",\"archive_url\":\"http://eepurl.com/12345\",\"long_archive_url\":\"https://us6.campaign-archive.com/?u=e03f3f53ccb8ead1d3dd0002d&id=0606061661\",\"status\":\"sent\",\"emails_sent\":8,\"send_time\":\"2019-08-22T02:30:14+00:00\",\"content_type\":\"html\",\"needs_block_refresh\":false,\"has_logo_merge_tag\":false,\"resendable\":true,\"recipients\":{\"list_id\":\"0a05001000\",\"list_is_active\":true,\"list_name\":\"TEST_LIST\",\"segment_text\":\"<p class=\\\"!margin--lv0 display--inline\\\">Contacts that match <strong>any</strong> of the following conditions:</p><ol id=\\\"conditions\\\" class=\\\"small-meta text-transform--none\\\"><li class=\\\"margin--lv1 !margin-left-right--lv0\\\">Tags contact is tagged <strong>BTS_FAY</strong></li></ol><span>For a total of <strong>8</strong> emails sent.</span>\",\"recipient_count\":8,\"segment_opts\":{\"saved_segment_id\":67277,\"match\":\"any\",\"conditions\":[{\"condition_type\":\"StaticSegment\",\"field\":\"static_segment\",\"op\":\"static_is\",\"value\":67277}]}},\"settings\":{\"subject_line\":\"Insights for Fayette\",\"title\":\"BTS FAY #1 2019\",\"from_name\":\"Mr Tester\",\"reply_to\":\"test.account@gmail.com\",\"use_conversation\":false,\"to_name\":\"*|FNAME|* *|LNAME|*\",\"folder_id\":\"f42a42307b\",\"authenticate\":true,\"auto_footer\":false,\"inline_css\":false,\"auto_tweet\":false,\"fb_comments\":true,\"timewarp\":false,\"template_id\":0,\"drag_and_drop\":false},\"tracking\":{\"opens\":true,\"html_clicks\":true,\"text_clicks\":false,\"goal_tracking\":false,\"ecomm360\":false,\"google_analytics\":\"\",\"clicktale\":\"N\"},\"report_summary\":{\"opens\":8,\"unique_opens\":3,\"open_rate\":0.375,\"clicks\":0,\"subscriber_clicks\":0,\"click_rate\":0,\"ecommerce\":{\"total_orders\":0,\"total_spent\":0,\"total_revenue\":0}},\"delivery_status\":{\"enabled\":false},\"_links\":[]} ");
		Campaign campaign = new Campaign(null, jsonObj);
		assertEquals(campaign.getId(), "0606061661");
		assertEquals(campaign.getType(), CampaignType.REGULAR);
		assertEquals(campaign.getStatus(), CampaignStatus.SENT);
		assertEquals(campaign.getRecipients().getListId(), "0a05001000");
		assertEquals(campaign.getRecipients().getListName(), "TEST_LIST");
		assertEquals(campaign.getRecipients().getSegmentOpts().getSavedSegmentId(), new Integer(67277));
		assertEquals(campaign.getRecipients().getSegmentOpts().getMatch(), MatchType.ANY);
		assertEquals(campaign.getRecipients().getSegmentOpts().getConditions().size(), 1);
		assertEquals(campaign.getReportSummary().getOpens(), 8);
		assertEquals(campaign.getTracking().isHtmlClicks(), Boolean.TRUE);
		assertEquals(campaign.getReportSummary().getOpens(), 8);
		assertEquals(campaign.getSettings().getAuthenticate(), Boolean.TRUE);
		assertEquals(campaign.getSettings().getSubjectLine(), "Insights for Fayette");
	}
	
	@Test
	public void testCampaignSegmentOpts() {
		JSONObject jsonObj = new JSONObject("{\"saved_segment_id\":40229,\"match\":\"any\",\"conditions\":[{\"condition_type\":\"Interests\",\"field\":\"interests-6dc9e2022a\",\"op\":\"interestcontains\",\"value\":[\"66af3e0301\"]}]}");
		CampaignSegmentOpts segopts = new CampaignSegmentOpts(jsonObj);
		assertEquals(segopts.getSavedSegmentId().intValue(), 40229);
		assertEquals(segopts.getMatch(), MatchType.ANY);
		assertEquals(segopts.getConditions().size(), 1);
		assertEquals(segopts.getConditions().get(0).getConditionType(), ConditionType.INTERESTS);
		
		JSONObject json = segopts.getJsonRepresentation();
		assertEquals(json.getString("match"), MatchType.ANY.toString());
		assertEquals(json.getInt("saved_segment_id"), 40229);
		JSONArray jsonarr = json.getJSONArray("conditions");
		JSONObject cond = (JSONObject)jsonarr.get(0);
		assertEquals(cond.getString("condition_type"), ConditionType.INTERESTS.toString());
	}
	
	@Test
	public void testCampaign_CampaignContent() {
		JSONObject jsonObj = new JSONObject("{\"plain_text\":\"...\",\"html\":\"<!doctype html>\\n<html xmlns=\\\"http://www.w3.org/1999/xhtml\\\"><head><title>*|MC:SUBJECT|*</title>\\n</head>\\n<body>\\n...</body>\\n</html>\",\"archive_html\":\"<!doctype html>\\n<html xmlns=\\\"http://www.w3.org/1999/xhtml\\\">\\n<head>\\n<title>Test</title>\\n</head>\\n<body>...</body>\\n</html>\",\"_links\":[{\"rel\":\"parent\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/1767757\",\"method\":\"GET\",\"targetSchema\":\"https://us3.api.mailchimp.com/schema/3.0/Definitions/Campaigns/Response.json\"},{\"rel\":\"self\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/1767757/content\",\"method\":\"GET\",\"targetSchema\":\"https://us3.api.mailchimp.com/schema/3.0/Definitions/Campaigns/Content/Response.json\"},{\"rel\":\"create\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/1767757/content\",\"method\":\"PUT\",\"targetSchema\":\"https://us3.api.mailchimp.com/schema/3.0/Definitions/Campaigns/Content/PUT.json\"}]}");
		CampaignContent content = new CampaignContent(null, jsonObj);
		assertEquals(content.getHtml(), "<!doctype html>\n<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><title>*|MC:SUBJECT|*</title>\n</head>\n<body>\n...</body>\n</html>");
		assertEquals(content.getPlainText(), "...");
		assertEquals(content.getArchiveHtml(), "<!doctype html>\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n<title>Test</title>\n</head>\n<body>...</body>\n</html>");
	}

	// TODO:
//	@Test
//	public void testCampaign_CampaignFeedback() {
//		JSONObject jsonObj = new JSONObject("{"feedback": [{"feedback_id": 5437,"parent_id": 0,"block_id": 0,"message": "Can we use the new Freddie image in the header? You know, the one where he's wearing the viking hat?","is_complete": false,"created_by": "Freddie Jokes","created_at": "2015-09-15 18:32:00","updated_at": "2015-09-15 18:32:01","source": "web","campaign_id": "42694e9e57","_links": [{"rel": "self","href": "https://usX.api.mailchimp.com/3.0/campaigns/42694e9e57/feedback/5437","method": "GET","targetSchema": "https://api.mailchimp.com/schema/3.0/Campaigns/Feedback/Instance.json"},{"rel": "parent","href": "https://usX.api.mailchimp.com/3.0/campaigns/42694e9e57/feedback","method": "GET","targetSchema": "https://api.mailchimp.com/schema/3.0/Campaigns/Feedback/Collection.json"},{"rel": "update","href": "https://usX.api.mailchimp.com/3.0/campaigns/42694e9e57/feedback/5437","method": "PATCH","schema": "https://api.mailchimp.com/schema/3.0/Campaigns/Feedback/Instance.json"},{"rel": "delete","href": "https://usX.api.mailchimp.com/3.0/campaigns/42694e9e57/feedback/5437","method": "DELETE","targetSchema": "https://api.mailchimp.com/schema/3.0/Campaigns/Feedback/Collection.json"}]},{"feedback_id": 5441,"parent_id": 0,"block_id": 0,"message": "I really like the font in the body, but can we make it a bit bigger?\n\n-Freddie","is_complete": false,"created_by": "freddie@freddiesjokes.com","created_at": "2015-09-15 18:33:45","updated_at": "2015-09-15 18:33:47","source": "email","campaign_id": "42694e9e57","_links": [{"rel": "self","href": "https://usX.api.mailchimp.com/3.0/campaigns/42694e9e57/feedback/5441","method": "GET","targetSchema": "https://api.mailchimp.com/schema/3.0/Campaigns/Feedback/Instance.json"},{"rel": "parent","href": "https://usX.api.mailchimp.com/3.0/campaigns/42694e9e57/feedback","method": "GET","targetSchema": "https://api.mailchimp.com/schema/3.0/Campaigns/Feedback/Collection.json"},{"rel": "update","href": "https://usX.api.mailchimp.com/3.0/campaigns/42694e9e57/feedback/5441","method": "PATCH","schema": "https://api.mailchimp.com/schema/3.0/Campaigns/Feedback/Instance.json"},{"rel": "delete","href": "https://usX.api.mailchimp.com/3.0/campaigns/42694e9e57/feedback/5441","method": "DELETE","targetSchema": "https://api.mailchimp.com/schema/3.0/Campaigns/Feedback/Collection.json"}]}],"campaign_id": "","total_items": 2,"_links": [{"rel": "parent","href": "https://usX.api.mailchimp.com/3.0/campaigns/42694e9e57","method": "GET","targetSchema": "https://api.mailchimp.com/schema/3.0/Campaigns/Instance.json"},{"rel": "self","href": "https://usX.api.mailchimp.com/3.0/campaigns/42694e9e57/feedback","method": "GET","targetSchema": "https://api.mailchimp.com/schema/3.0/Campaigns/Feedback/Collection.json"},{"rel": "create","href": "https://usX.api.mailchimp.com/3.0/campaigns/42694e9e57/feedback","method": "POST","schema": "https://api.mailchimp.com/schema/3.0/Campaigns/Feedback/Instance.json"}]}");
//	}
	
	@Test
	public void testCampaign_SendChecklist() {
		JSONObject jsonObj = new JSONObject("{\"is_ready\":true,\"items\":[{\"type\":\"success\",\"id\":506,\"heading\":\"List\",\"details\":\"Mailchimp will deliver this to the Test list. (9 recipients)\"},{\"type\":\"success\",\"id\":115,\"heading\":\"Subject line\",\"details\":\"\\\"Testing\\\"\"},{\"type\":\"success\",\"id\":604,\"heading\":\"From email address\",\"details\":\"All replies for this campaign will be sent to Sue Tester, Ph.D. Sue.Tester@nospam.com.\"},{\"type\":\"success\",\"id\":116,\"heading\":\"Tracking\",\"details\":\"You chose to track clicks and opens in the HTML email. Clicks in the plain-text email will not be tracked.\"},{\"type\":\"success\",\"id\":107,\"heading\":\"HTML email\",\"details\":\"You're sending an HTML email created with your own HTML.\"},{\"type\":\"success\",\"id\":800,\"heading\":\"Plain-text email\",\"details\":\"We'll automatically generate a plain-text version of this email.\"},{\"type\":\"warning\",\"id\":114,\"heading\":\"Social Cards\",\"details\":\"You chose not to enable Social Cards for your campaign.\"},{\"type\":\"warning\",\"id\":108,\"heading\":\"MonkeyRewards\",\"details\":\"You chose not to include a MonkeyRewards link in your campaign.\"}],\"_links\":[{\"rel\":\"parent\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/1767757\",\"method\":\"GET\",\"targetSchema\":\"https://us3.api.mailchimp.com/schema/3.0/Definitions/Campaigns/Response.json\"},{\"rel\":\"self\",\"href\":\"https://us3.api.mailchimp.com/3.0/campaigns/1767757/send-checklist\",\"method\":\"GET\",\"targetSchema\":\"https://us3.api.mailchimp.com/schema/3.0/Definitions/Campaigns/Checklist/Response.json\"}]}");
		CampaignSendChecklist check = new CampaignSendChecklist(jsonObj);
		assertEquals(check.isReady(), true);
		List<CampaignSendCheck> items = check.getItems();
		assertEquals(items.size(), 8);
		CampaignSendCheck item = items.get(0);
		assertEquals(item.getType(), CampaignCheckType.SUCCESS);
		assertEquals(item.getId(), 506);
		assertEquals(item.getHeading(), "List");
		assertEquals(item.getDetails(), "Mailchimp will deliver this to the Test list. (9 recipients)");
	}

}
package ca.gkwb.struck.interaction.dao;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class InteractionVO {

//  "INTERACTION_TWEET_ID" bigint NOT NULL PRIMARY KEY,
	@Getter @Setter
	private long tweetId;
	
//  "INTERACTION_USER" character varying,
	@Getter @Setter
	private String user;
	
//  "INTERACTION_PROCESSED" character varying,
	@Getter @Setter
	private String processed;
	
//  "INTERACTION_RESULT" character varying,
	@Getter @Setter
	private String result;
	
	@Getter @Setter
	private long resultTweetId;
	
//  "INTERACTION_CREATE_DATE" date NOT NULL,	
	@Getter @Setter
	private Date creatDate;
	
//  "INTERACTION_ACTIVITY_DATE" date NOT NULL
	@Getter @Setter
	private Date activityDate;
	
}

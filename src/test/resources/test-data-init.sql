INSERT INTO strucktodb."TWEET"(
			"TWEET_ID",
			"TWEET_URL",
			"TWEET_ACCOUNT",
			"TWEET_TIMESTAMP")
		VALUES (
			740735330588995584,
			'http://twitter.com/TPSOperations/status/740720786277867520',
			'Toronto Police OPS',
			sysdate
		);

INSERT INTO strucktodb."LOCATION"(
			"LOCATION_ID",
			"LOCATION_LAT",
			"LOCATION_LONG",
			"LOCATION_CITY",
			"LOCATION_PROV",
			"LOCATION_COUNTRY",
			"LOCATION_CREATE_DATE",
			"LOCATION_USER")
		VALUES (
			5,
			12.124125,
			13.131255,
			'Toronto',
			'ON',
			'CA',
			sysdate,
			'JUNIT'
		);	
		
INSERT INTO strucktodb."INCIDENT"( 
            "INCIDENT_ID", 
            "INCIDENT_TWEET_ID", 
            "INCIDENT_SEVERITY", 
            "INCIDENT_NEWS_URL",
            "INCIDENT_CREATE_DATE",
            "INCIDENT_ACTIVITY_DATE", 
            "INCIDENT_LOCATION_ID", 
            "INCIDENT_VERIFIED") 
        VALUES (
        	1, 
        	740735330588995584, 
        	'UNKNOWN', 
        	'test.url.com', 
        	sysdate, 
        	sysdate,
        	5,
        	'N' );
        	
--interaction data #1   	
--INSERT INTO strucktodb."INTERACTION"(
--		  "INTERACTION_TWEET_ID",
--		  "INTERACTION_USER",
--		  "INTERACTION_PROCESSED",
--		  "INTERACTION_RESULT",
--		  "INTERACTION_CREATE_DATE",
--		  "INTERACTION_ACTIVITY_DATE"
--		) VALUES (
--			775486781768753153,
--			'Gingerk1d',
--			'01',
--			null,
--			null,
--			sysdate,
--			sysdate
--		);
     	
--interaction data #2		
--INSERT INTO strucktodb."INTERACTION"(
--		  "INTERACTION_TWEET_ID",
--		  "INTERACTION_USER",
--		  "INTERACTION_PROCESSED",
--		  "INTERACTION_RESULT",
--		  "INTERACTION_RESULT_TWEET_ID",
--		  "INTERACTION_CREATE_DATE",
--		  "INTERACTION_ACTIVITY_DATE"
--		) VALUES (
--			665486781768753152,
--			'Gingerk1d',
--			'03',
--			740735330588995584,
--			'Test response',
--			sysdate,
--			sysdate
--		);   		        	
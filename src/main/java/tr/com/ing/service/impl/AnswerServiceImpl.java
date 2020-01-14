package tr.com.ing.service.impl;

import tr.com.ing.constant.AppConstants;
import tr.com.ing.model.request.AnswerRequest;
import tr.com.ing.model.response.AnswerResponse;
import tr.com.ing.service.AnswerService;

public class AnswerServiceImpl implements AnswerService {

	@Override
	public AnswerResponse getAnswer(AnswerRequest answerRequest) {
		
		String intent = answerRequest.getObjectResponse().getIntent();
		String replyMessage = "";
		AnswerResponse answerResponse = new AnswerResponse();
		
		switch (intent) {
		case "ing":
			replyMessage = AppConstants.ING_REPLY_MESSAGE;
			break;
		case "pgs":
			replyMessage = AppConstants .PGS_REPLY_MESSAGE;
			break;
		case "mudo":
			replyMessage = AppConstants.MUDO_REPLY_MESSAGE;
			break;
		default:
			replyMessage = AppConstants.I_DONT_UNDERSTAND_MESSAGE;
			break;
		}
		
		answerResponse.setReplyMessage(replyMessage);
		
		return answerResponse;
		
	}

}

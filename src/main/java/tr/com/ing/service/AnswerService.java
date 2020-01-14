package tr.com.ing.service;

import tr.com.ing.model.request.AnswerRequest;
import tr.com.ing.model.response.AnswerResponse;

public interface AnswerService {

	public AnswerResponse getAnswer(AnswerRequest answerRequest);
	
}

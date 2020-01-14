package tr.com.ing.model.request;

import lombok.Data;
import tr.com.ing.model.response.ObjectResponse;

@Data
public class AnswerRequest {
	
	private ObjectResponse objectResponse;
	
	public AnswerRequest(ObjectResponse objectResponse) {
		this.objectResponse = objectResponse;
	}
	
}

package tr.com.ing.service;

import tr.com.ing.model.request.ObjectRequest;
import tr.com.ing.model.response.ObjectResponse;

public interface ObjectDetectionService {
	
	public ObjectResponse getObjectDetectionResponse(ObjectRequest objectRequest); 

}

//package tr.com.ing.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import tr.com.ing.model.request.AnswerRequest;
//import tr.com.ing.model.response.AnswerResponse;
//
//@RestController
//@RequestMapping("/")
//public class AnswerController {
//
//	@GetMapping(path="/answer", produces = "application/json")
//	public AnswerResponse getAnswerResponse(AnswerRequest answerRequest) {
//
//		System.out.println("answer service called.");
//		return new AnswerResponse();
//	}
//
//}

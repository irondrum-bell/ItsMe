package com.its.me;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.its.me.model.MemberObj;
import com.its.me.model.MemberUserInfoObj;
import com.its.me.model.ResResult;
import com.its.me.service.FileUploadService;
import com.its.me.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	//eclipse console창에 해당 로그가 찍힌다. 
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/getMemberList", method = RequestMethod.GET)
	/*클라이언트에서 요청하는 URL을 MVC 패턴의 컨트롤러 내의 클래스 혹은 메소드에 매핑. 해당 URL에 해당하는 경로를 지정하고 처리를 가능케 해주는 어노테이션*/
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult getMemberList(@RequestParam(value = "selectAuthor", defaultValue = "", required=false) String selectAuthor,
			@RequestParam("searchName") String searchName, 
			@RequestParam("searchNumber") String searchNumber,
			@RequestParam(value = "selectMajor", defaultValue = "", required=false) String selectMajor) {

		List<MemberObj> memberList = memberService.getMemberList(selectAuthor, searchName, searchNumber, selectMajor);
		ResResult rr = new ResResult();
		
		if(memberList == null) {
			rr.setCode(500);
			rr.setMsg("회원관리 리스트를 가져 올 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		rr.setValue(memberList);
		
		return rr;
	}
	
	/*@RequestMapping(value = "/isMember", method = RequestMethod.GET)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult isMember(@RequestParam("memberNum") String memberNum) {
		//비밀번호, 파일첨부 변수 추가 필요
		MemberObj member = memberService.isMember(memberNum);

		ResResult rr = new ResResult();
		if(member != null) {
			rr.setCode(500);
			rr.setMsg("이미 등록된 회원입니다.");
			return rr;
		}
		rr.setCode(200);
		return rr;
	}*/
	
	@RequestMapping(value = "/getMemberContent", method = RequestMethod.GET)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult getContent(@RequestParam("memberNum") String memberNum) {
		
		MemberObj Member = memberService.getMemberContent(memberNum);
		ResResult rr = new ResResult();

		if (Member == null ) {
			rr.setCode(500);
			rr.setMsg("회원정보를 가져 올 수 없습니다.");
			return rr;
		}

		rr.setCode(200);
		rr.setValue(Member);

		return rr;
	}
	
	@RequestMapping(value = "/resetMemberPw", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult resetMemberPw(@RequestParam("searchNum") String searchNum, @RequestParam("searchBirth") String searchBirth) {
		
		int result = memberService.resetMemberPw(searchNum, searchBirth);
		ResResult rr = new ResResult();
		
		if(result == 999) {
			rr.setCode(500);
			rr.setMsg("비밀번호 초기화를 진행할 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		
		return rr;
	}
	
	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult addMember(@RequestParam("memberBel") String memberBel, @RequestParam("memberDep") String memberDep,
			@RequestParam("memberName") String memberName, @RequestParam("memberNum") String memberNum,
			@RequestParam("memberPw") String memberPw, @RequestParam("memberAuthor") String memberAuthor, 
			@RequestParam("memberBirth") String memberBirth, @RequestParam("memberPhone") String memberPhone, 
			@RequestParam("memberEmail") String memberEmail, @RequestParam("memberAddr") String memberAddr,
			@RequestParam("file1") MultipartFile file1) {
		
		Map<String, String> imgInfo = fileUploadService.restore(file1);
		
		int result = memberService.addMember(memberBel, memberDep, memberName, memberNum, memberPw, Integer.parseInt(memberAuthor), 
				memberBirth, memberPhone, memberEmail, memberAddr, imgInfo.get("IMGPATH"), imgInfo.get("ORIGINFILENM"), imgInfo.get("SAVEFILENM"));
		
		ResResult rr = new ResResult();
		if(result == 999) {
			rr.setCode(500);
			rr.setMsg("회원을 등록할 수 없습니다.");
			return rr;
		}
		rr.setCode(200);
		return rr;
	}
	
	@RequestMapping(value = "/updateMember", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult updateMember(@RequestParam("memberBel") String memberBel,
			@RequestParam("memberDep") String memberDep,
			@RequestParam("memberName") String memberName,
			@RequestParam("memberNum") String memberNum,
			@RequestParam("memberPw") String memberPw,
			@RequestParam("memberAuthor") String memberAuthor,
			@RequestParam("memberBirth") String memberBirth,
			@RequestParam("memberPhone") String memberPhone,
			@RequestParam("memberEmail") String memberEmail,
			@RequestParam("memberAddr") String memberAddr) {
		
		int result = memberService.updateMember(memberBel, memberDep, memberName, memberNum, memberPw,
				Integer.parseInt(memberAuthor), memberBirth, memberPhone, memberEmail, memberAddr);
		ResResult rr = new ResResult();
		
		if(result == 999) {
			rr.setCode(500);
			rr.setMsg("회원을 추가 할 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		
		return rr;
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public String upload(Model model, @RequestParam("file1") MultipartFile file1) {
		
		fileUploadService.restore(file1);
//		model.addAttribute("url", url);
		return "result";
	}
	
	@RequestMapping(value = "/deleteMember", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult deleteMember(@RequestParam("deleteMember") String deleteMember) {
		
		
		int result = memberService.deleteMember(deleteMember);
		ResResult rr = new ResResult();
		
		if(result == 999) {
			rr.setCode(500);
			rr.setMsg("과목을 삭제 할 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		
		return rr;
	}
	
	/**
	 * App 개인정보 가져오기
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/sso/userInfo", method = RequestMethod.GET)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult userInfo(@RequestParam("userId") String userId) {
		
		/*httpServletRequest : 클라이언트의 요청과 관련된 정보와 동작을 가지고 있는 객체. 
		- 요청 파라미터 조회.
		- HttpSession 객체 조회 
		- request scope 상의 component간의 데이터 공유 지원*/
		
		MemberUserInfoObj user = memberService.getInfo(userId);
		
		ResResult rr = new ResResult();
		
		if(user == null) {
			rr.setCode(401);
			return rr;
		}
		rr.setValue(user);
		return rr;
	}
	

	/**
	 * App 비밀번호 변경
	 * @param newPw
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/sso/editpw", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult editPw(HttpServletRequest httpServletRequest) {
		
		/*httpServletRequest : 클라이언트의 요청과 관련된 정보와 동작을 가지고 있는 객체. 
		- 요청 파라미터 조회.
		- HttpSession 객체 조회 
		- request scope 상의 component간의 데이터 공유 지원*/
		String userId = httpServletRequest.getParameter("userId");
		String newPw = httpServletRequest.getParameter("newPw");
		
		String user = memberService.editPw(newPw, userId);
		
		System.out.println(userId+"  "+newPw+"  "+user);
		ResResult rr = new ResResult();
		
		if(user == null) {
			rr.setCode(401);
			return rr;
		}
		rr.setCode(200);
		return rr;
	}
}

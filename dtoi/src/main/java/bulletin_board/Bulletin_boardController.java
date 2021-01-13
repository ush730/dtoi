package bulletin_board;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;





@Controller
public class Bulletin_boardController {

	@Autowired
	private Bulletin_boardService bulletin_boardService;
	
	@RequestMapping("/admin/bulletin_board/index.do")
	public String index(HttpServletRequest req, Bulletin_boardVo vo) {
		// 서비스(로직) 처리(호출)
		int[] rowPageCount = bulletin_boardService.getRowPageCount(vo);
		List<Bulletin_boardVo> list = bulletin_boardService.getList(vo);

		// 값 저장
		// totalPage, list, reqPage
		req.setAttribute("totCount", rowPageCount[0]);
		req.setAttribute("totalPage", rowPageCount[1]);
		req.setAttribute("startPage", rowPageCount[2]); // 시작페이지
		req.setAttribute("endPage", rowPageCount[3]); // 마지막페이지
		req.setAttribute("list", list);
		// /board/index.do?reqPage=2 -> BoardVo에 reqPage 필드에 바인딩 (커맨드객체)
		// /board/index.do
		req.setAttribute("reqPage", vo.getReqPage());
		req.setAttribute("vo", vo);

		// jsp 포워딩
		return "admin/bulletin_board/index";
	}
	@GetMapping("/admin/bulletin_board/write.do")
	public String write() {
		return "admin/bulletin_board/write";
	}
	
	@RequestMapping("/admin/bulletin_board/insert.do")
	public void insert(Bulletin_boardVo vo, HttpServletRequest req, HttpServletResponse res, MultipartFile file) throws Exception {
				
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("<script>");
		if (bulletin_boardService.insert(vo)) {
			out.print("alert('정상적으로 등록되었습니다.');");
			out.print("location.href='/admin/bulletin_board/index.do';");
		} else {
			out.print("alert('등록실패.');");
			out.print("history.back();");
		}
		out.print("</script>");
		out.flush();
	}
	
	@RequestMapping("/admin/bulletin_board/detail.do")
	public String detail(HttpServletRequest req, Bulletin_boardVo vo) {
		
		Bulletin_boardVo uv = bulletin_boardService.selectOne(vo);		
		
		req.setAttribute("vo", uv);	
		
		// jsp 포워딩
		return "admin/bulletin_board/detail";
	}
	
	@PostMapping("/admin/bulletin_board/update.do")
	public void update(Bulletin_boardVo vo, HttpServletResponse res, HttpServletRequest req, MultipartFile file) throws IOException {		
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("<script>");
		if (bulletin_boardService.update(vo)) {
			out.print("alert('정상적으로 수정되었습니다.');");
			out.print("location.href='/admin/bulletin_board/detail.do?no="+vo.getBb_no()+"';");
		} else {
			out.print("alert('수정실패.');");
			out.print("history.back();");
		}
		out.print("</script>");
		out.flush();
	}
	
	@RequestMapping("/admin/bulletin_board/edit.do")
	public String edit(HttpServletRequest req, Bulletin_boardVo vo) {
		
		Bulletin_boardVo uv = bulletin_boardService.selectOne(vo);
		
		req.setAttribute("vo", uv);
		
		// jsp 포워딩
		return "/admin/bulletin_board/edit";
	}
}

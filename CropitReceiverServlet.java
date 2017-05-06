package cropit;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CropitReceiverServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String rootPath = new File(getClass().getResource("/").getPath()).getParentFile().getParentFile().getPath();
		String parentPath = rootPath + "/upload";
		String fileName = "" + new Date().getTime();
		
		String path = CropitUtil.recieveImg(req, parentPath, fileName, rootPath);
		System.out.println(path);
		
		resp.setHeader("Access-Control-Allow-Origin", "*"); // demo使用，允许ajax跨站请求 
		resp.getWriter().write(path);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}

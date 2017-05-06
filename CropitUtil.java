package cropit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class CropitUtil {
	
	/** 
	 * @param req
	 * @param paraName 前台自定义图片上传的参数明
	 * @param parentPath 父路径
	 * @param fileName 文件名（不包含后缀）
	 * @param rootPath 网站根路径，图片路径需要截取掉的部分
	 * @return
	 */
	public static String recieveImg(HttpServletRequest req, String paraName, String parentPath, String fileName, String rootPath) {
		
		FileOutputStream fos = null; 
		try {
			String imgData = req.getParameter(paraName == null ? "imgData" : paraName);

			Pattern p = Pattern.compile("data:image/(.*);base64,");
			Matcher m = p.matcher(imgData);
			m.find();
			imgData = imgData.substring(m.group(0).length());
			String suffix = "." + m.group(1);
			
			if (parentPath.endsWith("\\\\") || parentPath.endsWith("/")) parentPath.substring(0, parentPath.length() - 1);
			if (fileName.startsWith("\\\\") || fileName.startsWith("/")) fileName.substring(1);
			File output = new File(parentPath + "/" + fileName + suffix);
			
			byte[] imgBytes = Base64.getDecoder().decode(imgData);
			if (!output.getParentFile().exists()) {
				output.getParentFile().mkdirs();
			}
			fos = new FileOutputStream(output);
			fos.write(imgBytes);
			
			String path = output.getPath().replaceAll("\\\\", "/");
			if (rootPath != null) {
				if (rootPath.endsWith("\\\\") || rootPath.endsWith("/")) rootPath.substring(0, rootPath.length() - 1);
				path = path.substring(rootPath.length());
			}
			
			return path;
		} catch (Exception e) {
			// logger
			throw new RuntimeException(e);
		} finally {
			if (fos != null) {
				try {
					fos.close();
					fos = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static String recieveImg(HttpServletRequest req, String parentPath, String fileName, String rootPath) {
		return recieveImg(req, null, parentPath, fileName, rootPath);
	}
	
}

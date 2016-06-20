package org.fjzzy.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;

public class FormUtil {
	private static String basePath;
	
	public static void setBasePath(String basePath) {
		FormUtil.basePath = basePath;
	}


	public static HashMap<String, Object> parserData(ServletContext servletContext,
			HttpServletRequest request){
		DiskFileItemFactory diskFileItemFactory = createFileItemFactory(servletContext);
		List<FileItem> fileItems = getFileItems(request, diskFileItemFactory);
		return handleItems(fileItems);
	}
	
	
	//创建DiskFileItemFactory工厂
	private static DiskFileItemFactory createFileItemFactory(
			ServletContext servletContext) {
		File repository =  (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory(1024*1, repository);
		FileCleaningTracker fileCleaningTracker = FileCleanerCleanup.getFileCleaningTracker(servletContext);
		fileItemFactory.setFileCleaningTracker(fileCleaningTracker);
		return fileItemFactory;
	}
	
	//从request中解析form表单
	private static List<FileItem> getFileItems(HttpServletRequest request,
			DiskFileItemFactory diskFileItemFactory) {
		ServletFileUpload upLoad = new ServletFileUpload(diskFileItemFactory);
		List<FileItem> items = null;
		try {
			items = upLoad.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		return items;
	}
	
	@SuppressWarnings("unchecked")
	private static HashMap<String, Object> handleItems(List<FileItem> items) {
		Iterator<FileItem> iterator = items.iterator();
		
		HashMap<String, Object> itemMap = new HashMap<String, Object>();
		//存储上传图片名
		List<String> fileName = new ArrayList<String>();
		itemMap.put("fileName", fileName);
		while(iterator.hasNext()){
			FileItem item = iterator.next();
			if(item.isFormField()){
				itemMap.put(recode(item.getFieldName()), recode(item.getString()));
			}else if(!item.isFormField() && 
					!item.getName().trim().equals("") && 
					item.getContentType().indexOf("image") != -1){
				File file = new File(basePath + item.getName());
				((ArrayList<String>)itemMap.get("fileName")).add(item.getName());
				try {
					item.write(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return itemMap;
	}
	
	public static String recode(String code){
		try {
			if(code != null && !"".equals(code.trim())){
				code = new String(code.getBytes("iso-8859-1"), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return code;
	}
	
}

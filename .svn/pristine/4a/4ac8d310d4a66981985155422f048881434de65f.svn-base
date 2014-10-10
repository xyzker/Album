package album.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import album.model.Photo;
import album.model.User;
import album.service.IPhotoService;
import album.service.IUserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("album")
public class PhotoAction extends ActionSupport {

	private static final long serialVersionUID = -3443615910273945530L;
	
	@Resource
	private IUserService<User> userService;
	@Resource
	private IPhotoService<Photo> photoService;
	
	private Photo photo;
	private User user;
	//要输出的对象
	 private Map<String, Object> jsonMap = new HashMap<String, Object>();
	
	private File image;				//文件域
	private String imageContentType;		//文件类型
	private String imageFileName;			//文件名
	private String savePath;			//文件保存位置
	
	@Action(value="proUpload", results={@Result(type="json",params={"contentType",
			"text/html","noCache","true","root","jsonMap"})})
	public String proUpload() throws Exception{
		System.out.println(image.length());
		if(image.length() > 8388608){			//文件大于8M,不允许上传！
			jsonMap.put("msg", "too large");
			return SUCCESS;
		}
		user = (User)ActionContext.getContext().getSession().get("user");
		if(photo.getTitle() == null || photo.getTitle().trim().length() == 0){	//如果没有输入标题，则文件名就是标题
			photo.setTitle(getImageFileName());
		}
		photo.setFileName(getImageFileName());
		photo.setUser(user);
		user.getPhotos().add(photo);
		
		savePath = ServletActionContext.getServletContext().getRealPath("/upload/" + user.getName());
		File file = new File(savePath);
		if(!file.exists()){			//如果不存在该路径，则新建文件夹
			file.mkdirs();
		}
		
		FileOutputStream fos = new FileOutputStream(getSavePath() + 	//上传过程
				"/" + getImageFileName());
		FileInputStream fis = new FileInputStream(getImage());
		byte[] buffer = new byte[1024*1024];
		int len = 0;
		while((len = fis.read(buffer)) > 0){
			fos.write(buffer, 0, len);
		}
		fis.close();
        fos.close();
        
        photoService.saveOrUpdate(photo);			//更新数据库
        ActionContext.getContext().getSession().put("user", user);		//更新session
        jsonMap.put("msg", "success");
		return SUCCESS;
	}
	
	@Action(value="deletePhoto",results={@Result(type="json",params={"contentType",
			"text/html","noCache","true","root","jsonMap"})})
	public String deletePhoto() throws Exception{
		photo = photoService.find(Photo.class, photo.getId());
		System.out.println(photo.getTitle());
		user = (User)ActionContext.getContext().getSession().get("user");
		for(int i = 0; i<user.getPhotos().size(); i ++){
			if(user.getPhotos().get(i).getId() == photo.getId()){
				user.getPhotos().remove(i);
				continue;
			}
		}
		System.out.println(user.getPhotos().size());
		
		//删除文件
		String path = ServletActionContext.getServletContext().getRealPath	//文件路径
		("/upload/" + user.getName() + "/" + photo.getFileName());
		File file = new File(path);
		file.delete();
		
		photoService.delete(photo);
		ActionContext.getContext().getSession().put("user", user);		//更新session
     	return SUCCESS;
	}
	
	
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Photo getPhoto() {
		return photo;
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public File getImage() {
		return image;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setUserService(IUserService<User> userService) {
		this.userService = userService;
	}

	public IUserService<User> getUserService() {
		return userService;
	}

	public void setPhotoService(IPhotoService<Photo> photoService) {
		this.photoService = photoService;
	}

	public IPhotoService<Photo> getPhotoService() {
		return photoService;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

}

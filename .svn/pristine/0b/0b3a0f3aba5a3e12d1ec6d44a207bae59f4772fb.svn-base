package album.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import album.model.User;
import album.service.IUserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("album")
public class UserAction extends ActionSupport{

	private static final long serialVersionUID = -7882678615642444353L;
	
	private User user;
	//要输出的对象
	 private Map<String, Object> jsonMap = new HashMap<String, Object>();
	
	@Resource
	private IUserService<User> userService;
	
	@Action(value="proLogin", results={@Result(type="json",params={"contentType",
		"text/html","noCache","true","root","jsonMap"})})
	public String proLogin() throws Exception {
		user = userService.getUser(user.getName(), user.getPass());
		if(user != null){
			user = userService.getUserDetail(user.getId());
			ActionContext.getContext().getSession().put("user", user);
			jsonMap.put("msg", "success");
		}
		else {
			jsonMap.put("msg", "failure");
		}
		return SUCCESS;
	}

	@Action(value="logout", results={@Result(type="json",params={"contentType",
			"text/html","noCache","true","root","jsonMap"})})
	public String logout() throws Exception {
		ActionContext.getContext().getSession().put("user", null);
		jsonMap.put("user", null);
		return SUCCESS;
	}
	
	@Action(value="validateName", results={@Result(type="json",params={"contentType",
			"text/html","noCache","true","root","jsonMap"})})
	public String validateName() throws Exception {
		if(userService.exists(user.getName())){
			jsonMap.put("exists", "true");
			jsonMap.put("msg", "该用户名已存在！");
		}
		else {
			jsonMap.put("exists", "false");
			jsonMap.put("msg", "该用户名可以注册！");
		}
		return SUCCESS;
	}
	
	@Action(value="proRegist", results={@Result(type="json",params={"contentType",
			"text/html","noCache","true","root","jsonMap"})})
		public String proRegist() throws Exception {
			if(userService.exists(user.getName())){
				jsonMap.put("exists", "true");
				return SUCCESS;
			}
			else{
				userService.create(user);
				ActionContext.getContext().getSession().put("user", user);
				return SUCCESS;
			}
		}
	
	@Action(value="viewUsers", results={@Result(type="json",params={"contentType",
			"text/html","noCache","true","root","jsonMap"})})
	public String viewUsers() throws Exception{
		List<User> users = userService.getAllUsers();
		jsonMap.put("users", users);
		System.out.println(jsonMap);
		return SUCCESS;
	}
	
	@Action(value="visit", results = {@Result(location="/guest.jsp")})
	public String visit() throws Exception{
		user = userService.find(User.class, user.getId());
		return SUCCESS;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUserService(IUserService<User> userService) {
		this.userService = userService;
	}

	public IUserService<User> getUserService() {
		return userService;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

}

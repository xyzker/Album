package album.service;

import java.util.List;

import album.model.User;
import album.service.IService;

public interface IUserService<T extends User> extends IService<T> {
	public T getUser(String name, String pass);
	public boolean exists(String name);
	public List<T> getAllUsers();
	public T getUserDetail(int id);
}

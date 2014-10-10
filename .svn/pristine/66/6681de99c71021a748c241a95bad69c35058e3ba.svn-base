package album.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import album.model.User;
import album.service.IUserService;

@Component("userService")
@Transactional
public class UserServiceImpl<T extends User> extends ServiceImpl<T> implements IUserService<T>{

	@Override
	public void create(T user) {
		dao.create(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getUser(String name, String pass) {
		List<T> user = dao.createQuery("from User u where u.name = :name and u.pass = :pass")
					.setParameter("name", name).setParameter("pass", pass).list();
		if (user.size() > 0)
			return user.get(0);
		else return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean exists(String name) {
		List<T> user = dao.createQuery("from User u where u.name = :name")
						.setParameter("name", name).list();
		if(user.size() > 0) return true;
		else return false;
	}

	@Override
	public List<T> getAllUsers() {
		List<T> users = dao.list("from User");
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getUserDetail(int id) {
		return (T)dao.createQuery("from User u join fetch u.photos where u.id = :id")
						.setParameter("id", id).uniqueResult();
	}

}

package album.service;

import java.util.List;

public interface IService<T> {
	public T find(Class<T> clazz, int id);
	public void create(T baseBean);
	public void update(T baseBean);
	public void saveOrUpdate(T baseBean);
	public void delete(T baseBean);
	public List<T> list(String hql);		//查询实体
	public int getTotalCount(String hql, Object... params);		//查询页数
	public List<T> list(String hql, int firstResult, int maxSize, 
						Object... params);		//分页实体
}

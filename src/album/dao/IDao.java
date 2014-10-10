package album.dao;

import java.util.List;

import org.hibernate.Query;

public interface IDao<T>{		//DAO接口，使用泛型定义，可操作所有实体
	public T find(Class<T> clazz, int id);	//根据id查找实体
	public void create(T baseBean);		//创建实体
	public void saveOrUpdate(T baseBean);		//保存实体
	public void update(T baseBean);			//更新实体
	public void delete(T baseBean);		//删除实体
	public List<T> list(String hql);	//查询实体
	public int getTotalCount(String hql, Object... params);		//查询总数，可以不传入params
	public List<T> list(String hql, int firstResult, int maxResults, 
					Object... params);			//查询某页实体
	public Query createQuery(String hql);		//创建Query对象
	
}

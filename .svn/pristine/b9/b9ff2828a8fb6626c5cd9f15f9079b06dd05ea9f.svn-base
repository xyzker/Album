package album.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl<T>	implements IDao<T> {

	@Resource
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void create(T baseBean) {
		sessionFactory.getCurrentSession().persist(baseBean);
		sessionFactory.getCurrentSession().flush();
	}

	public Query createQuery(String hql) {
		return sessionFactory.getCurrentSession().createQuery(hql);
	}

	public void delete(T baseBean) {
		sessionFactory.getCurrentSession().delete(baseBean);
		sessionFactory.getCurrentSession().flush();
	}

	@SuppressWarnings("unchecked")
	public T find(Class<T> clazz, int id) {
		return (T)sessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public int getTotalCount(String hql, Object... params) {		//查询总数
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for(int i=0; params != null && i < params.length; i++){
			query.setParameter(i, params[i]);
		}
		List<T> list = (List<T>)query.list();
		return list.size();
		
	}

	//列出所有实体
	@SuppressWarnings("unchecked")
	public List<T> list(String hql) {
		return (List<T>)sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> list(String hql, int firstResult, int maxResults,
			Object... params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for(int i=0; params != null && i < params.length; i++){
			query.setParameter(i, params[i]);
		}
		List<T> list = (List<T>)query.setFirstResult(firstResult).
						setMaxResults(maxResults).list();
		return list;
	}

	public void saveOrUpdate(T baseBean) {
		sessionFactory.getCurrentSession().saveOrUpdate(baseBean);
		sessionFactory.getCurrentSession().flush();
	}
	
	public void update(T baseBean) {
		sessionFactory.getCurrentSession().update(baseBean);
		sessionFactory.getCurrentSession().flush();
	}

}

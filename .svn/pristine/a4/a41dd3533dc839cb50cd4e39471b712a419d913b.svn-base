package album.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import album.model.Photo;
import album.service.IPhotoService;

@Component("photoService")
@Transactional
public class PhotoServiceImpl<T extends Photo> extends ServiceImpl<T> implements IPhotoService<T>{

	@Override
	public void create(T photo) {
		dao.create(photo);
		
	}

}

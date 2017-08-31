package com.shop.product.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shop.product.dao.ProductDao;
import com.shop.product.domain.Product;
import com.shop.product.service.ProductService;
import com.shop.utils.PageBean;

@Transactional
public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public List<Product> findHot() {
		
		return productDao.findHot();
	}

	@Override
	public List<Product> findNew() {
		
		return productDao.findNew();
	}

	@Override
	public Product findByPid(Integer pid) {
		// TODO Auto-generated method stub
		return productDao.findByPid(pid);
	}

	@Override
	public PageBean<Product> findByPageCid(Integer cid, Integer page) {
		PageBean<Product> pb = new PageBean<Product>();
		pb.setPage(page);
		int limit = 8;
		pb.setLimit(limit);
		int totalCount = 0;
		totalCount = productDao.findCountCid(cid);
		pb.setTotalCount(totalCount);
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit+1;
		}
		//或者
		//Math.ceil(totalCount / limit);
		
		pb.setTotalPage(totalPage);
		
		//每页显示数据的集合
		//从哪儿开始
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByCidPage(cid, begin, limit);
		pb.setList(list);
		return pb;
	}

	@Override
	public PageBean<Product> findByPageCsid(Integer csid, Integer page) {
		PageBean<Product> pb = new PageBean<Product>();
		pb.setPage(page);
		int limit = 8;
		pb.setLimit(limit);
		int totalCount = 0;
		totalCount = productDao.findCountCsid(csid);
		pb.setTotalCount(totalCount);
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit+1;
		}
		pb.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		List<Product> list = productDao.findByCsidPage(csid, begin, limit);
		pb.setList(list);
		return pb;
	}

	@Override
	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pb = new PageBean<Product>();
		int limit = 10;
		pb.setPage(page);
		pb.setLimit(limit);
		int totalCount = 0;
		int totalPage = 0;
		totalCount = productDao.findCount();
		pb.setTotalCount(totalCount);
		if(totalCount%limit==0){
			totalPage = totalCount/limit;
		}else{
			totalPage = totalCount/limit+1;
		}
		pb.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		List<Product> list = productDao.findByPage(begin, limit);
		pb.setList(list);
		return pb;
	}

	@Override
	public void save(Product product) {
		productDao.save(product);
		
	}

	@Override
	public void delete(Product product) {
		productDao.delete(product);
		
	}

	@Override
	public void update(Product product) {
		productDao.update(product);
		
	}
	
}

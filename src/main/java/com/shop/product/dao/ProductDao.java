package com.shop.product.dao;

import java.util.List;

import com.shop.product.domain.Product;
import com.shop.utils.PageBean;

public interface ProductDao {

	public List<Product> findHot();

	public List<Product> findNew();

	public Product findByPid(Integer pid);

	public int findCountCid(Integer cid);

	public List<Product> findByCidPage(Integer cid, int begin, int limit);

	public int findCountCsid(Integer csid);

	public List<Product> findByCsidPage(Integer csid, int begin, int limit);

	public int findCount();

	public List<Product> findByPage(int begin, int limit);

	public void save(Product product);

	public void delete(Product product);

	public void update(Product product);

}

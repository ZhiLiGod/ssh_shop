package com.shop.product.service;

import java.util.List;

import com.shop.product.domain.Product;
import com.shop.utils.PageBean;

public interface ProductService {

	public List<Product> findHot();

	public List<Product> findNew();

	public Product findByPid(Integer pid);

	public PageBean<Product> findByPageCid(Integer cid, Integer page);

	public PageBean<Product> findByPageCsid(Integer csid, Integer page);

	public PageBean<Product> findByPage(Integer page);

	public void save(Product product);

	public void delete(Product product);

	public void update(Product product);

}

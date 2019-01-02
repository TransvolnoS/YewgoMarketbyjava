package com.java.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.java.bean.PageBean;
import com.java.bean.Product;
import com.java.utils.DataSourceUtils;

public class ProductDao {

	public List<Product> findAllProducts() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product";
		List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
	}

	public void savePro(Product pro) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into product values (?,?,?,?,?,?,?)";
		qr.update(sql, pro.getPid(),pro.getPname(),pro.getMarket_price(),pro.getShop_price(),pro.getPimage(),pro.getPdate(),pro.getPdesc());
	}

	public Product getProById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product where pid=?";
		Product pro = qr.query(sql, new BeanHandler<Product>(Product.class),id);
		return pro;
	}

	public void updatePro(Product product) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update product set pname=?,market_price=?,shop_price=?,pdesc=? where pid=?";
		qr.update(sql,product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPdesc(),product.getPid());
	}

	public void deletePro(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from product where pid=?";
		qr.update(sql,id);
	}

	public void delCheck(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql="delete from product where pid=?";
		qr.update(DataSourceUtils.getConnection(), sql, id);
	}

	public List<Product> getList(PageBean<Product> pb) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product limit ?,?";
		List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class), pb.getIndex(),pb.getPageSize());
		return list;
	}

	public int getCount() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from product";
		int count=((Long)qr.query(sql, new ScalarHandler())).intValue();
		return count;
	}
}

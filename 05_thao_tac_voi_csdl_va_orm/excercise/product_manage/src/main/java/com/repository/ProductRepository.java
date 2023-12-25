package com.repository;
import com.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
@org.springframework.stereotype.Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> getAll() {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> productTypedQuery = session.createQuery("from Product", Product.class);
        return productTypedQuery.getResultList();
    }

    @Override
    public void create(Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            session.save(product);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void edit(int id, Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();

            Product productEdit = detail(id);
            System.out.println(productEdit);

            productEdit.setName(product.getName());
            productEdit.setDescription(product.getDescription());
            productEdit.setManufacture(product.getManufacture());
            productEdit.setPrice(product.getPrice());
            System.out.println(productEdit);

            session.merge(productEdit);
            transaction.commit();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void delete(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            Product productDel = detail(id);
            session.delete(productDel);
            transaction.commit();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Product detail(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> productTypedQuery = session.createQuery("from Product where id = :id", Product.class);
        productTypedQuery.setParameter("id", id);
        return productTypedQuery.getSingleResult();
    }

    @Override
    public List<Product> search(String keyword) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> listSearch = session.createQuery("from Product where name like :key", Product.class);
        listSearch.setParameter("key", "%" + keyword + "%");
        return listSearch.getResultList();
    }
}

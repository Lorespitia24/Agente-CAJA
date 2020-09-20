package com.restaurant.payBox.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.payBox.entity.OrderClient;

/**
 *
 * @author Juliana Barrera, Lorena Espitia, Felipe García,Nicolás Ramos, Lina Sanabria
 */
@Repository
public interface OrderClientDAO extends JpaRepository<OrderClient, Long> {

}

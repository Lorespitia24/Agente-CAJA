package com.restaurant.payBox.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.payBox.entity.Bill;

/**
 *
 * @author Juliana Barrera, Lorena Espitia, Felipe García, Lina Sanabria
 */
@Repository
public interface BillDAO extends JpaRepository<Bill, Long> {

}

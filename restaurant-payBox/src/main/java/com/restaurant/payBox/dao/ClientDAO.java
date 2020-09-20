package com.restaurant.payBox.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.payBox.entity.ClientRestaurant;

/**
 *
 * @author Juliana Barrera, Lorena Espitia, Felipe García,Nicolás Ramos, Lina Sanabria
 */

@Repository
public interface ClientDAO extends JpaRepository<ClientRestaurant, Long>{

}

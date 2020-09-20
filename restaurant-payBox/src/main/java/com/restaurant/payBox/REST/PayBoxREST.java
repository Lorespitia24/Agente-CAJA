package com.restaurant.payBox.REST;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.payBox.dao.ATM_DAO;
import com.restaurant.payBox.dao.BillDAO;
import com.restaurant.payBox.dao.OrderClientDAO;
import com.restaurant.payBox.dao.PlateDAO;
import com.restaurant.payBox.entity.ATM;
import com.restaurant.payBox.entity.Bill;
import com.restaurant.payBox.entity.Client;
import com.restaurant.payBox.entity.OrderClient;
import com.restaurant.payBox.entity.Plate;
import com.restaurant.payBox.entity.TypeBill;
import com.restaurant.payBox.entity.TypePayment;
import com.restaurant.payBox.entity.TypePlate;
import com.restaurant.payBox.entity.Waiter;
import com.restaurant.payBox.entity.WorkingDay;
import com.restaurant.payBox.service.BillService;

/**
 *
 * @author Juliana Barrera, Lorena Espitia, Felipe García, Nicolás Ramos, Lina Sanabria
 */

@RestController
@RequestMapping("payBox")
public class PayBoxREST {
	
private BillService billService;
public PayBoxREST(BillService billService) {
	this.billService = billService;
}
	
	@Autowired
	private ATM_DAO atmDAO;
//	@Autowired
//	private BillDAO billDAO;
//	@Autowired
//	private OrderClientDAO orderClientDAO;
//	@Autowired
//	private PlateDAO plateDAO;
//	
	/**
	 * Este metodo me crea el cajero del restaurante con su jornada de trabajo
	 * @return
	 */
	@GetMapping
	public ResponseEntity<ATM> createATM() {
		ATM atm = new ATM();
		atm.setIdAtm(1);
		atm.setOccupied(false);
		atm.setWorkingDay(new WorkingDay(1,28800, 600,7200));
		atmDAO.save(atm);
		return ResponseEntity.ok(atm);	
	}
	
	
	@PostMapping("/createOrder")
	public ResponseEntity<OrderClient> createPlate(@RequestBody OrderClient orderClient) {
		return billService.createOrder(orderClient);
	}
	
	@PostMapping("/createBill")
	public ResponseEntity<Bill> createPlate(@RequestBody List<OrderClient> orderClientList) {
		return billService.createBill(orderClientList);
	}
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<OrderClient>> getAllOrders() {
	return billService.getAllOrdersClient();
	}
	
	@GetMapping("/totalIncome")
	public ResponseEntity<List<Bill>> totalRestaurantIncome() {
		return billService.getAllBills();
	}
	
	
}

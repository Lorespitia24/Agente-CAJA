package com.restaurant.payBox.REST;

import java.awt.PageAttributes.MediaType;
import java.io.Console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTMLEditorKit.LinkController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.restaurant.payBox.dao.ATM_DAO;
import com.restaurant.payBox.dao.BillDAO;
import com.restaurant.payBox.dao.OrderClientDAO;
import com.restaurant.payBox.dao.PlateDAO;
import com.restaurant.payBox.entity.ATM;
import com.restaurant.payBox.entity.Bill;
import com.restaurant.payBox.entity.ClientRestaurant;
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
//	private RestTemplate restTemplate;
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
	@GetMapping (produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ATM> createATM() {
		ATM atm = new ATM();
		atm.setIdAtm(1);
		atm.setOccupied(false);
		atm.setWorkingDay(new WorkingDay(1,28800, 600,7200));
		atmDAO.save(atm);
		return ResponseEntity.ok(atm);	
	}
	
	
	@PostMapping(consumes = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE},
			produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE}, path = "/createOrder")
	public ResponseEntity<OrderClient> createPlate(@RequestBody OrderClient url) {
//		OrderClient orderClient2 = restTemplate.getForObject("https://"+url, OrderClient.class);
		return billService.createOrder(url);
	}
	
	/**
	 * Este metodo crea facturas
	 * @param orderClientList
	 * @return
	 */
	@PostMapping(produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE}, path ="/createBill")
	public ResponseEntity<Bill> createBill(@RequestBody List<OrderClient> orderClientList) {
		return billService.createBill(orderClientList);
	}
	
	/**
	 * traer ordenes 
	 * @return
	 */
	
	@GetMapping(produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE}, path ="/getAllOrders")
	public ResponseEntity<List<OrderClient>> getAllOrders() {
	return billService.getAllOrdersClient();
	}
	
	/**
	 * este metodo trae las facturas
	 * @return
	 */
	@GetMapping(produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE}, path ="/totalBill")
	public ResponseEntity<List<Bill>> totalRestaurant() {
		return billService.getAllBills();
	}
//	
//	@GetMapping("/totalIncome")
//	public void totalIncome(){
//		logger.debug("message"+ billService.totalRestaurantIncome(billService.getAllBills().getBody()).toString());
//
//		
//	}
	
	/**
	 * Este metodo trae los meseros
	 * @return
	 */
	
	@GetMapping(produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE}, path ="/waiterTips")
	public ResponseEntity<List<Waiter>> waiterTips(){
		return billService.getAllWaitEntity();
	}
		
	
}

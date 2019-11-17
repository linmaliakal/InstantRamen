package com.web_services.instant_pot.service.address;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.web_services.instant_pot.dal.address.AddressDAL;
import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.service.address.representation.AddressRepresentation;
import com.web_services.instant_pot.service.address.representation.AddressRequest;
import com.web_services.instant_pot.service.address.workflow.AddressActivity;
import com.web_services.instant_pot.service.product.representation.ProductRepresentation;
import com.web_services.instant_pot.service.product.representation.ProductRequest;

@Path("/addressservice/")
public class AddressResource implements AddressService {
	private static AddressActivity aa = new AddressActivity();
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customeraddresses/{id}")
	public Set<AddressRepresentation> getAllAddressForCustomer(@PathParam("id") Long customerID) {
		System.out.println("GET METHOD Request for all Addresses from Customer with ID: " + Long.toString(customerID));
		return aa.getAllAddressForCustomer(customerID);
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partneraddresses/{id}")
	public Set<AddressRepresentation> getAllAddressForPartner(@PathParam("id") Long partnerID) {
		System.out.println("GET METHOD Request for all Addresses from Partner with ID: " + Long.toString(partnerID));
		return aa.getAllAddressForPartner(partnerID);
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/address/{id}")
	public AddressRepresentation getAddressByID(@PathParam("id") Long id) {
		System.out.println("GET METHOD Request for Address with ID: " + Long.toString(id));
		return aa.getAddressByID(id);
	}
	
//	@POST
//	@Consumes({"application/xml" , "application/json"})
//	@Produces({"application/xml" , "application/json"})
//	@Path("/address")
//	public AddressRepresentation createProduct(AddressRequest addressRequest) {
//		System.out.println("POST METHOD Request to create new address with street address: " + addressRequest.getProductName());
//		return aa.createAddress(addressRequest);
//	}
//	
//	public Address createAddress(String streetAddress, String city, String state, String zip) {
//		AddressDAL ad = new AddressDAL();
//		return ad.createAddress(streetAddress, city, state, zip);
//	}
//	
//	public Address updateAddress(Long id, String streetAddress, String city, String state, String zip) {
//		AddressDAL ad = new AddressDAL();
//		return ad.updateAddress(id, streetAddress, city, state, zip);
//	}
//	
//	public Address deleteAddress(Long id){
//		AddressDAL ad = new AddressDAL();
//		return ad.deleteAddress(id);
//	}
}

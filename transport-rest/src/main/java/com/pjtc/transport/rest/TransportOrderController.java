package com.pjtc.transport.rest;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.pjtc.transport.ExceptionBase;
import com.pjtc.transport.common.FilterCriterion;
import com.pjtc.transport.common.PaginationOption;
import com.pjtc.transport.domain.Account;
import com.pjtc.transport.domain.TransportOrder;
import com.pjtc.transport.domain.TransportOrderItem;
import com.pjtc.transport.domain.User;
import com.pjtc.transport.service.TransportOrderService;
import com.pjtc.transport.web.Message;

@Controller
@RequestMapping(value="/transport")
public class TransportOrderController {

	
	private TransportOrderService transportOrderService;
	
	public TransportOrderController(){
		
	}
	
	@Autowired(required=true)
	public void setTransportOrderService(TransportOrderService transportOrderService){
		this.transportOrderService = transportOrderService;
	}

    /**
     * @param transportOrder
     * @return
     * @throws Exception
     */
    @RequestMapping(value="transportOrders", method=RequestMethod.POST)
    public @ResponseBody long createOrder(
            @RequestBody TransportOrder transportOrder) throws Exception {
    	// User should be retrieved from session
    	User user = new User();
    	user.setId(1);
    	
    	transportOrder.setCreatedBy(user);
    	transportOrder.setLastChangedBy(user);
	
		long id = transportOrderService.createOrder(transportOrder);		
		return id;
    }
   
    
    /**
     * @param filterCriteriaQueryParam - filter criteria
     * @param offset - offset of the pagination
     * @param count  - count of the pagination
     * @return
     * @throws Exception
     */
    @RequestMapping(value="transportOrders", method=RequestMethod.GET)
    public @ResponseBody List<TransportOrder> queryOrder(
            @RequestParam(value="$filter", required=false) String filterCriteriaQueryParam, 
            @RequestParam(value="$offset", required=false) Integer offset,
            @RequestParam(value="$count", required=false) Integer count) throws Exception {
    	
    	List<FilterCriterion> filterCriteria = new ArrayList<FilterCriterion>();	  	
    	
    	if (filterCriteriaQueryParam != null){
    		String[] filterCriterionParams = filterCriteriaQueryParam.split("[and|or]"); 
	    	for (String s: filterCriterionParams){
	    		int startIndex = 0;
	    		int endIndex  = s.length() -1;
	    		if ((startIndex = s.indexOf('(')) < 0){
	    			startIndex = 0;
	    		}
	    		
	    		if (startIndex > 0){
	    			
	    			while (endIndex > 0){
	    				if (endIndex == ')')
	    					break;
	    				endIndex--;
	    			}
	    			
	    		}
	    		
	    		s = s.substring(startIndex, endIndex);
	    		
	    		String[] terms = s.split(" ");
	    		FilterCriterion filterCriterion = null;
	    		switch (terms[1]){
		    		case FilterCriterion.OPERATOR_EQUAL: 		    			
		    		case FilterCriterion.OPERATOR_LIKE: 
		    			filterCriterion = new FilterCriterion(terms[0], 
		    				terms[1], terms[2]); 	
		    			break;
	    			default:
	    				filterCriterion = new FilterCriterion(terms[0], 
			    				terms[1], terms[2]);	    			
	    		}
	    		
	    		filterCriteria.add(filterCriterion);
	    	}
    	}
    	
    	PaginationOption paginationOption = null;
    	if (offset != null && count != null){
    		paginationOption = new PaginationOption(offset, count);
    	}
    	
    	List<TransportOrder> transportOrders = 
    			transportOrderService.queryOrder(filterCriteria, paginationOption);
    	
    	for (TransportOrder transportOrder: transportOrders){
    		Account account = new Account();
    		account.setId(transportOrder.getShipper().getId());
    		transportOrder.setShipper(account);
    		//transportOrder.setShipper(null);
    		List<TransportOrderItem> transportOrderItems = transportOrder.getItems();
    		
    		for (TransportOrderItem transportOrderItem: transportOrderItems){
    			transportOrderItem.setOrder(null);
    		}
    		//transportOrder.setCreatedBy(null);
    		//transportOrder.setLastChangedBy(null);
    	}
    	
    	
		return transportOrders;	
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ExceptionBase.class})
    @ResponseBody Message handleInternalServerError(HttpServletRequest req, Exception ex) {
    	
        return new Message(Message.MESSAGE_TYPE_ERROR, 
        		((ExceptionBase)ex).getLocalizedMessage(req.getLocale()));
    } 
	

}
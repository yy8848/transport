package com.pjtc.transport.service;

import java.util.Date;
import java.util.List;

import com.pjtc.transport.ExceptionBase;
import com.pjtc.transport.OptimisticLockException;
import com.pjtc.transport.ValidationException;
import com.pjtc.transport.common.Constants;
import com.pjtc.transport.common.FilterCriterion;
import com.pjtc.transport.common.PaginationOption;
import com.pjtc.transport.dao.TransportOrderDao;
import com.pjtc.transport.domain.TransportOrder;

public class TransportOrderServiceImpl implements TransportOrderService {
	
	private TransportOrderDao transportOrderDao;
	
	public TransportOrderServiceImpl(){
		
	}
	
	public void setTransportOrderDao(TransportOrderDao transportOrderDao){
		this.transportOrderDao = transportOrderDao;
	}

	public long createOrder(TransportOrder order) throws ExceptionBase {
		/*
		if (order.getShipper() == null || order.getShipper().getId() == 0){
			throw new ValidationException(Constants.SHIPPER_MANDATORY_MSG_KEY,
					new Object[0]);
		}
		
		// Check order against account service instead
		if (order.getShipper().getId() < 0){
			throw new ValidationException(Constants.SHIPPER_NOT_FOUND_MSG_KEY,
					new Object[]{order.getShipper().getId()});		
		}
		*/
		
		order.setCreatedAt(new Date());		
		return transportOrderDao.createOrder(order);
	}

	public void updateOrder(TransportOrder order)
			throws OptimisticLockException, ExceptionBase {
		// TODO Auto-generated method stub
		
	}

	public TransportOrder getOrder(long id) throws ExceptionBase {
		// TODO Auto-generated method stub
		return null;
	}

	public void releaseOrder(TransportOrder order)
			throws OptimisticLockException, ExceptionBase {
		// TODO Auto-generated method stub
		
	}

	public void cancelOrder(TransportOrder order)
			throws OptimisticLockException, ExceptionBase {
		// TODO Auto-generated method stub
		
	}

	public List<TransportOrder> queryOrder(List<FilterCriterion> filterCriteria,
			PaginationOption paginationOption) {
		
		return transportOrderDao.queryOrder(filterCriteria, paginationOption);
	}

}

package com.pjtc.transport.dao;

import java.util.List;

import com.pjtc.transport.ExceptionBase;
import com.pjtc.transport.OptimisticLockException;
import com.pjtc.transport.common.FilterCriterion;
import com.pjtc.transport.common.PaginationOption;
import com.pjtc.transport.domain.TransportOrder;

public interface TransportOrderDao {
	
	public long createOrder(TransportOrder order) throws ExceptionBase;
	
	public void updateOrder(TransportOrder order) throws OptimisticLockException, ExceptionBase;
	
	public void deleteOrder(TransportOrder order) throws ExceptionBase;
	
	public TransportOrder getOrder(TransportOrder order) throws ExceptionBase;
	
	public List<TransportOrder> queryOrder(List<FilterCriterion> filterCriteria, 
			PaginationOption paginationOption);

}

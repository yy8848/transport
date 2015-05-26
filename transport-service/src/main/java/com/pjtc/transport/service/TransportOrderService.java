package com.pjtc.transport.service;

import java.util.List;

import com.pjtc.transport.ExceptionBase;
import com.pjtc.transport.OptimisticLockException;
import com.pjtc.transport.ValidationException;
import com.pjtc.transport.common.FilterCriterion;
import com.pjtc.transport.common.PaginationOption;
import com.pjtc.transport.domain.TransportOrder;

public interface TransportOrderService {
	
	public long createOrder(TransportOrder order) throws ValidationException, ExceptionBase;
	
	public void updateOrder(TransportOrder order) throws OptimisticLockException, ExceptionBase;
	
	public TransportOrder getOrder(long id) throws ExceptionBase;
	
	public void releaseOrder(TransportOrder order) throws OptimisticLockException, ExceptionBase;
	
	public void cancelOrder(TransportOrder order) throws OptimisticLockException, ExceptionBase;
	
	public List<TransportOrder> queryOrder(List<FilterCriterion> filterCriteria, PaginationOption paginationOption);	

}

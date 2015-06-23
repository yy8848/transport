package com.pjtc.transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.pjtc.transport.ExceptionBase;
import com.pjtc.transport.OptimisticLockException;
import com.pjtc.transport.common.FilterCriterion;
import com.pjtc.transport.common.PaginationOption;
import com.pjtc.transport.domain.TransportOrder;

public class TransportOrderDaoImpl extends DaoImplBase implements
		TransportOrderDao {

	public TransportOrderDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public long createOrder(TransportOrder order) throws ExceptionBase {
		return (Long) getSession().save(order);
	}

	public void updateOrder(TransportOrder order)
			throws OptimisticLockException, ExceptionBase {
		// TODO Auto-generated method stub

	}

	public void deleteOrder(TransportOrder order) throws ExceptionBase {
		// TODO Auto-generated method stub

	}

	public TransportOrder getOrder(TransportOrder order) throws ExceptionBase {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TransportOrder> queryOrder(
			List<FilterCriterion> filterCriteria,
			PaginationOption paginationOption) {
		Criteria criteria = getSession().createCriteria(TransportOrder.class);

		if (filterCriteria != null) {
			for (FilterCriterion filterCriterion : filterCriteria) {

				switch (filterCriterion.getOperator()) {
				case FilterCriterion.OPERATOR_EQUAL:
					criteria.add(Restrictions.eq(
							filterCriterion.getFieldName(),
							filterCriterion.getValueLow()));

				case FilterCriterion.OPERATOR_LIKE:
					criteria.add(Restrictions.like(filterCriterion
							.getFieldName(), filterCriterion.getValueLow()
							.replace('*', '%')));

				default:
					criteria.add(Restrictions.eq(
							filterCriterion.getFieldName(),
							filterCriterion.getValueLow()));
				}

			}
		}

		if (paginationOption != null) {
			criteria.setFirstResult(paginationOption.getOffset())
					.setMaxResults(paginationOption.getCount());
		}

		@SuppressWarnings("unchecked")
		List<TransportOrder> list = (List<TransportOrder>) criteria.list();
		
		return list;
	}

}

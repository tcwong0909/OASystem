package com.oasystem.test;

import java.sql.Connection;

import com.oasystem.bean.Message;
import com.oasystem.dao.ISealapplyDAO;
import com.oasystem.service.IBooksapplyService;
import com.oasystem.service.ICarapplyService;
import com.oasystem.service.ICardApplyService;
import com.oasystem.service.ICardService;




import com.oasystem.service.ISealService;
import com.oasystem.service.ISealapplyService;
import com.oasystem.service.impl.BooksapplyServiceImpl;
import com.oasystem.service.impl.CarServiceImpl;
import com.oasystem.service.impl.CarapplyServiceImpl;
import com.oasystem.service.impl.CardApplyServiceImpl;
import com.oasystem.service.impl.CardServiceImpl;





import com.oasystem.service.impl.SealServiceImpl;
import com.oasystem.service.impl.SealapplyServiceImpl;
import com.oasystem.utils.C3P0Utils;

public class Test {
	public static void main(String[] args) throws Exception {
		Connection conn = C3P0Utils.getConnection();
		//ICardDAO tDao = new CardDAOImpl(conn);
		//List<Card> trip = tDao.selectAll();
		//System.out.println(trip);
		//ICardApplyService service=new CardApplyServiceImpl();
		//ISealService service=new SealServiceImpl();
		//System.out.println(service.selectAll());
		ISealapplyService service=new SealapplyServiceImpl();
		System.out.println(service.selectAll());
//		ISealService service=new SealServiceImpl();
		System.out.println(service.selectAll());
//		Message message = new Message();
//		message.get
	}
}

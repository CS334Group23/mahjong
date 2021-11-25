package server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import network.BidMsg;
import utils.BidType;

class BidResponserStub implements BidResponser{
	private static BidType type;
	
	public static void setBidType(BidType t) {
		type = t;
	}
	public BidResponserStub() {
		
	}
	
	@Override
	public void response(Server server, BidMsg msg) {
		assertEquals(type.getBidType(), msg.getBidType());
	}
}

public class TestBidOperation {
	@Test
	public void testOperate1() {
		BidResponserStub.setBidType(BidType.EMPTY);
		BidOperation op = new BidOperation();
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1, null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
	}
	
	@Test
	public void testOperate2() {
		BidResponserStub.setBidType(BidType.CHOW);
		BidOperation op = new BidOperation();
		op.operate(new Server(), new BidMsg(0, 1, BidType.CHOW, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
	}
	
	@Test
	public void testOperate3() {
		BidResponserStub.setBidType(BidType.PONG);
		BidOperation op = new BidOperation();
		op.operate(new Server(), new BidMsg(0, 1, BidType.PONG, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.CHOW, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
	}
	
	@Test
	public void testOperate4() {
		BidResponserStub.setBidType(BidType.KONG);
		BidOperation op = new BidOperation();
		op.operate(new Server(), new BidMsg(0, 1, BidType.KONG, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.CHOW, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
	}
	
	@Test
	public void testOperate5() {
		BidResponserStub.setBidType(BidType.WIN);
		BidOperation op = new BidOperation();
		op.operate(new Server(), new BidMsg(0, 1, BidType.WIN, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.KONG, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
	}
	
	@Test
	public void testOperate6() {
		BidResponserStub.setBidType(BidType.KONG);
		BidOperation op = new BidOperation();
		op.operate(new Server(), new BidMsg(0, 1, BidType.KONG, "BidResponserStub", 1,null, null, true));
		op.operate(new Server(), new BidMsg(0, 1, BidType.CHOW, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
	}
	
	@Test
	public void testOperate7() {
		BidResponserStub.setBidType(BidType.WIN);
		BidOperation op = new BidOperation();
		op.operate(new Server(), new BidMsg(0, 1, BidType.WIN, "BidResponserStub", 1,null, null, true));
		op.operate(new Server(), new BidMsg(0, 1, BidType.KONG, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
		op.operate(new Server(), new BidMsg(0, 1, BidType.EMPTY, "BidResponserStub", 1,null, null, false));
	}
}

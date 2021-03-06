package net.oopscraft.application.console;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import net.oopscraft.application.core.JmxInfo;
import net.oopscraft.application.core.JsonConverter;
import net.oopscraft.application.core.ValueMap;
import net.oopscraft.application.core.WebSocketHandler;
import net.oopscraft.application.core.monitor.MonitorAgent;
import net.oopscraft.application.core.monitor.MonitorAgentListener;


public class ConsoleWebSocketHandler extends WebSocketHandler {
	
	private static final Log LOG = LogFactory.getLog(ConsoleWebSocketHandler.class);
	
	enum Id { jmxInfoHistory, jmxInfo }
	
//	MonitorListener monitorListener = new MonitorListener() {
//		@Override
//		public void onCheck(JmxInfo jmxInfo, List<JmxInfo> jmxInfoHistory) throws Exception {
//			ValueMap messageMap = new ValueMap();
//			messageMap.set("id", Id.jmxInfo);
//			messageMap.set("result", convertJmxInfoToMap(jmxInfo));				
//			String message = JsonConverter.convertObjectToJson(messageMap);
//			broadcastMessage(message);
//		}
//	};

	@Override
	public void onCreate() {
		LOG.info("onCreate");
//		// Adds JMX Monitor Listener
//		try {
//			Monitor.getInstance().addListener(monitorListener);
//		}catch(Exception ignore) {}
	}

	@Override
	public void onDestroy() {
		LOG.info("onDestroy");
//		// Removes JMX Monitor Listener
//		try {
//			Monitor.getInstance().removeListener(monitorListener);
//		}catch(Exception ignore) {}
	}

	@Override
	public void onConnect(WebSocketSession session) {
		LOG.info("onConnect");
	}

	@Override
	public void onClose(WebSocketSession session, CloseStatus status) {
		LOG.info("onClose");
	}

	@Override
	public void onMessage(WebSocketSession session, TextMessage message) {
		LOG.info("onMessage");
		this.sendMessage(session, message.getPayload());
//		try {
//			ValueMap messageMap = JsonConverter.convertJsonToObject(message.getPayload(), ValueMap.class);
//			Id id = Id.valueOf(messageMap.getString("id"));
//			switch(id) {
//			case jmxInfoHistory :
//				messageMap.set("result", getJmxInfoHistoryResult());
//			break;
//			case jmxInfo :
//				messageMap.set("result", getJmxInfoResult());
//			break;
//			default :
//			break;
//			}
//			String response = JsonConverter.convertObjectToJson(messageMap);
//			this.sendMessage(session, response);
//		}catch(Exception ignore) {
//			LOG.warn(ignore.getMessage());
//			this.sendMessage(session, ignore.getMessage());
//		}
	}
	
	private Object getJmxInfoHistoryResult() throws Exception {
		List<ValueMap> list = new ArrayList<ValueMap>();
		for(JmxInfo jmxInfo : MonitorAgent.getInstance().getJmxInfoHistory()) {
			list.add(convertJmxInfoToMap(jmxInfo));
		}
		return list;
	}
	
	private ValueMap getJmxInfoResult() throws Exception {
		return convertJmxInfoToMap(MonitorAgent.getInstance().getLastestJmxInfo());
	}
	
	private ValueMap convertJmxInfoToMap(JmxInfo jmxInfo) throws Exception {
		ValueMap jmxInfoMap = new ValueMap();
		jmxInfoMap.set("osInfo", jmxInfo.getOsInfo());
		jmxInfoMap.set("memInfo", jmxInfo.getMemInfo());
		jmxInfoMap.set("classInfo", jmxInfo.getClassInfo());
		jmxInfoMap.set("diskInfo", jmxInfo.getDiskInfo());
		jmxInfoMap.set("threadInfoList", jmxInfo.getThreadInfoList());
		return jmxInfoMap;
	}

}

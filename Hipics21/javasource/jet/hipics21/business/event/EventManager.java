package jet.hipics21.business.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EventManager {

	private static final EventManager eventManager = new EventManager();
	
	private Map<Integer, EventImpl> eventMap = new HashMap<Integer, EventImpl>();
	private AtomicInteger lastEventId = new AtomicInteger();
	
	public static EventManager getEventManager() {
		return eventManager;
	}
	
	private EventManager() {
		// empty
	}
	
	private EventImpl getEventImpl(int eventId) {
		assert eventId >= 0:"eventId negative " + eventId;
		
		return this.eventMap.get(eventId);
	}
	
	private void putEventImpl(EventImpl eventImpl) {
		
		this.eventMap.put(eventImpl.getEventId(), eventImpl);
	}
	
	public Event createEvent(String name1, String name2) {
		assert name1 != null:"name1 null";
		assert name2 != null:"name2 null";
		
		EventImpl eventImpl = new EventImpl(this.lastEventId.getAndIncrement());
		eventImpl.setName1(name1);
		eventImpl.setName2(name2);
		
		EventImpl preExistingEventImpl = getEventImpl(eventImpl.getEventId());
		
		if (preExistingEventImpl != null) {
			throw new IllegalStateException("eventImpl already exists " + preExistingEventImpl);
		}
		
		putEventImpl(eventImpl);
		
		return eventImpl;
		
	}

	public Event getEvent(int eventId) {
		assert eventId >= 0:"eventId negative " + eventId;
		
		EventImpl eventImpl = getEventImpl(eventId);
			
		return eventImpl;
		
	}
	
	public List<Event> getEventByName(String name1, String name2) {
		assert name1 != null || name2 != null:"name1 and name2 null";
		List<Event> eventList = new ArrayList<Event>();
		
		for (EventImpl eventImpl : this.eventMap.values()) {
			if (name1 != null) {
				if (!eventImpl.getName1().equals(name1)) {
					continue;
				}
			}
			if (name2 != null) {
				if (!eventImpl.getName2().equals(name2)) {
					continue;
				}
			}
			eventList.add(eventImpl);
		}
		return eventList;
	}

	public void removeEvent(int eventId) {
		assert eventId >= 0:"eventId negative " + eventId;
		
		EventImpl eventImpl = this.eventMap.remove(eventId);
		eventImpl.setInvalid();
		
	}
	
	void listEvent() {
		
		System.out.println(eventMap.values());
	}


}

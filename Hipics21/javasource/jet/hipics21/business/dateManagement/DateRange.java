package jet.hipics21.business.dateManagement;

	import java.util.Calendar;
	import java.util.GregorianCalendar;

	public class DateRange {

	    private final GregorianCalendar from;
	    private final GregorianCalendar to;

	    public DateRange(final GregorianCalendar from, final GregorianCalendar to) {
	        final int fromYear = from.get(Calendar.YEAR);
	        final int fromMonth = from.get(Calendar.MONTH);
	        final int fromDay = from.get(Calendar.DAY_OF_MONTH);
	        final GregorianCalendar fromCalendar = new GregorianCalendar(fromYear, fromMonth, fromDay, 0, 0, 0);
	        final int toYear = to.get(Calendar.YEAR);
	        final int toMonth = to.get(Calendar.MONTH);
	        final int toDay = to.get(Calendar.DAY_OF_MONTH);
	        final GregorianCalendar toCalendar = new GregorianCalendar(toYear, toMonth, toDay, 23, 59, 59);
	        if (fromCalendar.compareTo(toCalendar) > 0) {
	            throw new IllegalArgumentException("From date (" + fromCalendar + ") is greater than to date (" + toCalendar);
	        }
	        this.from = fromCalendar;
	        this.to = toCalendar;
	    }

	    public final GregorianCalendar getFrom() {
	        return this.from;
	    }

	    public final GregorianCalendar getTo() {
	        return this.to;
	    }

	    public boolean isInRange(final Calendar anotherCalendar) {
	        return getFrom().compareTo(anotherCalendar) <= 0 && getTo().compareTo(anotherCalendar) >= 0;
	    }

	    public static void main(final String[] args) {
	        final DateRange dr = new DateRange(new GregorianCalendar(2012, 0, 1), new GregorianCalendar(2012, 11, 31));
	        System.out.println("2011-12-31 " + dr.isInRange(new GregorianCalendar(2011, 11, 31)));
	        System.out.println("2012-01-01 " + dr.isInRange(new GregorianCalendar(2012, 0, 1)));
	        System.out.println("2012-11-11 " + dr.isInRange(new GregorianCalendar(2012, 10, 11)));
	        System.out.println("2012-12-31 " + dr.isInRange(new GregorianCalendar(2012, 11, 31)));
	        System.out.println("2013-01-01 " + dr.isInRange(new GregorianCalendar(2013, 0, 1)));
	    }

	}


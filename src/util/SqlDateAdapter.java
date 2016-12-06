package util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SqlDateAdapter extends XmlAdapter<String, Date> {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT;
    static {
        SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public String marshal(Date date) throws Exception {
        if(null == date) {
            return null;
        }
        String stringDate = SIMPLE_DATE_FORMAT.format(date);
        return stringDate;
    }

    @Override
    public Date unmarshal(String stringDate) throws Exception {
        if(null == stringDate || stringDate.equals("")) {
            return null;
        }
        try {
            java.util.Date utilDate = SIMPLE_DATE_FORMAT.parse(stringDate);
            Date sqlDate = new Date(utilDate.getTime());
            return sqlDate;
        } catch (ParseException e) {
            throw new RuntimeException("The given date format <~" + stringDate + "~> is not correct.", e);
        }
    }

}

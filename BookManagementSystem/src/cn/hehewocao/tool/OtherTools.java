package cn.hehewocao.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OtherTools {

	
	  public static boolean isValidDate(String strDate) {
	       
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            // ����lenientΪfalse. ����SimpleDateFormat��ȽϿ��ɵ���֤���ڣ�����2018-02-29�ᱻ���ܣ���ת����2018-03-01 
	            
	            format.setLenient(false);
	            Date date = format.parse(strDate);
	            
	            //�жϴ����yyyy��-MM��-dd�� �ַ����Ƿ�Ϊ����
	            String[] sArray = strDate.split("-");
	            for (String s : sArray) {
	                boolean isNum = s.matches("[0-9]+");
	                //+��ʾ1����������"3"��"225"����*��ʾ0��������[0-9]*������""��"1"��"22"����?��ʾ0����1��([0-9]?)(��""��"7")
	                if (!isNum) {
	                    return false;
	                }
	            }
	        } catch (Exception e) {
	            // e.printStackTrace();
	            // ���throw java.text.ParseException����NullPointerException����˵����ʽ����
	            return false;
	        }
	 
	        return true;
	    }

}

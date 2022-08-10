package br.com.gvdexport.util;

import java.io.IOException;
import java.net.InetAddress;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;


@Named
@Stateless
public class TimeLookUp {
	String[] hosts = new String[] {"a.st1.ntp.br","b.st1.ntp.br","c.st1.ntp.br","d.st1.ntp.br","a.ntp.br"};
		public Long buscatempo() {
			FacesContext context = FacesContext.getCurrentInstance();
	        NTPUDPClient timeClient = new NTPUDPClient();
	        long returnTime = 0;
	        timeClient.setDefaultTimeout(2000);
			for (String host: hosts) { 
				try {
			        InetAddress inetAddress = InetAddress.getByName(host);
		            TimeInfo timeInfo = timeClient.getTime(inetAddress);
		            returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();   //server time
				    return returnTime;
				}catch (IOException ex) {
				}
			}
			if (returnTime == 0   ) {
				context.addMessage(null, new FacesMessage("Não foi possivel obter data de Servidor On Line NIC,verificar!"));
			}
			return null;
		}
}
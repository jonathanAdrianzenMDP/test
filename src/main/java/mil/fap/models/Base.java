/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;


public class Base {

        private String estado;

        private String feccreacio;

        private String fecmodific;

        private String usucreacio;

        private String usumodific;
        
	private String ipTerminal;
        
        private String hostname;
	
         public String getEstado() {
             return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getFeccreacio() {
            return feccreacio;
        }

        public void setFeccreacio(String feccreacio) {
            this.feccreacio = feccreacio;
        }

        public String getFecmodific() {
            return fecmodific;
        }

        public void setFecmodific(String fecmodific) {
            this.fecmodific = fecmodific;
        }

        public String getUsucreacio() {
            if(usucreacio == null){
                try{
                    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    usucreacio = user.getUsername();
                }catch(Exception ex){
                    usucreacio = "ERROR GET USUCREACIO";
                }
                
            }
            return usucreacio;
        }

        public void setUsucreacio(String usucreacio) {
            this.usucreacio = usucreacio;
        }

        public String getUsumodific() {
            if(usumodific == null){
                try{
                    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    usumodific = user.getUsername();
                }catch(Exception ex){
                    usumodific = "ERROR GET USUMODIFIC";
                }
            }
            return usumodific;
        }

        public void setUsumodific(String usumodific) {
            this.usumodific = usumodific;
        }

    /**
     * @return the ipTerminal
     */
    public String getIpTerminal(){
        try{
        InetAddress ip = InetAddress.getLocalHost();
        ipTerminal = ip.toString();
        return ipTerminal;
        }catch(Exception ex){
            return "";
        }
    }

    /**
     * @param ipTerminal the ipTerminal to set
     */
    public void setIpTerminal(String ipTerminal) {
        this.ipTerminal = ipTerminal;
    }

    /**
     * @return the hostname
     */
    public String getHostname() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        hostname = ip.getHostName();
        return hostname;
    }

    /**
     * @param hostname the hostname to set
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    
	

	
	
}

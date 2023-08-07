/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import mil.fap.models.DocumentoAdjunto;
import mil.fap.models.helpers.Message;
import mil.fap.security.encrypt.Sequence;
import mil.fap.service.UsuarioService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public final class Util {

    private static final Integer seed = 7;
    
    UsuarioService usuarioService;
    
    public static Date toDate(String date, String format) {
        try {
            SimpleDateFormat oFormatter = new SimpleDateFormat(format);
            return oFormatter.parse(date);
        } catch (Exception exception) {
            System.err.printf("EXCEPTION@toDate method: %s", exception.getMessage());
            return null;
        }
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.equals("");
    }

    public static String encrypt(String value) {
        return new Sequence().encrypt(value, seed);
    }

    public static String decrypt(String value) {
        return new Sequence().decrypt(value, seed);
    }

    public static List<Object> listDistinct(List<Object> lista) {
        SortedSet<Object> listaN = new TreeSet<>();
        listaN.addAll(lista);
        lista.clear();
        for (Object obj : listaN) {
            if (!lista.contains(obj)) {
                lista.add(obj);
            }
        }
        return lista;
    }
    public static String getYearNow() {
        SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return DATE_TIME_FORMAT.format(date);
    }
    public Message sendFileServer(MultipartHttpServletRequest request, String urlServidor) throws IOException{
        Message msj = new Message();
        File f = new File(urlServidor);
        if(!f.exists()){
           f.mkdirs();
        }
        DocumentoAdjunto obj = new DocumentoAdjunto();
        Iterator<String> itr = request.getFileNames();
       MultipartFile mpf = null;
 
        while(itr.hasNext()){
                mpf = request.getFile(itr.next());
                String nameFile = new SimpleDateFormat("ddMMyyHHmmss").format(new Date());
                nameFile = nameFile + mpf.getOriginalFilename().replace(" ", "-");
                obj.setURLDOC(urlServidor+ nameFile);
            try{
                FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(urlServidor+ nameFile));
                obj.setNOMDOC(nameFile);                
                msj.setSuccess(true);
                msj.setData(obj);
                msj.convert(Constantes.Mensajes.MensajeFileUploadExito);
                
            }
            catch(Exception ex){
                msj.setSuccess(false);
                msj.setData(obj);
                msj.setException(ex.getMessage());
                msj.setType(Constantes.Mensajes.typeError);
                msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
            }
            
        }
        
        return msj;
    }
    public static Boolean isUserloged(){
        if(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
         return true;    
        }
        return false;
    }
    public static String getUserloged(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }
    public static boolean hasRole(String role) {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
        SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean hasRole = false;
        for (GrantedAuthority authority : authorities) {
           hasRole = authority.getAuthority().equals(role);
           if (hasRole) {
                break;
           }
        }
        return hasRole;
      }  
     public static String getRole() {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
        SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String _role = "";
        for (GrantedAuthority authority : authorities) {
           
           _role += authority.getAuthority();
           
        }
        return _role;
      }
     
     public static byte[] readFileToByteArray(String urlFile){
         File file = new File(urlFile);
        FileInputStream fis = null;
        // Creating a byte array using the length of the file
        // file.length returns long which is cast to int
        byte[] bArray = new byte[(int) file.length()];
        try{
            fis = new FileInputStream(file);
            fis.read(bArray);
            fis.close();        
            
        }catch(IOException ioExp){
            ioExp.printStackTrace();
        }
        return bArray;
    }
     public static void writeBytesToFile(byte[] bFile, String fileDest) {
        try (FileOutputStream fileOuputStream = new FileOutputStream(fileDest)) {
            fileOuputStream.write(bFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
  
    public static void deleteFile(String urlFile) throws IOException{
        
        try
        { 
            Files.deleteIfExists(Paths.get(urlFile)); 
        } 
        catch(NoSuchFileException e) 
        { 
            System.out.println("No such file/directory exists"); 
        } 
        catch(DirectoryNotEmptyException e) 
        { 
            System.out.println("Directory is not empty."); 
        } 
        catch(IOException e) 
        { 
            System.out.println("Invalid permissions."); 
        } 
    }
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
 
    

}

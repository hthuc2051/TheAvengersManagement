/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.beans;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import thucnh.dtos.ArmorDTO;
import thucnh.dtos.MaterialDTO;

import thucnh.models.ArmorDAO;
import thucnh.models.MaterialDAO;

/**
 *
 * @author USER
 */
public class UpdateArmorAction {

    private static final String ERROR = "error";
    private static final String ADMIN = "admin";
    private static final String FOLDER = "web\\uploads\\";
    private String alert;
    private String armorCode, armorName, available, materialID, description;
    private File myFile;
    private String myFileFileName;
    List<String> weapons;

    public UpdateArmorAction() {

    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getArmorCode() {
        return armorCode;
    }

    public void setArmorCode(String armorCode) {
        this.armorCode = armorCode;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public String getMaterialID() {
        return materialID;
    }

    public void setMaterialID(String materialID) {
        this.materialID = materialID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<String> weapons) {
        this.weapons = weapons;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    public String getMyFileFileName() {
        return myFileFileName;
    }

    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }

    public String execute() throws Exception {
        String url = ERROR;
        ArmorDAO armorDAO = new ArmorDAO();
        MaterialDAO materialDAO = new MaterialDAO();
        boolean isAvailable = false;
        if (available.equalsIgnoreCase("Yes")) {
            isAvailable = true;
        }
        MaterialDTO materialDTO = materialDAO.getMaterialByID(Integer.parseInt(materialID));
        ArmorDTO armorDTO = new ArmorDTO(armorCode, armorName, description, isAvailable, materialDTO);
        boolean checkUpdate = armorDAO.update(armorDTO);
        int armorID = armorDAO.getArmorIDByArmorCode(armorCode);
        if (checkUpdate) {
            url = ADMIN;
            alert = "Update armor successfully";
            armorDAO.deleteArmorWeapon(armorID);
            if (weapons != null) {
                if (!weapons.isEmpty()) {
                    boolean checkInsertArmorWeapon = armorDAO.insertArmorWeapon(weapons, armorID);
                    if (!checkInsertArmorWeapon) {
                        alert = "Update armor failed1";
                    }
                }
            }

            if (myFile != null) {
                if (!uploadFile()) {
                    alert = "Update armor image failed2";
                }
            }
        } else {
            url = ADMIN;
            alert = "Update armor failed3";
        }
        return url;
    }

    public boolean uploadFile() throws Exception {
        boolean check = false;
        ServletRequest request = ServletActionContext.getRequest();
        ArmorDAO dao = new ArmorDAO();
        String fileName = "";

        String applicationPath = request.getServletContext().getRealPath("/");
        String[] temp = applicationPath.split("build");
        String folPath = temp[0] + FOLDER;
        File fileUpload = new File(folPath);
        if (!fileUpload.exists()) {
            fileUpload.mkdirs();
        }
        String dateForImage = new SimpleDateFormat("ddMMyyyHHmmss").format(Calendar.getInstance().getTime());
        fileName = dateForImage + myFileFileName;
        File file = new File(folPath, fileName);
        FileUtils.copyFile(myFile, file);
        check = dao.updateImage(fileName, armorCode);
        return check;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.io.Serializable;

/**
 *
 * @author Jonathan
 */
public class Pagination  {
    private Integer iStart;
    private Integer iEnd;
    private Integer iLength;
    private Integer iTotal;
    private Integer iFilteredTotal;
    private Integer iPage;
    private Integer iTotalPages;

    /**
     * @return the iStart
     */
    public Integer getiStart() {
        return iStart;
    }

    /**
     * @param iStart the iStart to set
     */
    public void setiStart(Integer iStart) {
        this.iStart = iStart;
    }

    /**
     * @return the iEnd
     */
    public Integer getiEnd() {
        return iEnd;
    }

    /**
     * @param iEnd the iEnd to set
     */
    public void setiEnd(Integer iEnd) {
        this.iEnd = iEnd;
    }

    /**
     * @return the iLength
     */
    public Integer getiLength() {
        return iLength;
    }

    /**
     * @param iLength the iLength to set
     */
    public void setiLength(Integer iLength) {
        this.iLength = iLength;
    }

    /**
     * @return the iTotal
     */
    public Integer getiTotal() {
        return iTotal;
    }

    /**
     * @param iTotal the iTotal to set
     */
    public void setiTotal(Integer iTotal) {
        this.iTotal = iTotal;
    }

    /**
     * @return the iFilteredTotal
     */
    public Integer getiFilteredTotal() {
        return iFilteredTotal;
    }

    /**
     * @param iFilteredTotal the iFilteredTotal to set
     */
    public void setiFilteredTotal(Integer iFilteredTotal) {
        this.iFilteredTotal = iFilteredTotal;
    }

    /**
     * @return the iPage
     */
    public Integer getiPage() {
        return iPage;// + 1;
    }

    /**
     * @param iPage the iPage to set
     */
    public void setiPage(Integer iPage) {
        this.iPage = iPage;
    }

    /**
     * @return the iTotalPages
     */
    public Integer getiTotalPages() {
        return iTotalPages;
    }

    /**
     * @param iTotalPages the iTotalPages to set
     */
    public void setiTotalPages(Integer iTotalPages) {
        this.iTotalPages = iTotalPages;
    }
}

package com.weblink.zbcommunity.bean.requestbean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by swq on 2016/7/25.
 */
public class LoanInitBean implements Serializable {


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * id : 8
     * contactId : 0a1fd19938364c3ebad2016fd950a089
     * clientId : 11398
     * clientName :
     * loanAmount : 1
     * borrowPeriod : 12
     * loanBeginDate : 1467302400000
     * loanEndDate : 1498752000000
     * payTypename :
     * installmentType : 3
     * loanPurposeId : 2
     * loanPurposeTitle : 家电采购
     * loanReson :
     * inputdate : 1468944000000
     * statusId : 2
     * loanInfo : null
     * confirmDate : null
     * confirmUserId : null
     * confirmUserName : null
     */

    private String status;
    private ContractBean contract;
    /**
     * id : 27
     * loanId : 8
     * contactid : 0a1fd19938364c3ebad2016fd950a089
     * period : 1
     * loanpayid : null
     * npayclientid : null
     * npayaccount : null
     * repayAmount : 10
     * principal : null
     * interest : null
     * interestrate : null
     * comfirmUserId : null
     * comfirmUserName : null
     * repayDate : 1468944000000
     * repayActualDate : null
     * inputDate : null
     * repayType : null
     * statusId : 5
     */

    private List<RepayListBean> repayList;

    public ContractBean getContract() {
        return contract;
    }

    public void setContract(ContractBean contract) {
        this.contract = contract;
    }

    public List<RepayListBean> getRepayList() {
        return repayList;
    }

    public void setRepayList(List<RepayListBean> repayList) {
        this.repayList = repayList;
    }

    public static class ContractBean {
        private int id;
        private String contactId;
        private int clientId;
        private String clientName;
        private int loanAmount;
        private int borrowPeriod;
        private long loanBeginDate;
        private long loanEndDate;
        private String payTypename;
        private int installmentType;
        private int loanPurposeId;
        private String loanPurposeTitle;
        private String loanReson;
        private long inputdate;
        private String statusId;
        private Object loanInfo;
        private Object confirmDate;
        private Object confirmUserId;
        private Object confirmUserName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContactId() {
            return contactId;
        }

        public void setContactId(String contactId) {
            this.contactId = contactId;
        }

        public int getClientId() {
            return clientId;
        }

        public void setClientId(int clientId) {
            this.clientId = clientId;
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public int getLoanAmount() {
            return loanAmount;
        }

        public void setLoanAmount(int loanAmount) {
            this.loanAmount = loanAmount;
        }

        public int getBorrowPeriod() {
            return borrowPeriod;
        }

        public void setBorrowPeriod(int borrowPeriod) {
            this.borrowPeriod = borrowPeriod;
        }

        public long getLoanBeginDate() {
            return loanBeginDate;
        }

        public void setLoanBeginDate(long loanBeginDate) {
            this.loanBeginDate = loanBeginDate;
        }

        public long getLoanEndDate() {
            return loanEndDate;
        }

        public void setLoanEndDate(long loanEndDate) {
            this.loanEndDate = loanEndDate;
        }

        public String getPayTypename() {
            return payTypename;
        }

        public void setPayTypename(String payTypename) {
            this.payTypename = payTypename;
        }

        public int getInstallmentType() {
            return installmentType;
        }

        public void setInstallmentType(int installmentType) {
            this.installmentType = installmentType;
        }

        public int getLoanPurposeId() {
            return loanPurposeId;
        }

        public void setLoanPurposeId(int loanPurposeId) {
            this.loanPurposeId = loanPurposeId;
        }

        public String getLoanPurposeTitle() {
            return loanPurposeTitle;
        }

        public void setLoanPurposeTitle(String loanPurposeTitle) {
            this.loanPurposeTitle = loanPurposeTitle;
        }

        public String getLoanReson() {
            return loanReson;
        }

        public void setLoanReson(String loanReson) {
            this.loanReson = loanReson;
        }

        public long getInputdate() {
            return inputdate;
        }

        public void setInputdate(long inputdate) {
            this.inputdate = inputdate;
        }

        public String getStatusId() {
            return statusId;
        }

        public void setStatusId(String statusId) {
            this.statusId = statusId;
        }

        public Object getLoanInfo() {
            return loanInfo;
        }

        public void setLoanInfo(Object loanInfo) {
            this.loanInfo = loanInfo;
        }

        public Object getConfirmDate() {
            return confirmDate;
        }

        public void setConfirmDate(Object confirmDate) {
            this.confirmDate = confirmDate;
        }

        public Object getConfirmUserId() {
            return confirmUserId;
        }

        public void setConfirmUserId(Object confirmUserId) {
            this.confirmUserId = confirmUserId;
        }

        public Object getConfirmUserName() {
            return confirmUserName;
        }

        public void setConfirmUserName(Object confirmUserName) {
            this.confirmUserName = confirmUserName;
        }
    }

    public static class RepayListBean {
        private int id;
        private int loanId;
        private String contactid;
        private int period;
        private Object loanpayid;
        private Object npayclientid;
        private Object npayaccount;
        private double repayAmount;
        private Object principal;
        private Object interest;
        private Object interestrate;
        private Object comfirmUserId;
        private Object comfirmUserName;
        private long repayDate;
        private String repayActualDate;
        private Object inputDate;
        private Object repayType;
        private String statusId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLoanId() {
            return loanId;
        }

        public void setLoanId(int loanId) {
            this.loanId = loanId;
        }

        public String getContactid() {
            return contactid;
        }

        public void setContactid(String contactid) {
            this.contactid = contactid;
        }

        public int getPeriod() {
            return period;
        }

        public void setPeriod(int period) {
            this.period = period;
        }

        public Object getLoanpayid() {
            return loanpayid;
        }

        public void setLoanpayid(Object loanpayid) {
            this.loanpayid = loanpayid;
        }

        public Object getNpayclientid() {
            return npayclientid;
        }

        public void setNpayclientid(Object npayclientid) {
            this.npayclientid = npayclientid;
        }

        public Object getNpayaccount() {
            return npayaccount;
        }

        public void setNpayaccount(Object npayaccount) {
            this.npayaccount = npayaccount;
        }

        public double getRepayAmount() {
            return repayAmount;
        }

        public void setRepayAmount(int repayAmount) {
            this.repayAmount = repayAmount;
        }

        public Object getPrincipal() {
            return principal;
        }

        public void setPrincipal(Object principal) {
            this.principal = principal;
        }

        public Object getInterest() {
            return interest;
        }

        public void setInterest(Object interest) {
            this.interest = interest;
        }

        public Object getInterestrate() {
            return interestrate;
        }

        public void setInterestrate(Object interestrate) {
            this.interestrate = interestrate;
        }

        public Object getComfirmUserId() {
            return comfirmUserId;
        }

        public void setComfirmUserId(Object comfirmUserId) {
            this.comfirmUserId = comfirmUserId;
        }

        public Object getComfirmUserName() {
            return comfirmUserName;
        }

        public void setComfirmUserName(Object comfirmUserName) {
            this.comfirmUserName = comfirmUserName;
        }

        public long getRepayDate() {
            return repayDate;
        }

        public void setRepayDate(long repayDate) {
            this.repayDate = repayDate;
        }

        public String getRepayActualDate() {
            return repayActualDate;
        }

        public void setRepayActualDate(String repayActualDate) {
            this.repayActualDate = repayActualDate;
        }

        public Object getInputDate() {
            return inputDate;
        }

        public void setInputDate(Object inputDate) {
            this.inputDate = inputDate;
        }

        public Object getRepayType() {
            return repayType;
        }

        public void setRepayType(Object repayType) {
            this.repayType = repayType;
        }

        public String getStatusId() {
            return statusId;
        }

        public void setStatusId(String statusId) {
            this.statusId = statusId;
        }
    }
}


package org.aitdgoa.utils;

public class customerdata {
    int cid;
    String cname,phno,address;
    public customerdata(int cid,String cname,String phno,String address)
    {
        this.cid=cid;
        this.cname=cname;
        this.phno=phno;
        this.address=address;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}

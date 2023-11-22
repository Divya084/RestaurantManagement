
package org.aitdgoa.utils;

public class locationdata {
    
    String branch, phno;
    int rid;

    public locationdata(int rid, String branch,String phno) {
          this.rid = rid;
          this.branch = branch;
        this.phno = phno;
 
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

}

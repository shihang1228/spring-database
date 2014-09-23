package com.baldurtech.entity;

public class Contact
{
    private Long id;
    private String name;
    private String mobile;
    private String vpmn;
    private String email;
    private String homeAddress;
    private String officeAddress;
    private String memo;
    private String job;
    private Long jobLevel;
    private String department;
    private Long departmentId;
    
    public void setId(Long id)
    {
        this.id = id;
    }
    public Long getId()
    {
        return this.id;
    }
     
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
    public String getMobile()
    {
        return this.mobile;
    }

    public void setVpmn(String vpmn)
    {
        this.vpmn = vpmn;
    }
    public String getVpmn()
    {
        return this.vpmn;
    }
     
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return this.email;
    }
          
    public void setHomeAddress(String homeAddress)
    {
        this.homeAddress = homeAddress;
    }
    public String getHomeAddress()
    {
        return this.homeAddress;
    }
    public void setOfficeAddress(String officeAddress)
    {
        this.officeAddress = officeAddress;
    }
    public String getOfficeAddress()
    {
        return this.officeAddress;
    }
    public void setMemo(String memo)
    {
        this.memo = memo;
    }
    public String getMemo()
    {
        return this.memo;
    }
    public void setJob(String job)
    {
        this.job = job;
    }
    public String getJob()
    {
        return this.job;
    }
    public void setJobLevel(Long jobLevel)
    {
        this.jobLevel = jobLevel;
    }
    public Long getJobLevel()
    {
        return this.jobLevel;
    }
    
    public void setDepartment(String department)
    {
        this.department = department;

    }
    public String getDepartment()
    {
        return this.department;
    }
    public void setDepartmentId(Long departmentId)
    {
        this.departmentId = departmentId;
    }
    public Long getDepartmentId()
    {
        return this.departmentId;
    }
    
    @Override
    public String toString()
    {
        return String.format("Contact[id=%d, name='%s', mobile='%s']", id, name, mobile);
    }

}

